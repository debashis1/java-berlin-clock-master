package com.ubs.opsit.interviews.common;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.ubs.opsit.interviews.dto.Time;

@RunWith(BlockJUnit4ClassRunner.class)
public class TimeConverterUtilityTest {
	private static TimeConverterUtility timeConverterUtility;
	@BeforeClass
	public static void beforeClass() {
		timeConverterUtility = new TimeConverterUtility();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenNullInput() {
		Time time = timeConverterUtility.convertStringToTime(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenEmptyInput() {
		Time time = timeConverterUtility.convertStringToTime("");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenMoreThan3Element() {
		String inputTime = "12:12:12:12";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenNonIntTimeElement() {
		String inputTime = "12:12:1a";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenHourIsLessThan0() {
		String inputTime = "-2:12:06";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenHourIsMoreThan23() {
		String inputTime = "24:12:06";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenMinuteIsLessThan0() {
		String inputTime = "23:-1:06";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenMinuteIsMoreThan59() {
		String inputTime = "23:60:06";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenSecondIsLessThan0() {
		String inputTime = "23:59:-1";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInputTimeWhenSecondIsMoreThan59() {
		String inputTime = "23:59:60";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
	}
	
	@Test
	public void testInputTime() {
		String inputTime = "23:12:06";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
		Assert.assertNotNull(time);
		Assert.assertEquals(23, time.getHh());
		Assert.assertEquals(12, time.getMm());
		Assert.assertEquals(6, time.getSs());
	}
	@Test
	public void testInputTime000000() {
		String inputTime = "00:00:00";
		Time time = timeConverterUtility.convertStringToTime(inputTime);
		Assert.assertNotNull(time);
		Assert.assertEquals(0, time.getHh());
		Assert.assertEquals(0, time.getMm());
		Assert.assertEquals(0, time.getSs());
	}
}
