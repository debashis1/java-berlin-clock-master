package com.ubs.opsit.interviews.service;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.dto.Time;
import com.ubs.opsit.interviews.timeConverters.HourTimeConverterUtil;
import com.ubs.opsit.interviews.timeConverters.MinuteTimeConverterUtil;
import com.ubs.opsit.interviews.timeConverters.SecondTimeConverterUtil;

//@Service //TODO: Make it as service, class as package private
public class BerlinTimeConverterServiceImpl implements BerlinTimeConverterService{
	private SecondTimeConverterUtil secondTimeConverterUtil = new SecondTimeConverterUtil();
	private HourTimeConverterUtil hourTimeConverterUtil = new HourTimeConverterUtil();
	private MinuteTimeConverterUtil minuteTimeConverterUtil = new MinuteTimeConverterUtil();
	@Override
	public List<String> getTime(Time time) {
		List<String> berlinClockTime = null;
		if(time != null) {
			berlinClockTime = new ArrayList<>(5);
			String [] berlinClockSecondRows = secondTimeConverterUtil.getConvertedTime(time.getSs());
			for(String berlinClockSecondIndicator: berlinClockSecondRows) {
				berlinClockTime.add(berlinClockSecondIndicator);
			}
			
			String [] berlinClockHourRows = hourTimeConverterUtil.getConvertedTime(time.getHh());
			for(String berlinClockHourIndicator: berlinClockHourRows) {
				berlinClockTime.add(berlinClockHourIndicator);
			}
			
			String [] berlinClockMinuteRows = minuteTimeConverterUtil.getConvertedTime(time.getMm());
			for(String berlinClockMinuteIndicator: berlinClockMinuteRows) {
				berlinClockTime.add(berlinClockMinuteIndicator);
			}
		}
		
		return berlinClockTime;
	}

}
