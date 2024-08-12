package com.Blocksone.L1X.Swap_Utility;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Library {
	public static WebDriver driver;
	public static ExtentTest test;
	public static void custom_click(WebElement element,String fieldname) {
		try {
		if(element.isEnabled()) {
			element.click();
			test.log(Status.PASS, fieldname +"==clicked succssfully");
		}
		}catch(Exception e){
		
			test.log(Status.FAIL, fieldname +"==unable to click =="+e);
		}
	}
}
	


