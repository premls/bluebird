package com.bluebird.util;

import java.util.Date;

public class DateUtil {

	//TODO : check the logic
	public static Date getCurrentDate() {
		return new Date(System.currentTimeMillis() / 1000 * 1000);
	}
	
}
