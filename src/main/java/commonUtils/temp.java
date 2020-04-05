package commonUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;

public class temp {
	
	public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
	    CommandExecutor executor = new HttpCommandExecutor(command_executor) {

	    @Override
	    public Response execute(Command command) throws IOException {
	        Response response = null;
	        if (command.getName() == "newSession") {
	            response = new Response();
	            response.setSessionId(sessionId.toString());
	            response.setStatus(0);
	            response.setValue(Collections.<String, String>emptyMap());

	            

	        } else {
	            response = super.execute(command);
	        }
	        return response;
	    }
	    };

	    return new RemoteWebDriver(executor, new DesiredCapabilities());
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/resources/chromedriver_2.44.exe");
		   ChromeDriver driver= new ChromeDriver();
		    HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
		    URL url = executor.getAddressOfRemoteServer();
		    SessionId session_id = driver.getSessionId();
		    driver.get("https://gmail.com");
		    driver.findElement(By.id("identifierId")).sendKeys("anyEmailID@gmail.com");
		    //RveJvd snByac
		    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.name("password")).sendKeys("testpwd");
		    driver.findElement(By.cssSelector("span.RveJvd.snByac")).click();
		    System.out.println("***********************************************frst captured"+session_id);

		    RemoteWebDriver driver2 = createDriverFromSession(session_id, url);
		    System.out.println(driver2.getTitle());
		    Thread.sleep(5000);
		    driver2.findElement(By.name("q")).sendKeys("anyEmailID");
		    WebElement searchbar= driver.findElement(By.name("q"));
		    searchbar.sendKeys(Keys.ENTER);
		    System.out.println("********************************************reusing");
		   System.out.println(driver2.getSessionId()); 

	}

}
