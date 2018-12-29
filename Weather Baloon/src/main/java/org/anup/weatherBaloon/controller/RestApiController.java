package org.anup.weatherBaloon.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

import org.anup.weatherBaloon.model.BaloonLog;
import org.anup.weatherBaloon.service.BaloonLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	BaloonLogService baloonLogService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All BaloonLogs---------------------------------------------

	@RequestMapping(value = "/baloonLog/", method = RequestMethod.GET)
	public ResponseEntity<List<BaloonLog>> listAllBaloonLogs() {
		List<BaloonLog> baloonLogs = baloonLogService.findAllBaloonLogs();
		if (baloonLogs.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<BaloonLog>>(baloonLogs, HttpStatus.OK);
	} 

	// -------------------Retrieve Minimum Temperature------------------------------------------

	@GetMapping(value = "/baloonLog/minTemp/")
	public ResponseEntity<?> getMinTemp() {
		logger.info("Fetching Min Temp");

		List<BaloonLog> logs =baloonLogService.findAllBaloonLogs();
		TreeSet<Integer> minTemp = new TreeSet<Integer>();
		for(BaloonLog log : logs){
			minTemp.add(log.getTemperature());
		}


		return new ResponseEntity<Integer>(minTemp.first() ,HttpStatus.OK);
	}

	// -------------------Retrieve Maximum Temperature------------------------------------------

	@GetMapping(value = "/baloonLog/maxTemp/")
	public ResponseEntity<?> getMaxTemp() {
		logger.info("Fetching Min Temp");

		List<BaloonLog> logs =baloonLogService.findAllBaloonLogs();
		TreeSet<Integer> minTemp = new TreeSet<Integer>();
		for(BaloonLog log : logs){
			minTemp.add(log.getTemperature());
		}

		return new ResponseEntity<Integer>(minTemp.last() ,HttpStatus.OK);
	}

	// -------------------Retrieve Mean Temperature------------------------------------------

	@GetMapping(value = "/baloonLog/meanTemp/")
	public ResponseEntity<?> getMeanTemp() {
		logger.info("Fetching Min Temp");

		List<BaloonLog> logs =baloonLogService.findAllBaloonLogs();
		TreeSet<Integer> minTemp = new TreeSet<Integer>();
		for(BaloonLog log : logs){
			minTemp.add(log.getTemperature());
		}

		return new ResponseEntity<Integer>((minTemp.first()+minTemp.last())/2 ,HttpStatus.OK);
	}

	// -------------------Retrieve Mean Temperature------------------------------------------

	@GetMapping(value = "/baloonLog/totDis/")
	public ResponseEntity<?> getTotalDistance() {
		logger.info("Fetching Min Temp");

		List<BaloonLog> logs =baloonLogService.findAllBaloonLogs();
		Integer totDis = 0;
		for(BaloonLog log : logs){
			totDis = totDis + log.getTemperature();
		}

		return new ResponseEntity<Integer>(totDis ,HttpStatus.OK);
	}

	// -------------------Retrieve Mean Temperature------------------------------------------

	@GetMapping(value = "/baloonLog/numOfObserv/")
	public ResponseEntity<?> getNumberOfObservations() {
		logger.info("Fetching Min Temp");

		List<BaloonLog> logs = baloonLogService.findAllBaloonLogs();
		Integer obsAU = 0;
		Integer obsUS = 0;
		Integer obsFR = 0;
		Integer obsOther = 0;
		for(BaloonLog log : logs){
			if("AU".equals(log.getObservatory()))
				obsAU++;
			else if("US".equals(log.getObservatory()))
				obsUS++;
			else if("FR".equals(log.getObservatory()))
				obsFR++;
			else
				obsOther++;
		}	
		
		Map<String,Integer> obsMap = new HashMap<String,Integer>();
		obsMap.put("obsAU", obsAU);
		obsMap.put("obsUS", obsUS);
		obsMap.put("obsFR", obsFR);
		obsMap.put("obsOther", obsOther);

		return new ResponseEntity<Map<String,Integer>>(obsMap ,HttpStatus.OK);
	}

	// -------------------Create a BaloonLog-------------------------------------------

	@RequestMapping(value = "/baloonLog/generate/", method = RequestMethod.GET)
	public ResponseEntity<?> generateBaloonLog() {
		logger.info("Creating BaloonLog");
		for(int i=0; i<100; i++){
			BaloonLog baloonLog = new BaloonLog();
			long offset = Timestamp.valueOf("2012-01-01 00:00:00").getTime();
			long end = Timestamp.valueOf("2018-01-01 00:00:00").getTime();
			long diff = end - offset + 1;
			Timestamp timestamp = new Timestamp(offset + (long)(Math.random() * diff));

			int latitude = -90 + new Random().nextInt(181);
			int longitude = -180 + new Random().nextInt(361);
			String location = latitude + "," + longitude;

			String[] s = {"AU", "US", "FR", "IN", "MX"};
			String observatory = s[new Random().nextInt(s.length)];
			Integer temperature = -90 + new Random().nextInt(191);

			baloonLog.setTimestamp(timestamp.toString());
			baloonLog.setLocation(location);
			baloonLog.setObservatory(observatory);
			baloonLog.setTemperature(temperature);

			baloonLogService.saveBaloon(baloonLog);
		}

		return new ResponseEntity<String>(HttpStatus.CREATED);
	}


	// ------------------- Delete All BaloonLogs-----------------------------

	@RequestMapping(value = "/baloonLog/", method = RequestMethod.DELETE)
	public ResponseEntity<BaloonLog> deleteAllBaloonLogs() {
		logger.info("Deleting All BaloonLogs");

		baloonLogService.deleteAllBaloonLogs();
		return new ResponseEntity<BaloonLog>(HttpStatus.NO_CONTENT);
	}

}