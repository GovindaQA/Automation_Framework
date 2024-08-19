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

public class Test04_SwapBinanceToOptimism extends Base_Class {

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
			Base_Class.stopSwapIfUpdateWindowAppears();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void verifySwap_BinanceToOptimism() {
		clickonSwapAndVerifyPage();

		// Click on the source chain dropdown and select Binance
		Library.custom_click(sp.getSourceChainDropdown(), "Click on source chain Dropdown");
		Library.custom_click(sp.getSourceChain_Binance(), "Select Binance as source chain");

		// Verify the selection of Binance as the source chain
		try {
			String verifySelectionBn = sp.getVerifySelectionOfSourceOrDestinationChain().getText();
			Assert.assertEquals(verifySelectionBn, config.verifyChainSelection_SourceOrDestination_Binance(),
					"Verification of the selected source chain Binance failed.");
			Library.test.log(Status.PASS, "Verification of the selected source chain for Binance has been successfully completed.");
		} catch (AssertionError e) {
			Library.test.log(Status.FAIL, "Verification of the selected source chain Binance failed: " + e.getMessage());
			throw e;
		}

		// Click to select the source token for Binance
		Library.custom_click(sp.getSourceToken_BinanceToken(), "Select Source Token BinanceToken");

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

	}

}

