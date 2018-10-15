package Schedule;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;


public class Winiumwithjava {


    public static void main (String args[]) throws IOException {
    	test();
    }

    public static void test() throws IOException{
      DesktopOptions options= new DesktopOptions();
      options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
      try{
       WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
       driver.findElementByClassName("Edit").sendKeys("This is sample test");
       driver.close();
      }
      catch(Exception e){
       System.out.println(e.getMessage());
      }
     }
}
