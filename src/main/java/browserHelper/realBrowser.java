package browserHelper;


public class realBrowser {

	
	/*
	 * 	private String browsertype;
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


	public WebDriver startBrowser() throws IOException {
		WebDriver driver=null;
		browsertype=propertyFileUtil.getInstance().getProperty("browser.type");
		propertyFileUtil.getInstance().getProperty("browser.base.url");

		if (browsertype.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/resources/chromedriver.exe");
			driver=new FirefoxDriver();

		}else if (browsertype.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/resources/geckodriver.exe");
			driver=new ChromeDriver();

		}else if (browsertype.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "/resources/IEDriverServer.exe");
			driver=new InternetExplorerDriver();

		}
		return driver;


	}
	*/
	
}
