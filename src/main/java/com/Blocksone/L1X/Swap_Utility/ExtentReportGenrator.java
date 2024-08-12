package com.Blocksone.L1X.Swap_Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenrator {
	
	public static ExtentReports extent;
	public static ExtentReports getReports() {
		
		String path=System.getProperty("user.dir")+"\\TestReport\\index.html";
		
		//ExtentSparkReporter --> Title,ReportName,Theme
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName(" Test Module-SWAP");
		reporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Module Name", "Swap");
		extent.setSystemInfo("QA Team", "Abhijeet Bhosale(Manager), Gaurav Dhole(QA), Govinda Chavhan(QA)");
		extent.setSystemInfo("O.S.", "Windows10");
		return extent;
	}

}
