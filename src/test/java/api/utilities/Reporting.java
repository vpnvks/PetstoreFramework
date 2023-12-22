package api.utilities;

import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	 public ExtentReports extent;
	 public ExtentTest logger;
	
	 
	 @Override
	 public void onStart(ITestContext testcontext) {
		 
		 String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		 String reqreport = "Test-Report-"+timestamp+".html";
		 
		 htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reqreport);
		 htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/configuration/"+"extent-config.xml");

		 extent = new ExtentReports();
		 
		 extent.attachReporter(htmlreporter);
		 extent.setSystemInfo("Host name", "localhost");
		 extent.setSystemInfo("Environment", "QA");
		 extent.setSystemInfo("user", "vipin");
		 
		 
		 htmlreporter.config().setDocumentTitle("API testing");
		 htmlreporter.config().setReportName("Petstore API Test report");
		 htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlreporter.config().setTheme(Theme.DARK);
	  
	 }
	 @Override
	 public void onTestSuccess(ITestResult tr) {
		 
		 logger = extent.createTest(tr.getName());
		 logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	 }
	 @Override
	 public void onTestFailure(ITestResult tr) {
		 
		 logger = extent.createTest(tr.getName());
		 logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		   }
	 
	 @Override
	 public void onTestSkipped(ITestResult tr) {
		 System.out.println("inside onskipped");
		 logger = extent.createTest(tr.getName());
		 logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	 }
	 @Override
	 public void onFinish(ITestContext tr) {
		 extent.flush();
	 }


}
