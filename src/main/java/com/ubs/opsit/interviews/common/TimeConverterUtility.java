package com.ubs.opsit.interviews.common;

import org.apache.commons.lang.StringUtils;

import com.ubs.opsit.interviews.dto.Time;

public class TimeConverterUtility {
	public static Time convertStringToTime(String inputTime) throws IllegalArgumentException{
		Time time = null;
		if(StringUtils.isNotEmpty(inputTime)) {
			time = new Time();
			String[] splittedTime = inputTime.split(":");
			if(splittedTime.length == 3) {
				int hour = Integer.parseInt(splittedTime[0]);
				if(hour >= 0 && hour < 24) {
					time.setHh(hour);
				}else {
					throw new IllegalArgumentException("Invalid Input Hour.");
				}
				
				int minute = Integer.parseInt(splittedTime[1]);
				if(minute >= 0 && minute < 60) {
					time.setMm(minute);
				}else {
					throw new IllegalArgumentException("Invalid Input Minute.");
				}
				
				int second = Integer.parseInt(splittedTime[2]);
				if(second >= 0 && second < 60) {
					time.setSs(second);
				}else {
					throw new IllegalArgumentException("Invalid Input Second.");
				}
			}else {
				throw new IllegalArgumentException("Invalid Input Time.");
			}
		}else {
			throw new IllegalArgumentException("Invalid Input Time.");
		}
		return time;
	}
}
