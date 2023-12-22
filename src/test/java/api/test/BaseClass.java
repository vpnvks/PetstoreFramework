package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	public static Logger logger;
	
	@BeforeSuite
	public void CommonMethod() {
		
		logger =  LogManager.getLogger(BaseClass.class);;
		
	}
	

}
