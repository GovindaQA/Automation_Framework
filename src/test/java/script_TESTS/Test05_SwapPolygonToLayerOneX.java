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

public class Test05_SwapPolygonToLayerOneX extends Base_Class {

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
	public void verifySwap_BetweenPolygonAndLayerOneX() throws InterruptedException {
		clickonSwapAndVerifyPage();
		if(!sp.getSwapUpdateWindow().isDisplayed())
		{
			// Click on the destination chain dropdown and select LayerOneX
			Library.custom_click(sp.getDestinationChainDropdown(), "Click on destination chain Dropdown");
			Library.custom_click(sp.getDestinationChain_LayerOneX3(), "Select LayerOneX as destination chain");

			// Verify the selection of LayerOneX as the destination chain
			try {
				String verifySelectionL1X = sp.getVerifySelectionOfSourceOrDestinationChain().getText();
				Assert.assertEquals(verifySelectionL1X, config.verifyChainSelection_SourceOrDestination_LayerOneX(), 
						"Verification of the selected destination chain LayerOneX failed.");
				Library.test.log(Status.PASS, "Verification of the selected destination chain for LayerOneX has been successfully completed.");
			} catch (AssertionError e) {
				Library.test.log(Status.FAIL, "Verification of the selected destination chain LayerOneX failed: " + e.getMessage());
				throw e;
			}

			// Click to select the source token for L1X
			Library.custom_click(sp.getDestinationToken_L1X3(), "Select Source Token L1X");

			// Click on the source chain dropdown and select Polygon
			Library.custom_click(sp.getSourceChainDropdown(), "Click on source chain Dropdown");
			Library.custom_click(sp.getSourceChain_Polygon2(), "Select Polygon as source chain");

			// Verify the selection of Polygon as the source chain
			try {
				String verifySelectionPl = sp.getVerifySelectionOfSourceOrDestinationChain().getText();
				Assert.assertEquals(verifySelectionPl, config.verifyChainSelection_SourceOrDestination_Polygon(), 
						"Verification of the selected source chain Polygon failed.");
				Library.test.log(Status.PASS, "Verification of the selected source chain for Polygon has been successfully completed.");
			} catch (AssertionError e) {
				Library.test.log(Status.FAIL, "Verification of the selected source chain Polygon failed: " + e.getMessage());
				throw e;
			}

			// Click to select the source token for MaticPolygon
			Library.custom_click(sp.getSourceToken_MaticPolygon1(), "Select Source Token MaticPolygon");

			Base_Class.sendTestData();

		}
		else
		{
			Library.test.log(Status.SKIP, config.stopVerifyingSwap());

		}
	}
}

