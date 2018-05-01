package com.ubs.opsit.interviews.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.ubs.opsit.interviews.dto.Time;
import com.ubs.opsit.interviews.timeConverters.HourTimeConverterUtil;
import com.ubs.opsit.interviews.timeConverters.MinuteTimeConverterUtil;
import com.ubs.opsit.interviews.timeConverters.SecondTimeConverterUtil;

@RunWith(MockitoJUnitRunner.class)
public class BerlinTimeConverterServiceTest {
	private BerlinTimeConverterService berlinTimeConverterService;
	
	@Mock
	private SecondTimeConverterUtil secondTimeConverterUtil;
	@Mock
	private MinuteTimeConverterUtil minuteTimeConverterUtil;
	@Mock
	private HourTimeConverterUtil hourTimeConverterUtil;
	
	@Before
	public void beforeTest() {
		berlinTimeConverterService = new BerlinTimeConverterServiceImpl();
	}
	
	@Test
	public void testGetTimeNull() {
		List<String> berlinClockTime = berlinTimeConverterService.getTime(null);
		Assert.assertNull(berlinClockTime);
	}
	
	@Test
	public void testGetTimeNotNull() {
		Time time = new Time();
		List<String> berlinClockTime = berlinTimeConverterService.getTime(time);
		Assert.assertNotNull(berlinClockTime);
		Assert.assertEquals(5, berlinClockTime.size());
	}
}
