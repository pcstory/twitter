package com.chyn.allianz.twitter;

import java.util.HashMap;
import java.util.Map;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.chyn.allianz.rawjson.google.DistanceJson;
import com.chyn.allianz.rawjson.google.Elements;
import com.chyn.allianz.rawjson.google.Rows;
import com.chyn.allianz.twitter.util.Util;

@Service
public class TwitterStatService {

	@Value("${app.allianz.twitter.google.api_key}")
	private String googleApiKey;

	@Value("${app.allianz.twitter.google.distancematrix.endpoint}")
	private String googleDistanceMatrixAPI;
	
	@Value("${app.allianz.twitter.neo4j.query.top-most-connected-user}")
	private String topMostConnectedUserQuery;

	@Value("${app.allianz.twitter.neo4j.query.top-retweet-user-location}")
	private String locationQuery;

	@Value("${app.allianz.twitter.neo4j.query.top-retweet-user}")
	private String topRetweetUserWithLocationQuery;


	@Autowired
	private Util util;

	private final Logger log = LoggerFactory.getLogger(TwitterStatService.class);
	
	public Map<String, Object> getTopRetweetUser() {
		try (Session session = util.getDriver().session()) {
			StatementResult result = session.run(topRetweetUserWithLocationQuery);
			while (result.hasNext()) {
				Record rc = result.single();
				return rc.asMap();
			}
			return null;
		}
	}


	public Map<String, Object> getLastTopRetweetDistance() {
		try (Session session = util.getDriver().session()) {
			StatementResult topUserResult = session.run(topRetweetUserWithLocationQuery);
			long topUserId = -1;
			while (topUserResult.hasNext()) {
				Record rc = topUserResult.single();
				Map<String, Object> map = rc.asMap();
				for (String key : map.keySet()) {
					log.debug(key + ":" + map.get(key));
				}
				topUserId = (Long) map.get("id");
				break;
			}
			Map<String, Object> params = new HashMap<>();
			params.put("top_user_id", topUserId);
			StatementResult locationResult = session.run(locationQuery, params);
			while (locationResult.hasNext()) {
				Record rc = locationResult.single();
				Map<String, Object> locations = rc.asMap();
				Map<String, Object> results = new HashMap<>();
				results.put("distance", "unkown");
				for (String key : locations.keySet()) {
					results.put(key, locations.get(key));
					log.debug(key + ":" + locations.get(key));
				}
				StringBuffer matrixAPIEndPoint = new StringBuffer(googleDistanceMatrixAPI);
				matrixAPIEndPoint.append("?origins=");
				String fromLocation = getURLParam(locations.get("last_avail_retweet_location"));
				matrixAPIEndPoint.append(fromLocation);
				matrixAPIEndPoint.append("&destinations=");
				String toLocation = getURLParam(locations.get("last_avail_author_location"));
				matrixAPIEndPoint.append(toLocation);
				matrixAPIEndPoint.append(googleApiKey);
				RestTemplate restTemplate = new RestTemplate();
				log.debug("matrix api " + matrixAPIEndPoint.toString());
				DistanceJson distanceJson = restTemplate.getForObject(matrixAPIEndPoint.toString(), DistanceJson.class);
				log.info(distanceJson.toString());
				if (distanceJson.getRows() != null && distanceJson.getRows().get(0) != null) {
					 Rows rows = distanceJson.getRows().get(0);
					 if (rows.getElements() != null && rows.getElements().get(0) != null) {
						 Elements element = rows.getElements().get(0);
						 if (element.getDistance() != null && element.getDistance().getText() != null) {
							 results.put("distance", element.getDistance().getText());
						 }
					 }
				}
				return results;
			}
		}
		return null;
	}

	private String getURLParam(Object object) {
		if (object != null) {
			String location = object.toString().replaceAll(" ", "+");
			return location;
		} else {
			return "USA";
		}
	}

	public Map<String, Object> getMostConnectedUser() {
		try (Session session = util.getDriver().session()) {
			StatementResult result = session.run(topMostConnectedUserQuery);
			while (result.hasNext()) {
				Record rc = result.single();
				return rc.asMap();
			}
			return null;
		}
	}

}
