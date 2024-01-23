package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listenerimplementation implements ITestListener {

	
	public ExtentReports rp;
	public WebDriver d;
	@Override
	public void onTestStart(ITestResult result) {
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+" TestScript is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String msg=result.getThrowable().getLocalizedMessage().toString();
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+" TestScript is failed "+msg,true);
		
		WebDriverUtils wutils=new WebDriverUtils();
		WebDriver d=null;
		try {
			wutils.toTakeScreenshotFailed(d,"FailedScript");
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String msg=result.getThrowable().toString();
		String methodname=result.getMethod().getMethodName();
		Reporter.log(methodname+" TestScript is skipped "+msg,true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter reports=new ExtentSparkReporter("./ExetntReporter/SparkReport.html");
				reports.config().setDocumentTitle("sanket");
				reports.config().setReportName("Halwa");
				reports.config().setTheme(Theme.DARK);
				
				rp= new ExtentReports();
				
//				TO Generate the report
				rp.attachReporter(reports);
				
//				To Add Extra information to the report
				rp.setSystemInfo("reportername", "sanket");
				rp.setSystemInfo("Browser", "Chrome");
				rp.setSystemInfo("OS", "Windows");
				
				Reporter.log("TestScript is started",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		rp.flush();
		Reporter.log("TestScript is finished",true);
	}
	

}
