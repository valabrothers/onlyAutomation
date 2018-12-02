package browserHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class chromeOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/resources/chromedriver_2.44.exe");
		
		//chromeOptions options=new chromeOptions();
		
		ChromeOptions options =new ChromeOptions();
		
		options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("disable-infobars");
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        
        options.addArguments("--incognito"); //to start browser in incognito
        
        //both does same thing --- browser in headless mode
        /*
        options.addArguments("--headless");
        options.setHeadless(true);
        */
        
//   options.addArguments("--print-to-pdf");


        
        
        
        //options.setBinary("/path/to/other/chrome/binary"); //Using a Chrome executable in a non-standard location

        
        //***Use custom profile (also called user data directory)
        options.addArguments("user-data-dir=C:/Users/LENOVO/AppData/Local/Google/Chrome/User Data");

        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("download.default_directory", "C:\\Downloads"); 
        
        options.setExperimentalOption("prefs", prefs);
        
        
        
        //Passing capabilities to ChromeDriver constructor is Deprecated from v3.6.0. You can still have your capabilities defined, but make sure you merge these capabilities with ChromeOptions like below:        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PLATFORM_NAME,"WINDOWS");
        options.merge(capabilities);

/*        
chrome_options.add_argument('--disable-extensions')
options.addExtensions(new File(""));

options.setProxy(proxy);
options.setCapability(capabilityName, value);

*/

        WebDriver driver=new ChromeDriver(options);

		driver.get("http://google.com/");
        System.out.println("User profile==>" + options.getCapability("userDataDir"));
        System.out.println("Current Chrome Version==>" + options.getCapability("download.default_directory"));
		
		System.out.println("Done");
	}

}


/*
 * 
 * https://www.seleniumeasy.com/selenium-tutorials/using-chrome-options-for-webdriver-tests
 * https://sites.google.com/a/chromium.org/chromedriver/capabilities
 * https://chromium.googlesource.com/chromium/src/+/master/chrome/common/chrome_switches.cc
 * https://developers.google.com/web/updates/2018/10/nic70
 * https://peter.sh/experiments/chromium-command-line-switches/
 * 
 */
