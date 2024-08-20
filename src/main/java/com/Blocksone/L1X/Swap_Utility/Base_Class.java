package com.Blocksone.L1X.Swap_Utility;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Blocksone.L1X.Swap_PageObjectModel.HomePage_POM;
import com.Blocksone.L1X.Swap_PageObjectModel.SwapPage_POM;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public static WebDriver driver;
	public static ConfigDataProvider config;
	public static HomePage_POM hp;
	public static SwapPage_POM sp;
	public static WebDriverWait wait;


	@BeforeSuite
	public void configureFile() throws FileNotFoundException
	{
		config = new ConfigDataProvider();
	}

	@BeforeMethod
	public void open_Browser()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");


		driver = new ChromeDriver(options);
		driver.get(config.getProductionUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@AfterMethod(enabled=true)
	public void close_Browser()
	{       
		driver.quit();

	}
	/**
	 * Common Methods
	 * @throws InterruptedException 
	 */
	public static void sendTestData() throws InterruptedException
	{
		hp = PageFactory.initElements(driver, HomePage_POM.class);
		sp = PageFactory.initElements(driver, SwapPage_POM.class);
		//		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		hp.getInput_SourceField().sendKeys("enter"+Keys.ENTER);
		hp.getInput_SourceField().sendKeys(config.sendTestData());

		try {

			String expectedDestinationValue = sp.getVerify_DestionationField().getText();
			String notDestinationValue = config.verify_DestionationField();

			Assert.assertNotEquals(expectedDestinationValue, notDestinationValue, 
					"Swap operation did not yield the expected result. The destination field value is incorrect.");

			Library.test.log(Status.PASS, "Swap is Successful. The expected value(Is Not equals to 0$) is displayed in the destination field.");
		} catch (AssertionError e) {
			Library.test.log(Status.FAIL, "Swap operation failed. The expected value(Is Not equals to 0$) was not displayed in the destination field. " +
					e.getMessage());
			throw e;

		}
	}
	public static void stopSwapIfUpdateWindowAppears()
	{
		if(sp.getSwapUpdateWindow().isDisplayed())
		{
		    String swapUpdateWindowText = sp.getSwapUpdateWindow().getText();
		    Assert.assertEquals(swapUpdateWindowText, config.verify_SwapUpdateWindow(),
		            "Swap is being updated: Do not perform swap functionality.");
		    Library.test.log(Status.SKIP, "close the driver");
		    driver.close();
		}
		    else
		    {
			    Library.test.log(Status.INFO, "No update winodw please go for swap");

		    }
		
		  
		}

		
	}
