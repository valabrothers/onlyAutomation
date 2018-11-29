# Locators
1. Different Locators provided in selenium/protractor
   - ID
     - IDs are the safest, fastest locator option and should always be your first choice. IDs should be unique in every page according to W3C website 
	 - Fastest locator as it uses the document.getElementById() javascript command which is optimised by many browsers
	 - Example:
	 ```
	 Selenium : driver.findElement(By.ID("ID"));
	 Java script : Document.getElementById("ID");
	 Protractor : element(by.ID('ID'));
	 ```
   - Class Name
   - Tag Name
   - Link Text & Partial Link Text
   - CSS Selector
   - XPath
   	 - Relative 
	 - Absolute
	 - Most Flexible however Xpath is slow compared to other identifiers
	   - https://stackoverflow.com/questions/11777694/which-is-the-best-and-fastest-way-to-find-the-element-using-webdriver-by-xpath
	 - Why we should avoid xpath 
	   - https://github.com/angular/protractor/blob/master/docs/style-guide.md#never-use-xpath
    
2. Points to consider while selecting locator
	- Should be Reliable hence less maintainance
	- Fast
	- Readable	
		
References for Good Reading on Locators:		
 - https://sqa.stackexchange.com/questions/27978/what-makes-a-good-selenium-locator
