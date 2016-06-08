package com.skp.countdownlatchWithServiceExecuter.test;

import com.skp.countdownlatchWithServiceExecuter.util.ApplicationStartupUtil;

public class Main {
	public static void main(String[] args) 
	{
		boolean result = false;
		try {
			result = ApplicationStartupUtil.checkExternalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("External services validation completed !! Result was :: "+ result);
	}
}
