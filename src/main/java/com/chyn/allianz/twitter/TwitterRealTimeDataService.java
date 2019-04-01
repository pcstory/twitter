package com.chyn.allianz.twitter;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.neo4j.driver.v1.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chyn.allianz.rawjson.twitter.RawRetweetJson;
import com.chyn.allianz.twitter.util.QueryGenerator;
import com.chyn.allianz.twitter.util.Util;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import twitter4j.FilterQuery;
import twitter4j.RawStreamListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Service
public class TwitterRealTimeDataService implements AutoCloseable {

	private boolean isStarted;

	private TwitterStream twitterStream;

	private Session session;

	private String lastCollectedJson;

	@Autowired
	private QueryGenerator queryGenerator;

	@Autowired
	private Util util;

	private final Logger log = LoggerFactory.getLogger(TwitterRealTimeDataService.class);

	public boolean isStarted() {
		return isStarted;
	}

	public boolean startDataCollection() {
		session = util.getDriver().session();

		TwitterStreamFactory factory = new TwitterStreamFactory();
		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
		Pattern p = Pattern.compile("\"retweet_count\"\\:[1-9]");

		twitterStream = factory.getInstance().addListener(new RawStreamListener() {

			@Override
			public void onException(Exception ex) {
				log.error("onException", ex);
			}

			@Override
			public void onMessage(String rawString) {
				log.info(rawString);
				if (isCreatedStatus(rawString) && isRetweet(rawString)) {
					RawRetweetJson tweet = gson.fromJson(rawString, RawRetweetJson.class);

					try {
						String query = queryGenerator.generateQuery(tweet);
						log.debug(query);
						session.runAsync(query);
						lastCollectedJson = rawString;

					} catch (UnsupportedEncodingException e) {
						log.error("onMessage Error", e);
						e.printStackTrace();
					}
				}
			}

			private boolean isRetweet(String rawString) {
				Matcher m = p.matcher(rawString);
				return m.find();
			}

			private boolean isCreatedStatus(String rawString) {
				if (rawString.startsWith("{\"created_at\"")) {
					return true;
				} else {
					log.debug("skip :" + rawString);
					return false;
				}
			}

		});
		FilterQuery fq = new FilterQuery();
		double[][] usLocation = { { -130.56, 23.59 }, { -77.09, 48.77 } };
		fq.locations(usLocation);
		fq.filterLevel("none");
		twitterStream.filter(fq); // No Retweet Status, only contain geolocation
		// twitterStream.sample();
		isStarted = true;
		return isStarted;
	}

	public String getLastCollectedRasJson() {
		return lastCollectedJson;
	}

	public boolean stopDataCollection() {
		isStarted = false;
		if (twitterStream != null)
			twitterStream.cleanUp();
		if (session != null)
			session.close();
		return isStarted;
	}

	@Override
	public void close() throws Exception {
		stopDataCollection();
	}

}
