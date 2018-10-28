package browserHelper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class headlessbrowser {

	public static void main (String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		firefox();
		chrome();
		htmlUnit();
	}
	
	public static void firefox() {
		   
	    String str = System.getProperty("user.dir");

		FirefoxBinary firefoxBinary = new FirefoxBinary();
		   firefoxBinary.addCommandLineOptions("--headless");
		   System.setProperty("webdriver.gecko.driver", str + "/resources/geckodriver.exe");
		   FirefoxOptions firefoxOptions = new FirefoxOptions();
		   firefoxOptions.setBinary(firefoxBinary);
		   FirefoxDriver driver = new FirefoxDriver(firefoxOptions);

		   try {
		     driver.get("http://www.google.com");
		     driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

		     WebElement queryBox = driver.findElement(By.name("q"));
		     queryBox.sendKeys("Alpesh Vala barclays");
		     WebElement searchBtn = driver.findElement(By.name("btnK"));
		     searchBtn.click();
		     WebElement iresDiv = driver.findElement(By.id("ires"));
		     iresDiv.findElements(By.tagName("a")).get(0).click();
		     System.out.println(driver.getTitle());
		   } catch(Exception e) {
			   e.printStackTrace();
			}finally {
		     driver.quit();
		   }
	}
	public static void chrome() {
		   

	    String str = System.getProperty("user.dir");

		FirefoxBinary firefoxBinary = new FirefoxBinary();
		   firefoxBinary.addCommandLineOptions("--headless");
		   
		   System.setProperty("webdriver.chrome.driver", str+"/resources/chromedriver.exe");
			
			ChromeOptions chromeoption=new ChromeOptions();
			chromeoption.addArguments("--headless");
			WebDriver driver= new ChromeDriver(chromeoption);

	   try {
		     driver.get("http://www.google.com");
		     driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

		     WebElement queryBox = driver.findElement(By.name("q"));
		     queryBox.sendKeys("Alpesh Vala barclays");
		     WebElement searchBtn = driver.findElement(By.name("btnK"));
		     searchBtn.click();
		     WebElement iresDiv = driver.findElement(By.id("ires"));
		     iresDiv.findElements(By.tagName("a")).get(0).click();
		     System.out.println(driver.getTitle());
		   } catch(Exception e) {
			   e.printStackTrace();
			}finally {
		     driver.quit();
		   }
	}
	
	public static void htmlUnit() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		   

        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://www.google.com");
	     driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.name("q"));	
        
        // Enter a search query		
        element.sendKeys("Alpesh Vala barclays");	
        element.submit();			
        
        System.out.println("Page title is: " + driver.getTitle());		
        
        driver.quit();	
	}
		
}
