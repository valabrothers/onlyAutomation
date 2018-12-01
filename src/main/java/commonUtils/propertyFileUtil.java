package commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class propertyFileUtil {

	private static propertyFileUtil propUtils;
	
	private static Properties propvalue;
	
		private propertyFileUtil() throws IOException {
			propvalue=loadPropertyFile(new File(System.getProperty("user.dir")+"/src/test/resources/Properties/Application.properties"));
		}
	
		/*
		 * This method is used to load application property File
		 */
		private Properties loadPropertyFile(File file ) throws IOException {
			Properties prop=new Properties();

			FileInputStream fin = new FileInputStream(file);
			
			prop.load(fin);
			return prop;
		}

		public static propertyFileUtil getInstance() throws IOException {
			if (propUtils==null) {
				propUtils = new propertyFileUtil();
			}
			return propUtils;
		}
		
		public String getProperty(String propName) {
			return propvalue.getProperty(propName);
		}
		
		public void setProperty(String propName,String Value) {
			propvalue.setProperty(propName,Value);
			
		}
}
