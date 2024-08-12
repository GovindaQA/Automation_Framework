package script_TESTS;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Blocksone.L1X.Swap_PageObjectModel.HomePage_POM;
import com.Blocksone.L1X.Swap_Utility.Base_Class;
import com.Blocksone.L1X.Swap_Utility.Library;
import com.aventstack.extentreports.Status;

public class Test01_SwapForDefaultChains extends Base_Class {
	
	@Test(description="This test verifies that when a value is entered in the source chain, the destination chain shows the converted value.")
	public void verify_Swap_SourceAndDestinationField()
	{
		HomePage_POM hp = PageFactory.initElements(driver, HomePage_POM.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click on the Swap button and verify the swap page
		Library.custom_click(hp.getBtn_Swap(), "Click on Swap Button");

		try {
		    String transactionText = hp.getVerify_SwapPage().getText();
		    Assert.assertEquals(transactionText, config.verify_SwapPage(), "Swap page verification failed.");
		    Library.test.log(Status.PASS, "Successfully landed on the swap page after clicking the Swap button.");
		} catch (AssertionError e) {
		    Library.test.log(Status.FAIL, "Failed to land on the swap page after clicking the Swap button: " + e.getMessage());
		    throw e;
		}
//		Get the common method from Base Class to send the Test Data

		Base_Class.sendTestData();

	}

}
