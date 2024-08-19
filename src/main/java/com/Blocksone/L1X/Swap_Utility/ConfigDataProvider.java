package com.Blocksone.L1X.Swap_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	public static Properties pro;
	
	public ConfigDataProvider() throws FileNotFoundException
	{
		String filepath="./Properties/config.properties";
		FileInputStream file = new FileInputStream(filepath);
		pro = new Properties();
		try {
			pro.load(file);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public String getProductionUrl()
	{
		return  pro.getProperty("productionUrl");
	}
	public String verify_SwapPage()
	{
		return  pro.getProperty("verify_Swap_Page");

	}
	public String verify_DestionationField()
	{
		return pro.getProperty("verifyDestionationField");
	}
	
	public String verifyChainSelection_SourcePolygon()
	{
		return pro.getProperty("verifyChainSelection_SourcePolygon");
	}
	public String verifyChainSelection_SourceOrDestination_Polygon()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Polygon");
	}
	public String verifyChainSelection_SourceOrDestination_Ethereum()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Ethereum");
	}
	public String verifyChainSelection_SourceOrDestination_Binance()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Binance");
	}
	public String verifyChainSelection_SourceOrDestination_Avalanche()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Avalanche");
	}
	public String verifyChainSelection_SourceOrDestination_Optimism()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Optimism");
	}
	public String verifyChainSelection_SourceOrDestination_Arbitrum()
	{
		
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Arbitrum");
	}
	public String verifyChainSelection_SourceOrDestination_Solana()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_Solana");
	}
	
	public String verifyChainSelection_SourceOrDestination_LayerOneX()
	{
		return pro.getProperty("verifyChainSelection_SourceOrDestination_LayerOneX");
	}
	public String sendTestData()
	{
		return pro.getProperty("sendTestData");
	}
	
	public String verify_SwapUpdateWindow()
	{
		return pro.getProperty("verify_SwapUpdateWindow");
	}
	
	
	
	
}	
	
	