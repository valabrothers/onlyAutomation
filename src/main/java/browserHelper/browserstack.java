package browserHelper;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class browserstack {


	public static final String USERNAME = "alpesh30";
	  public static final String AUTOMATE_KEY = "AoJyWphdz1GgT6CeWBqv";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {

	    DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "iPhone");
	    caps.setCapability("device", "iPhone 8 Plus");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "11");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();

	    //************************************
	    
	    DesiredCapabilities caps1 = new DesiredCapabilities();
	    caps1.setCapability("browser", "Chrome");
	    caps1.setCapability("browser_version", "72.0 beta");
	    caps1.setCapability("os", "Windows");
	    caps1.setCapability("os_version", "10");
	    caps1.setCapability("resolution", "1024x768");

	    WebDriver driver1 = new RemoteWebDriver(new URL(URL), caps);
	    driver1.get("http://www.google.com");
	    WebElement element1 = driver1.findElement(By.name("q"));

	    element1.sendKeys("BrowserStack on windows 10");
	    element1.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();
	    
	  }


}
