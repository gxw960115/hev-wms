package com.haier.hevwms.basic.service.impl;

import java.util.HashMap;
import java.util.Map;

public class BarParameters {
	public Map yearCode;
	public Map monthCode;
	public Map dayCode;

	public BarParameters() {
		yearCode = new HashMap();
		monthCode = new HashMap();
		dayCode = new HashMap();
		// 初始化YEAR CODE
		yearCode.put(2001, "1");
		yearCode.put(2002, "2");
		yearCode.put(2003, "3");
		yearCode.put(2004, "4");
		yearCode.put(2005, "5");
		yearCode.put(2006, "6");
		yearCode.put(2007, "7");
		yearCode.put(2008, "8");
		yearCode.put(2009, "9");
		yearCode.put(2010, "A");
		yearCode.put(2011, "B");
		yearCode.put(2012, "C");
		yearCode.put(2013, "D");
		yearCode.put(2014, "E");
		yearCode.put(2015, "F");
		yearCode.put(2016, "G");
		yearCode.put(2017, "H");
		yearCode.put(2018, "J");
		yearCode.put(2019, "K");
		yearCode.put(2020, "L");
		yearCode.put(2021, "M");
		yearCode.put(2022, "N");
		yearCode.put(2023, "P");
		yearCode.put(2024, "Q");
		yearCode.put(2025, "R");
		yearCode.put(2026, "S");
		yearCode.put(2027, "T");
		yearCode.put(2028, "U");
		yearCode.put(2029, "V");
		yearCode.put(2030, "W");
		yearCode.put(2031, "X");
		yearCode.put(2032, "Y");
		yearCode.put(2033, "Z");
		yearCode.put(2034, "0");
		yearCode.put(2035, "1");
		yearCode.put(2036, "2");
		yearCode.put(2037, "3");
		yearCode.put(2038, "4");
		yearCode.put(2039, "5");
		yearCode.put(2040, "6");
		yearCode.put(2041, "7");
		yearCode.put(2042, "8");
		yearCode.put(2043, "9");
		yearCode.put(2044, "A");
		// 初始化MONTH CODE
		monthCode.put(1, "1");
		monthCode.put(2, "2");
		monthCode.put(3, "3");
		monthCode.put(4, "4");
		monthCode.put(5, "5");
		monthCode.put(6, "6");
		monthCode.put(7, "7");
		monthCode.put(8, "8");
		monthCode.put(9, "9");
		monthCode.put(10, "A");
		monthCode.put(11, "B");
		monthCode.put(12, "C");
		// 初始化DAY CODE
		dayCode.put(1, "1");
		dayCode.put(2, "2");
		dayCode.put(3, "3");
		dayCode.put(4, "4");
		dayCode.put(5, "5");
		dayCode.put(6, "6");
		dayCode.put(7, "7");
		dayCode.put(8, "8");
		dayCode.put(9, "9");
		dayCode.put(10, "A");
		dayCode.put(11, "B");
		dayCode.put(12, "C");
		dayCode.put(13, "D");
		dayCode.put(14, "E");
		dayCode.put(15, "F");
		dayCode.put(16, "G");
		dayCode.put(17, "H");
		dayCode.put(18, "J");
		dayCode.put(19, "K");
		dayCode.put(20, "L");
		dayCode.put(21, "M");
		dayCode.put(22, "N");
		dayCode.put(23, "P");
		dayCode.put(24, "Q");
		dayCode.put(25, "R");
		dayCode.put(26, "S");
		dayCode.put(27, "T");
		dayCode.put(28, "U");
		dayCode.put(29, "V");
		dayCode.put(30, "W");
		dayCode.put(31, "X");
	}

	public Map getYearCode() {
		return yearCode;
	}

	public void setYearCode(Map yearCode) {
		this.yearCode = yearCode;
	}

	public Map getMonthCode() {
		return monthCode;
	}

	public void setMonthCode(Map monthCode) {
		this.monthCode = monthCode;
	}

	public Map getDayCode() {
		return dayCode;
	}

	public void setDayCode(Map dayCode) {
		this.dayCode = dayCode;
	}
	
}
