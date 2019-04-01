package com.chyn.allianz.twitter;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("twitter")
public class TwitterController {

	@Autowired
	private TwitterRealTimeDataService dataCollector;

	@Autowired
	private TwitterStatService statService;
	
	@RequestMapping(value = "/top/user-retweet", method = RequestMethod.GET)
	public Map<String, Object> downloadCheckDirectInstance() {
		return statService.getTopRetweetUser();
	}

	@RequestMapping(value = "/top/user-retweet/last-distance", method = RequestMethod.GET)
	public Map<String, Object> getLastTopRetweetDistance() {
		return statService.getLastTopRetweetDistance();
	}
	
	@RequestMapping(value = "/top/user-connected-user", method = RequestMethod.GET)
	public Map<String, Object> getTopConnectedUser() {
		return statService.getMostConnectedUser();
	}
	
	@RequestMapping(value = "/collector/status", method = RequestMethod.GET)
	public Status isRealtimeDataCollectionStart() {
		boolean isStarted = dataCollector.isStarted();
		Status status = new Status();
		status.setLastCollectedRawJson(dataCollector.getLastCollectedRasJson());
		if (isStarted) {
			status.setCode(1);
			status.setDescr("Started");
		} else {
			status.setCode(0);
			status.setDescr("Not Started");
		}
		return status;
	}

	@RequestMapping(value = "/collector/start", method = RequestMethod.GET)
	public Status startRealTimeDataCollection() {
		boolean isStarted = dataCollector.startDataCollection();
		Status status = new Status();
		if (isStarted) {
			status.setCode(1);
			status.setDescr("Started");
		} else {
			status.setCode(0);
			status.setDescr("Not Started");
		}
		return status;
	}

	@RequestMapping(value = "/collector/stop", method = RequestMethod.GET)
	public Status stopRealTimeDataCollection() {
		boolean isStarted = dataCollector.stopDataCollection();
		Status status = new Status();
		if (isStarted) {
			status.setCode(1);
			status.setDescr("Started");
		} else {
			status.setCode(0);
			status.setDescr("Not Started");
		}
		return status;
	}

}
