package com.service;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) throws Exception {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    int  num = (Integer.parseInt(sdf.format(sdf.parse("20180126"))) - Integer.parseInt(sdf.format(sdf.parse("19850530")))) / 10000;
	    System.out.println(sdf.format(sdf.parse("20180126")));
	    System.out.println(sdf.format(sdf.parse("19850530")));
	    System.out.println(num);
	}

}
