package com.Blocksone.L1X.Swap_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerClass implements IRetryAnalyzer{

	private int retryCount=0;
	private int maxRetryCount=3;

	
	@Override
	public boolean retry(ITestResult result) {
		if(retryCount<maxRetryCount)
		{
			retryCount++;
			return true;
		}
		return false;
	}

}


