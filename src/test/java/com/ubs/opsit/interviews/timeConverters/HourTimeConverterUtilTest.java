package com.ubs.opsit.interviews.timeConverters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HourTimeConverterUtilTest {
	private HourTimeConverterUtil hourTimeConverterUtil = null;
	
	@Before
	public void beforeTest() {
		hourTimeConverterUtil = new HourTimeConverterUtil();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConvertedTimeWhenLessThan0() {
		int time = -1;
		String[] berlinClockMinute = hourTimeConverterUtil.getConvertedTime(time);
	}
	
	@Test
	public void testGetConvertedTimeWhen0() {
		int time = 0;
		String[] expected = {"OOOO", "OOOO"};
		
		String[] berlinClockMinute = hourTimeConverterUtil.getConvertedTime(time);
		
		Assert.assertNotNull(berlinClockMinute);
		Assert.assertTrue(berlinClockMinute.length > 0);
		Assert.assertArrayEquals(expected, berlinClockMinute);
	}
	
	@Test
	public void testGetConvertedTimeWhen59() {
		int time = 23;
		String[] expected = {"RRRR", "RRRO"};
		
		String[] berlinClockMinute = hourTimeConverterUtil.getConvertedTime(time);
		
		Assert.assertNotNull(berlinClockMinute);
		Assert.assertTrue(berlinClockMinute.length > 0);
		Assert.assertArrayEquals(expected, berlinClockMinute);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConvertedTimeWhen24() {
		int time = 24;
		
		String[] berlinClockMinute = hourTimeConverterUtil.getConvertedTime(time);
	}
}
