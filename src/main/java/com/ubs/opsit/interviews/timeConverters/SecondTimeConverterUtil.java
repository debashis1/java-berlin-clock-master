package com.ubs.opsit.interviews.timeConverters;

public class SecondTimeConverterUtil implements TimeConverterUtil {
	private static String secondBulbOn = "Y";
	private static String secondBulbOff = "O";
	@Override
	public String[] getConvertedTime(int time){
		String[] secondString = null;
		if(0 <= time && time < 60) {
			secondString = new String[1];
			if(time % 2 == 0) {
				secondString[0] = secondBulbOn;
			}else {
				secondString[0] = secondBulbOff;
			}
		}else {
			throw new IllegalArgumentException("Invalid Input second.");
		}
		
		return secondString;
	}

}
