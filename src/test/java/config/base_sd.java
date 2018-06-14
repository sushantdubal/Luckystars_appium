/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package config;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class base_sd 
{
	public static AndroidDriver driver;
	Dimension size;
	String destDir;
	DateFormat dateFormat;
	public ExtentReports report;
	public ExtentTest test;
	public static WebDriverWait wait;
	public void precondition() throws MalformedURLException, InterruptedException
	{
		DOMConfigurator.configure("log4j.xml"); 
		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Set android deviceName desired capability. Set it Android Emulator.
		capabilities.setCapability("deviceName", config.constants.sDevice);
		//Set apk path
		capabilities.setCapability("app", config.constants.sd_Path_apk);
		// Created object of RemoteWebDriver will all set capabilities.
		// Set appium server address and port number in URL string.
		// It will launch app in device
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);	
		System.out.println("Lucky Stars app launched on device");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
	}
	
	public void startReport(){
		
		//generate report date & time stamp wise
		/* String destFile=null;
		 DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH-mm-ss");
		 destFile = "/Users/git/Automation/Luckystars_android/Extent_report_output_sd";
		 String destDir = dateFormat.format(new Date()) + ".html";
		 report = new ExtentReports(destFile + "/" +destDir, false);*/
		
		//ExtentReports(String filePath,Boolean replaceExisting) 
		//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
		//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
		//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
		//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.

		report=new ExtentReports("/Users/rahul/Luckystars_appium/Ls_android_coin_test_report.html", false);
	
		//extent.addSystemInfo("Environment","Environment Name")
		report.addSystemInfo("Project Name", "Luckystars").addSystemInfo("Environment", "Android").addSystemInfo("User Name", "QA Team");
		//loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		//You could find the xml file below. Create xml file in your project and copy past the code mentioned below

		report.loadConfig(new File("/Users/rahul/Luckystars_appium/extent-config.xml"));
		//report.loadConfig(new File("/Users/apple/luckystars_android/Luckystars_android/extent-config.xml"));


	}

	
	public void horizontalSwipeRtL(AndroidDriver driver)
	{
		driver.swipe(0, 400, 50, 400, 500);
	}

	public void verticalSwipeBtU(AndroidDriver driver)
	{
		driver.swipe(0, 0, 0, 50, 1000);
	}

	public void horizontalSwipeLtR(AndroidDriver driver)
	{
		driver.swipe(0, 0, 990, 100, 500);
	}	

	public void verticalSwipeUtB(AndroidDriver driver)
	{
		driver.swipe(0, 264, 0, 0, 3000);
	}




	public void getResult(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());

		}

		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		report.endTest(test);
	}

	public void endReport(){
		// writing everything to document
		//flush() - to write or update test information to your report. 
		report.flush();
		//Call close() at the very end of your session to clear all resources. 
		//If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
		//You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
		//Once this method is called, calling any Extent method will throw an error.
		//close() - To close all the operation
		report.close();
	}


	public void teardown()
	{
		report.flush();
		driver.quit();
		
	}


}

/* @Test
	 public void version_check()  throws InterruptedException 
	 {
		Capabilities caps = driver.getCapabilities();

		@SuppressWarnings("unused")
		String version = caps.getCapability("platformVersion").toString();
		if (version.equalsIgnoreCase("6.0.1"))
		{
			version = "6.0";
		}

		Double newVersion = Double.parseDouble(version);
		driver.findElement(By.id("in.interactive.luckystars:id/bt_getStarted")).click();

		if (newVersion > 5.0)
		{
			driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		}

	 }
	

	 public void takeScreenShot() {
		  // Set folder name to store screenshots.
		  destDir = "screenshots";
		  // Capture screenshot.
		  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  // Set date format to set It as screenshot file name.
		  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		  // Create folder under project with name "screenshots" provided to destDir.
		  new File(destDir).mkdirs();
		  // Set file name using current date time.
		  String destFile = dateFormat.format(new Date()) + ".png";

		  try {
		   // Copy paste file at destination folder location
		   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	 }



 */



