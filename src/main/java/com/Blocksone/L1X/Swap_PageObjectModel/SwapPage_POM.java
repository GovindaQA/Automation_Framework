package com.Blocksone.L1X.Swap_PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwapPage_POM {
	/**
	 * WebElements from HomePAgePOM
	 */
	@FindBy(xpath="(//p[text()='Swap'])[1]")
	private WebElement btn_Swap;
	
	@FindBy(xpath="//p[text()='Transaction Details']")
	private WebElement verify_SwapPage;
	
	@FindBy(xpath="(//div[@class='d-flex align-items-center value-input']//descendant::input)[1]")
	private WebElement input_SourceField;
		
	@FindBy(xpath="//input[@placeholder='0.0']//following-sibling::p")
	private WebElement verify_DestionationField;
	
	
	/**
	 * WebElements from SwapPAgePOM
	 */
	@FindBy(xpath="(//div[@class='currency-name'])//child::h4[text()='ETH']")
	private WebElement sourceChainDropdown;
	
	@FindBy(xpath="(//div[@class='col p-0']//descendant::h4)[2]")
	private WebElement destinationChainDropdown;
	
	@FindBy(xpath="//div[@class='row choose-network']//descendant::p[text()='Ethereum']")
	private WebElement sourceChain_Ethereun1;
	
	@FindBy(xpath="//div[@class='row choose-network']//descendant::p[text()='Polygon']")
	private WebElement sourceChain_Polygon2;
	
	@FindBy(xpath="//div[@class='row choose-network']//descendant::p[text()='Binance']")
	private WebElement sourceChain_Binance;
	
	@FindBy(xpath="//div[@class='row choose-network']//descendant::p[text()='Avalanche']")
	private WebElement sourceChain_Avalanche4;
	
	@FindBy(xpath="(//div[@class='row choose-network']//descendant::div)[6]")
	private WebElement destinationChain_Binance1;
	
	@FindBy(xpath="(//div[@class='row choose-network']//descendant::div)[10]")
	private WebElement destinationChain_Optimism2;
	
	@FindBy(xpath="(//div[@class='row choose-network']//descendant::div)[16]")
	private WebElement destinationChain_LayerOneX3;
	
	@FindBy(xpath="//div[contains(@class,'d-flex align-items-center second-head')]//child::h4")
	private WebElement verifySelectionOfSourceOrDestinationChain;
	
	
	
	
	
	@FindBy(xpath="//p[normalize-space()='MATIC']")
	private WebElement sourceToken_MaticPolygon1 ;
	
	@FindBy(xpath="//p[normalize-space()='AVAX']")
	private WebElement sourceToken_AvalancheToken ;
	
	@FindBy(xpath="//p[normalize-space()='BNB']")
	private WebElement SourceToken_BinanceToken;
	
	@FindBy(xpath="//p[normalize-space()='BNB']")
	private WebElement destinationToken_BNBBinance1;
	
	@FindBy(xpath="//p[normalize-space()='ETH']")
	private WebElement destinationToken_OptimismToken;
	
	@FindBy(xpath="//div[@class='row choose-token']//div[1]//div[1]")
	private WebElement destinationToken_MaticPolygon;
	
	@FindBy(xpath="//p[normalize-space()='L1X']")
	private WebElement destinationToken_L1X3;
	
	
	
	

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

	public WebElement getSourceChainDropdown() {
		return sourceChainDropdown;
	}

	public void setSourceChainDropdown(WebElement sourceChainDropdown) {
		this.sourceChainDropdown = sourceChainDropdown;
	}

	public WebElement getDestinationChainDropdown() {
		return destinationChainDropdown;
	}

	public void setDestinationChainDropdown(WebElement destinationChainDropdown) {
		this.destinationChainDropdown = destinationChainDropdown;
	}

	public WebElement getSourceChain_Ethereun1() {
		return sourceChain_Ethereun1;
	}

	public void setSourceChain_Ethereun1(WebElement sourceChain_Ethereun1) {
		this.sourceChain_Ethereun1 = sourceChain_Ethereun1;
	}

	public WebElement getSourceChain_Polygon2() {
		return sourceChain_Polygon2;
	}

	public void setSourceChain_Polygon2(WebElement sourceChain_Polygon2) {
		this.sourceChain_Polygon2 = sourceChain_Polygon2;
	}



	public WebElement getSourceChain_Avalanche4() {
		return sourceChain_Avalanche4;
	}

	public void setSourceChain_Avalanche4(WebElement sourceChain_Avalanche4) {
		this.sourceChain_Avalanche4 = sourceChain_Avalanche4;
	}

	public WebElement getDestinationChain_Binance1() {
		return destinationChain_Binance1;
	}

	public void setDestinationChain_Binance1(WebElement destinationChain_Binance1) {
		this.destinationChain_Binance1 = destinationChain_Binance1;
	}

	public WebElement getDestinationChain_Optimism2() {
		return destinationChain_Optimism2;
	}

	public void setDestinationChain_Optimism2(WebElement destinationChain_Optimism2) {
		this.destinationChain_Optimism2 = destinationChain_Optimism2;
	}

	public WebElement getDestinationChain_LayerOneX3() {
		return destinationChain_LayerOneX3;
	}

	public void setDestinationChain_LayerOneX3(WebElement destinationChain_LayerOneX3) {
		this.destinationChain_LayerOneX3 = destinationChain_LayerOneX3;
	}

	public WebElement getSourceToken_MaticPolygon1() {
		return sourceToken_MaticPolygon1;
	}

	public void setSourceToken_MaticPolygon1(WebElement sourceToken_MaticPolygon1) {
		this.sourceToken_MaticPolygon1 = sourceToken_MaticPolygon1;
	}

	

	



	public WebElement getDestinationToken_BNBBinance1() {
		return destinationToken_BNBBinance1;
	}

	public void setDestinationToken_BNBBinance1(WebElement destinationToken_BNBBinance1) {
		this.destinationToken_BNBBinance1 = destinationToken_BNBBinance1;
	}

	

	

	public WebElement getDestinationToken_MaticPolygon() {
		return destinationToken_MaticPolygon;
	}

	public void setDestinationToken_MaticPolygon(WebElement destinationToken_MaticPolygon) {
		this.destinationToken_MaticPolygon = destinationToken_MaticPolygon;
	}

	public WebElement getDestinationToken_L1X3() {
		return destinationToken_L1X3;
	}

	public void setDestinationToken_L1X3(WebElement destinationToken_L1X3) {
		this.destinationToken_L1X3 = destinationToken_L1X3;
	}

	public WebElement getVerifySelectionOfSourceOrDestinationChain() {
		return verifySelectionOfSourceOrDestinationChain;
	}

	public void setVerifySelectionOfSourceOrDestinationChain(WebElement verifySelectionOfSourceOrDestinationChain) {
		this.verifySelectionOfSourceOrDestinationChain = verifySelectionOfSourceOrDestinationChain;
	}

	public WebElement getSourceToken_AvalancheToken() {
		return sourceToken_AvalancheToken;
	}

	public void setSourceToken_AvalancheToken(WebElement sourceToken_AvalancheToken) {
		this.sourceToken_AvalancheToken = sourceToken_AvalancheToken;
	}

	public WebElement getDestinationToken_OptimismToken() {
		return destinationToken_OptimismToken;
	}

	public void setDestinationToken_OptimismToken(WebElement destinationToken_OptimismToken) {
		this.destinationToken_OptimismToken = destinationToken_OptimismToken;
	}

	public WebElement getSourceChain_Binance() {
		return sourceChain_Binance;
	}

	public void setSourceChain_Binance(WebElement sourceChain_Binance) {
		this.sourceChain_Binance = sourceChain_Binance;
	}

	public WebElement getSourceToken_BinanceToken() {
		return SourceToken_BinanceToken;
	}

	public void setSourceToken_BinanceToken(WebElement sourceToken_BinanceToken) {
		SourceToken_BinanceToken = sourceToken_BinanceToken;
	}
	
	
	
	
	
	

}
