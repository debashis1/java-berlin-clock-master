package com.ubs.opsit.interviews.timeConverters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SecondTimeConverterUtilTest {
	private SecondTimeConverterUtil secondTimeConverterUtil = null;
	
	@Before
	public void beforeTest() {
		secondTimeConverterUtil = new SecondTimeConverterUtil();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConvertedTimeWhenLessThan0() {
		int time = -1;
		String[] berlinClockSecond = secondTimeConverterUtil.getConvertedTime(time);
	}
	
	@Test
	public void testGetConvertedTimeWhen0() {
		int time = 0;
		String[] expected = {"Y"};
		
		String[] berlinClockSecond = secondTimeConverterUtil.getConvertedTime(time);
		
		Assert.assertNotNull(berlinClockSecond);
		Assert.assertTrue(berlinClockSecond.length > 0);
		Assert.assertArrayEquals(expected, berlinClockSecond);
	}
	
	@Test
	public void testGetConvertedTimeWhen59() {
		int time = 59;
		String[] expected = {"O"};
		
		String[] berlinClockSecond = secondTimeConverterUtil.getConvertedTime(time);
		
		Assert.assertNotNull(berlinClockSecond);
		Assert.assertTrue(berlinClockSecond.length > 0);
		Assert.assertArrayEquals(expected, berlinClockSecond);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetConvertedTimeWhen60() {
		int time = 60;
		String[] expected = {"O"};
		
		String[] berlinClockSecond = secondTimeConverterUtil.getConvertedTime(time);
	}
}
