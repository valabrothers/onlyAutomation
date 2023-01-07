package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Ass1 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "H:/Sumita_Assignment/ChromeDriver/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement elementforRadiobtn = driver.findElement(By.xpath("//label[contains(text(),'Male')]"));
		   //label[contains(text(),'Female')]
		//label[contains(text(),'Other')]
		boolean select = elementforRadiobtn.isSelected();
		System.out.println("Is selected or not = "+select);
		if(select == false)
		{
			elementforRadiobtn.click();
		}
		WebDriverWait wait = new WebDriverWait(driver, 5);
		WebElement elementforRadiobtn1 = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
		boolean select1 = elementforRadiobtn.isDisplayed();
		System.out.println("Is displayed or not = "+select1);
		if(select1 == true)
		{
			elementforRadiobtn1.click();
		}
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		WebElement elementforRadiobtn2 = driver.findElement(By.xpath("//label[contains(text(),'Other')]"));
		boolean select2 = elementforRadiobtn.isEnabled();
		System.out.println("Is enabled or not = "+select2);
		if(select2 == true)
		{
			elementforRadiobtn2.click();
		}
		System.out.println("**********************Assignmet3---->part1**********************");
		
		//WebDriverWait wait1 = new WebDriverWait(driver, 5);
		WebElement elementforCheckbox = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
		
		boolean Checkbox1 = elementforCheckbox.isSelected();
		System.out.println("Is enabled or not = "+Checkbox1);
		
		WebElement elelable = driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		if(Checkbox1 == false)
		{
			JavascriptExecutor executor = (JavascriptExecutor) driver;
		    executor.executeScript("arguments[0].scrollIntoView(true);", elementforCheckbox);
		    //executor.executeScript("arguments[0].click();", Checkbox1);

		    elelable.click();
		}
		
		WebElement elementforCheckbox2 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-2']"));
		
		boolean Checkbox2 = elementforCheckbox.isDisplayed();
		System.out.println("Is enabled or not = "+Checkbox2);
		
		WebElement elelable2 = driver.findElement(By.xpath("//label[contains(text(),'Reading')]"));
		if(Checkbox2 == false)
		{
		
			elelable2.click();
		}
		
		WebElement elementforCheckbox3 = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-3']"));
		
		boolean Checkbox3 = elementforCheckbox.isDisplayed();
		System.out.println("Is enabled or not = "+Checkbox3);
		
		WebElement elelable3 = driver.findElement(By.xpath("//label[contains(text(),'Music')]"));
		if(Checkbox3 == false)
		{
		
			elelable3.click();
		}
		System.out.println("**********************Assignmet3---->part2**********************");
		
	//	WebElement drpelementenable = driver.findElement(By.cssSelector(" css-2b097c-container"));
	//	WebElement drpelement = driver.findElement(By.id("state"));
		WebElement drpelement = driver.findElement(By.xpath("//*[@id=\"stateCity-wrapper\"]//div[@id='state']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].click()", drpelement);
		drpelement.click();
	//	Assert.assertTrue(ExpectedConditions.titleContains("ToolsQA").apply(driver).booleanValue());
		
		
	}
	
	
}
