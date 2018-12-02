package browserHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class remoteBrowser {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		ffRemote();		
		chromeRemote();

}
public static void ffRemote() throws MalformedURLException {
	
	/*firefoxOptions.Profile.SetPreference("webdriver.log.driver", "OFF");
	Environment.SetEnvironmentVariable("webdriver.firefox.logfile", "/dev/null");
	*/
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/geckodriver.exe"); 
	
	DesiredCapabilities capabilities = DesiredCapabilities.firefox(); 
	//FirefoxBinary binary = // path of the firefox.exe 
	FirefoxOptions options = new FirefoxOptions(); 

	options.setLogLevel(Level.ALL); 
	
	capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options); 
	RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:11000/wd/hub"), capabilities);
	
	driver.get("http://google.com");
	System.out.println("connected google using remote ff - ==> Title= " + driver.getTitle());
	driver.quit();
}
	
	public static void chromeRemote() throws MalformedURLException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver_2.44.exe");
		
		
		DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PLATFORM_NAME, "WINDOWS");
        caps.setCapability(CapabilityType.BROWSER_VERSION, "70.0.3538.110");
        caps.setCapability(CapabilityType.BROWSER_NAME, "chrome");

        WebDriver driver1 = null;
        
        try {
        	driver1 = new RemoteWebDriver(new URL("http://localhost:11000/wd/hub"), caps);
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        driver1.get("http://google.com/");

//System.out.println(caps.getCapability(CapabilityType.BROWSER_NAME));
        
        System.out.println("connected google using remote chrome - ==> Title is : "+driver1.getTitle());
        driver1.quit();
	
	}
}


/*
 * https://www.seleniumeasy.com/selenium-tutorials/configure-selenium-grid-using-json-config-file
 */
