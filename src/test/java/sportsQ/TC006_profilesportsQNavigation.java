package sportsQ;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import config.constants;
import config.basek;
import config.swipe;


//Left menu class inherits base class
public class TC006_profilesportsQNavigation extends basek
{
	
	
String version;


@BeforeTest
public void setUp() throws MalformedURLException, InterruptedException
{
	super.startReport();
	//call precondition method from base class
	super.precondition();
}


@Test(priority = 1)
public void signIn() throws InterruptedException
{
	Capabilities caps = driver.getCapabilities();

	@SuppressWarnings("unused")
	String version = caps.getCapability("platformVersion").toString();
	if (version.equalsIgnoreCase("6.0.1"))
	{
		version = "6.0";
	}
	
	Double newVersion = Double.parseDouble(version);

	
	test=report.startTest("sportsQ - Verify profileSportsQNavigation functionality working");
	test.log(LogStatus.INFO, "Lucky Stars application is up and running");
	test.log(LogStatus.INFO, "User on Profile screen");

	driver.findElement(By.id("in.interactive.luckystars:id/bt_getStarted")).click();

	if (newVersion > 5.0)
	{
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
	}
	
	driver.findElement(By.id("in.interactive.luckystars:id/et_mobile_number")).sendKeys(constants.mobileNo);
	
	driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).click();
	
	driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
	
	driver.findElement(By.id("android:id/button1")).click();
	
	driver.findElement(By.id("in.interactive.luckystars:id/pin_layout")).sendKeys("111111");
	
	//driver.navigate().back();
	
	driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();

	profileSportsNavigation();
	
}

@Test(priority = 2)
public void profileSportsNavigation() throws InterruptedException
{
	Thread.sleep(2000);
	
	
	//Profile Button Clicked
	driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
			+ "android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).click();

	driver.findElement(By.id("in.interactive.luckystars:id/tv_sport_quizzes")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
			+ "android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ImageButton")).click();
	
	System.out.println("Navigated to sportsQueue tab succcessfully");
	
	test.log(LogStatus.INFO, "Testcase - Passed");
	
	report.endTest(test);
	
	}


@AfterTest
public void quit() 
{
	super.teardown();
}


}