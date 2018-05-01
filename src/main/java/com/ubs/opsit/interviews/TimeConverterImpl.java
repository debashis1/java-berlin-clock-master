package com.ubs.opsit.interviews;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.common.TimeConverterConstants;
import com.ubs.opsit.interviews.common.TimeConverterUtility;
import com.ubs.opsit.interviews.dto.Time;
import com.ubs.opsit.interviews.service.BerlinTimeConverterService;
import com.ubs.opsit.interviews.service.BerlinTimeConverterServiceImpl;

class TimeConverterImpl implements TimeConverter{
	private Logger logger = LoggerFactory.getLogger(TimeConverterImpl.class);
	private BerlinTimeConverterService berlinTimeConverterService;
	private final String NEW_ROW = "\n";
	
	@Override
	public String convertTime(String aTime) {
		logger.debug("Input Time: "+aTime);
		StringBuilder berlinClockTime = null;
		Time time = null;
		//Retrieve the Time object from input string.
		try {
			time = TimeConverterUtility.convertStringToTime(aTime);
			if(time != null) {
				berlinTimeConverterService = new BerlinTimeConverterServiceImpl();//TODO Instead of doing like this, use DI
				List<String> berlinClockTimeAsList = berlinTimeConverterService.getTime(time);
				berlinClockTime = new StringBuilder();
				for(String row : berlinClockTimeAsList) {
					berlinClockTime.append(row);
					berlinClockTime.append(NEW_ROW);
				}
			}
			
		}catch(IllegalArgumentException illegalArgumentException) {
			berlinClockTime = new StringBuilder(TimeConverterConstants.INVALID_INPUT);
		}
		logger.debug("Output Time: "+berlinClockTime.toString());
		return berlinClockTime.toString().trim();
	}


}
