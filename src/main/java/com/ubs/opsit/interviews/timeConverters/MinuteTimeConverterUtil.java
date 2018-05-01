package com.ubs.opsit.interviews.timeConverters;

public class MinuteTimeConverterUtil implements TimeConverterUtil{
	private static final String FIRSTROW_RESET = "OOOOOOOOOOO";
	private static final String SECONDROW_RESET = "OOOO";
    
    private static final String RED = "R";
    private static final String YELLOW = "Y";
    
	@Override
	public String[] getConvertedTime(int time){
		String[] minuteString = null;
		if(0 <= time && time < 60) {
			minuteString = new String[2];
			minuteString[0] = getFirstRow(time/5);
			minuteString[1] = getSecondRow(time%5);
		}else {
			throw new IllegalArgumentException("Invalid Input minute.");
		}
		return minuteString;
	}

	private String getFirstRow(int numberOfFirstRowLight) {
		StringBuilder firstRow = new StringBuilder(FIRSTROW_RESET);
		for (int i = 0; i < numberOfFirstRowLight; i++) {
            if (0 == (i + 1) % 3) {
            	firstRow.replace(i, i + 1, RED);
            } else {
            	firstRow.replace(i, i + 1, YELLOW);
            }
        }
		return firstRow.toString();
	}
	
	private String getSecondRow(int numberOfSecondRowLight) {
		StringBuilder secondRow = new StringBuilder(SECONDROW_RESET);
        for (int i = 0; i < numberOfSecondRowLight; i++) {
        	secondRow.replace(i, i + 1, YELLOW);
        }
        return secondRow.toString();
	}

}
