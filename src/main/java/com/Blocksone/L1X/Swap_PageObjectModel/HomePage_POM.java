package com.Blocksone.L1X.Swap_PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_POM {
	
	@FindBy(xpath="(//p[text()='Swap'])[1]")
	private WebElement btn_Swap;
	
	@FindBy(xpath="//p[text()='Transaction Details']")
	private WebElement verify_SwapPage;
	
	@FindBy(xpath="(//div[@class='d-flex align-items-center value-input']//descendant::input)[1]")
	private WebElement input_SourceField;
		
	@FindBy(xpath="//input[@placeholder='0.0']//following-sibling::p")
	private WebElement verify_DestionationField;

	public WebElement getBtn_Swap() {
		return btn_Swap;
	}

	public void setBtn_Swap(WebElement btn_Swap) {
		this.btn_Swap = btn_Swap;
	}

	public WebElement getVerify_SwapPage() {
		return verify_SwapPage;
	}

	public void setVerify_SwapPage(WebElement verify_SwapPage) {
		this.verify_SwapPage = verify_SwapPage;
	}

	public WebElement getInput_SourceField() {
		return input_SourceField;
	}

	public void setInput_SourceField(WebElement input_SourceField) {
		this.input_SourceField = input_SourceField;
	}

	public WebElement getVerify_DestionationField() {
		return verify_DestionationField;
	}

	public void setVerify_DestionationField(WebElement verify_DestionationField) {
		this.verify_DestionationField = verify_DestionationField;
	}

}
