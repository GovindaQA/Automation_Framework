package script_TESTS;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Blocksone.L1X.Swap_PageObjectModel.SwapPage_POM;
import com.Blocksone.L1X.Swap_Utility.Base_Class;
import com.Blocksone.L1X.Swap_Utility.Library;
import com.aventstack.extentreports.Status;

public class Test03_SwapAvalancheToOptimism extends Base_Class {

	private static SwapPage_POM sp;
	private static WebDriverWait wait;

	@BeforeMethod()
	public void setUp() {
		sp = PageFactory.initElements(driver, SwapPage_POM.class);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	private static void clickonSwapAndVerifyPage() {
		Library.custom_click(sp.getBtn_Swap(), "Initiate swap operation by clicking the Swap button");

		try {
			String transactionText = sp.getVerify_SwapPage().getText();
			Assert.assertEquals(transactionText, config.verify_SwapPage(), "The expected Swap page text does not match the actual text.");
			Library.test.log(Status.PASS, "Successfully navigated to the Swap page after clicking the Swap button.");
		} catch (AssertionError e) {
			Library.test.log(Status.FAIL, "Navigation to the Swap page failed after clicking the Swap button");
			throw e;
		}
	}

	@Test()
	public void verifySwap_AvalancheToOptimism() {
		clickonSwapAndVerifyPage();
		
		// check if update window is appeared then skip the test	
		if(!sp.getSwapUpdateWindow().isDisplayed())
		{
			// Click on the source chain dropdown and select Avalanche
			Library.custom_click(sp.getSourceChainDropdown(), "Click on source chain Dropdown");
			Library.custom_click(sp.getSourceChain_Avalanche4(), "Select Avalanche as source chain");

			// Verify the selection of Avalanche as the source chain
			try {
				String verifySelectionAv = sp.getVerifySelectionOfSourceOrDestinationChain().getText();
				Assert.assertEquals(verifySelectionAv, config.verifyChainSelection_SourceOrDestination_Avalanche(),
						"Verification of the selected source chain Avalanche failed.");
				Library.test.log(Status.PASS, "Verification of the selected source chain for Avalanche has been successfully completed.");
			} catch (AssertionError e) {
				Library.test.log(Status.FAIL, "Verification of the selected source chain Avalanche failed: " + e.getMessage());
				throw e;
			}

			// Click to select the source token for Avalanche
			Library.custom_click(sp.getSourceToken_AvalancheToken(), "Select Source Token AvalancheToken");

			// Click on the destination chain dropdown and select Optimism
			Library.custom_click(sp.getDestinationChainDropdown(), "Click on destination chain Dropdown");
			Library.custom_click(sp.getDestinationChain_Optimism2(), "Select Optimism as destination chain");

			// Verify the selection of Optimism as the destination chain
			try {
				String verifySelectionOp = sp.getVerifySelectionOfSourceOrDestinationChain().getText();
				Assert.assertEquals(verifySelectionOp, config.verifyChainSelection_SourceOrDestination_Optimism(),
						"Verification of the selected destination chain Optimism failed.");
				Library.test.log(Status.PASS, "Verification of the selected destination chain for Optimism has been successfully completed.");
			} catch (AssertionError e) {
				Library.test.log(Status.FAIL, "Verification of the selected destination chain Optimism failed: " + e.getMessage());
				throw e;
			}

			Library.custom_click(sp.getDestinationToken_OptimismToken(), "Select Destination Token OptimismToken");   
			try {
				Base_Class.sendTestData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			Library.test.log(Status.SKIP, config.stopVerifyingSwap());

		}


	}
}

