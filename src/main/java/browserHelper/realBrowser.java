package browserHelper;

import java.io.IOException;

import commonUtils.propertyFileUtil;

public class realBrowser {
	private String browsertype,browserbaseurl;
	public static realBrowser realbrowser;
	
	private realBrowser() throws IOException {
	startBrowser();	
	}
	
	
	//Singleton to ensure only one instance exists of realbrowser
	public static realBrowser getInstance() throws IOException {
		
		if (realbrowser==null){
			return new realBrowser();
		}
		
		return realbrowser;
		
	}
	
	
	public void startBrowser() throws IOException {
	
		browsertype=propertyFileUtil.getInstance().getProperty("browser.type");
		browserbaseurl=propertyFileUtil.getInstance().getProperty("browser.base.url");
		
		
	}
}
