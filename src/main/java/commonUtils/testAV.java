package commonUtils;

import java.io.File;
import java.util.Enumeration;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testAV {

	public static void main(String args[]) {
		System.out.println("Test");
		
		File file=new File("");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath()+"/resources/chromedriver.exe");
		
		WebDriver driver =new ChromeDriver();
		driver.get("https://google.com");
		
		org.apache.log4j.Logger logger =LogManager.getRootLogger();

		if (logger != null) {
            Enumeration<Appender> appenders = logger.getAllAppenders();
            if (appenders != null) {
                while (appenders.hasMoreElements()) {
                    Appender appender = appenders.nextElement();
                    if (appender instanceof FileAppender) {
                        FileAppender fileAppender = (FileAppender)appender;
                        String filename = fileAppender.getFile();
                        file = new File(filename);
                        break;
                    }
                }
            }
        }
		
		logger.info("test message");
		
		
	}
	
	
}
