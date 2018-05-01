package com.ubs.opsit.interviews.timeConverters;

public class HourTimeConverterUtil implements TimeConverterUtil {
	private static final String ROW_RESET = "OOOO";
	private static final String RED = "R";
	@Override
	public String[] getConvertedTime(int time){
		String[] hourString = null;
		if(0 <= time && time < 24) {
			hourString = new String[2];
			hourString[0] = getFirstRow(time/5);
			hourString[1] = getSecondRow(time%5);
		}else {
			throw new IllegalArgumentException("Invalid Input hour.");
		}
		return hourString;
	}
	
	private String getFirstRow(int numberOfFirstRowLight) {
		StringBuilder firstRow = new StringBuilder(ROW_RESET);
        for (int i = 0; i < numberOfFirstRowLight; i++) {
        	firstRow.replace(i, i + 1, RED);
        }
        return firstRow.toString();
	}

	private String getSecondRow(int numberOfSecondRowLight) {
		StringBuilder secondRow = new StringBuilder(ROW_RESET);
        for (int i = 0; i < numberOfSecondRowLight; i++) {
        	secondRow.replace(i, i + 1, RED);
        }
        return secondRow.toString();
	}
}
