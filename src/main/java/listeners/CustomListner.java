package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import base.Page;
import utilities.TestUtil;

public class CustomListner extends Page implements ITestListener{

	public void onTestStart(ITestResult result) {
		test = rep.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		String passedInfo = "成功 >>> " + result.getName().toUpperCase();
		test.log(LogStatus.PASS, passedInfo);
		
		rep.flush();
		rep.endTest(test);
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtil.captureScreenshot();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		String failedInfo = "失败 >>> " + result.getName().toUpperCase();
		test.log(LogStatus.PASS, failedInfo);
		
		Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenshotName+">报错截图</a>");
		Reporter.log("<a target=\"_blank\" href="+ TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" width=200 height=200></img></a>");
		Reporter.log("<br>");
		
		test.log(LogStatus.INFO, test.addScreenCapture(TestUtil.screenshotName));
		
		rep.flush();
		rep.endTest(test);
		
	}

	public void onTestSkipped(ITestResult result) {
		String skipInfo = "忽略 >>> " + result.getName().toUpperCase();
		test.log(LogStatus.PASS, skipInfo);
		
		
		rep.flush();
		rep.endTest(test);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
