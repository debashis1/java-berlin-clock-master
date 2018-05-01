package com.ubs.opsit.interviews.service;

import java.util.List;

import com.ubs.opsit.interviews.dto.Time;

public interface BerlinTimeConverterService {
	public List<String> getTime(Time time);
}
