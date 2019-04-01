package com.chyn.allianz.twitter.util;

import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import org.springframework.stereotype.Component;

import com.chyn.allianz.rawjson.twitter.RawRetweetJson;
import com.chyn.allianz.rawjson.twitter.User;


@Component
public class QueryGenerator {
	
	// TODO - Change to use neo4j statement
	public String generateQuery(RawRetweetJson tweet) throws UnsupportedEncodingException {
		StringBuffer fullQuery = new StringBuffer();
		MessageFormat fmt = null;
		//
		String user1Query = "MERGE (U1:User '{'mid:{0}'}') \n" //
				+ "ON MATCH SET U1.friends_count={1}, U1.followers_count={2}, U1.name=''{3}'', U1.location=''{4}'', U1.role=''both''\n"
				+ "ON CREATE SET U1.friends_count={1}, U1.followers_count={2}, U1.name=''{3}'', U1.location=''{4}'', U1.role=''retweeter''\n";
		User user = tweet.getUser();
		//
		long userId = user.getId();
		long friendCount = user.getFriends_count();
		long followerCount = user.getFollowers_count();
		String userName = user.getScreen_name();
		String location = "null";
		if (tweet.getPlace() != null && tweet.getPlace().getName() != null) {
			location = tweet.getPlace().getName();
		} else if (user.getLocation() != null){
			location = user.getLocation();
		}
		fmt = new MessageFormat(user1Query);
		fullQuery.append(fmt.format(new String[] { userId + "", friendCount + "", followerCount + "", userName, location }));
		//
		String user2Query = "MERGE (U2:User '{'mid:{0}'}')\n" //
				+ "ON MATCH SET U2.friends_count={1}, U2.followers_count={2}, U2.name=''{3}'', U2.location=''{4}'', U2.role=''both''\n"
				+ "ON CREATE SET U2.friends_count={1}, U2.followers_count={2}, U2.name=''{3}'', U2.location=''{4}'', U2.role=''author''\n";
		long originalTweetId = -1;
		if (tweet.isIs_quote_status()) {
			user = tweet.getQuoted_status().getUser();
			originalTweetId = tweet.getQuoted_status().getId();
		} else {
			user = tweet.getRetweeted_status().getUser();
			originalTweetId = tweet.getRetweeted_status().getId();
		}
		userId = user.getId();
		friendCount = user.getFriends_count();
		followerCount = user.getFollowers_count();
		userName = user.getScreen_name();
		location = user.getLocation();
		fmt = new MessageFormat(user2Query);
		fullQuery.append(fmt.format(new Object[] { userId + "", friendCount + "", followerCount + "", userName, location }));
		//
		String tweetQuery = "MERGE (T1:Tweet '{'mid:{0}, original_tweet_id:{1}, twcreated_at:''{2}'', text:''{3}''}')\n";
		long id = tweet.getId();
		String created = tweet.getCreated_at();
		String text = tweet.getText();
		fmt = new MessageFormat(tweetQuery);
		fullQuery.append(fmt.format(new Object[] { id + "", originalTweetId + "", created, text }));
		//
		String relationshipQuery = "MERGE (U1)-[:RETWEET]->(T1)\n" + "MERGE (U2)-[:POSTED]->(T1)\n";
		fullQuery.append(relationshipQuery);
		fullQuery.append(";");
		return fullQuery.toString();
	}

}
