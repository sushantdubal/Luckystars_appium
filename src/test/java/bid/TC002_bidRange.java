package bid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
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

import config.basek;
import config.constants;


public class TC002_bidRange extends basek
{
	
	
	String version;
	String BidAlert = "Bid Placed";
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
		
		
	}
	@Test(priority=1)
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

		test=report.startTest("Bids - Verify Bid Range Working");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		test.log(LogStatus.INFO, "User on Bid screen");
		
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
		
	}

	@Test(priority=2)
	public void bidRange()
	{
		driver.findElement(By.id("in.interactive.luckystars:id/et_start_range")).sendKeys("21.01");
		driver.findElement(By.id("in.interactive.luckystars:id/et_end_range")).sendKeys("21.02");
		
		driver.navigate().back();
		driver.findElement(By.id("in.interactive.luckystars:id/btn_action")).click();
		
		driver.findElement(By.id("android:id/button1")).click();
		
		String bidPlacedtitle = driver.findElement(By.id("in.interactive.luckystars:id/alertTitle")).getText();
		
		if (bidPlacedtitle.equalsIgnoreCase(BidAlert))
		{
			driver.findElement(By.id("android:id/button1")).click();
			System.out.println("TestCase Passed");
			
			test.log(LogStatus.INFO, "Testcase - Passed");
		}
		else
		{
			System.out.println("Your bid bas been repeated");
			System.out.println("TestCase Failed");
			
			test.log(LogStatus.INFO, "Testcase - Failed");
			
		}
		report.endTest(test);
	}
	
	@AfterTest
	public void quit() 
	{
		super.teardown();
	}
	
}