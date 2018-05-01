package com.ubs.opsit.interviews.timeConverters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinuteTimeConverterUtilTest {
	private MinuteTimeConverterUtil minuteTimeConverterUtil = null;
	
	@Before
	public void beforeTest() {
		minuteTimeConverterUtil = new MinuteTimeConverterUtil();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConvertedTimeWhenLessThan0() {
		int time = -1;
		String[] berlinClockMinute = minuteTimeConverterUtil.getConvertedTime(time);
	}
	
	@Test
	public void testGetConvertedTimeWhen0() {
		int time = 0;
		String[] expected = {"OOOOOOOOOOO", "OOOO"};
		
		String[] berlinClockMinute = minuteTimeConverterUtil.getConvertedTime(time);
		
		Assert.assertNotNull(berlinClockMinute);
		Assert.assertTrue(berlinClockMinute.length > 0);
		Assert.assertArrayEquals(expected, berlinClockMinute);
	}
	
	@Test
	public void testGetConvertedTimeWhen59() {
		int time = 59;
		String[] expected = {"YYRYYRYYRYY", "YYYY"};
		
		String[] berlinClockMinute = minuteTimeConverterUtil.getConvertedTime(time);
		
		Assert.assertNotNull(berlinClockMinute);
		Assert.assertTrue(berlinClockMinute.length > 0);
		Assert.assertArrayEquals(expected, berlinClockMinute);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConvertedTimeWhen60() {
		int time = 60;
		
		String[] berlinClockMinute = minuteTimeConverterUtil.getConvertedTime(time);
	}
}
