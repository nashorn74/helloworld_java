package com.test.helloworld;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {
	public String now() {
		SimpleDateFormat format =
			new SimpleDateFormat("HH시 mm분 ss초");
		return format.format(new Date());
	}
}
