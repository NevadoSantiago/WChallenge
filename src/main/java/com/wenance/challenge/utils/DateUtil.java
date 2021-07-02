package com.wenance.challenge.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getDateWhitoutMilliseconds(Date time) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
}
