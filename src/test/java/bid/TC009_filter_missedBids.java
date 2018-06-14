package bid;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import config.basek;
import config.constants;


public class TC009_filter_missedBids extends basek
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
		
		test=report.startTest("Bids - Verify filter_missedBids section working");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		test.log(LogStatus.INFO, "User on Filters screen");

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

	
@Test(priority =2)
	public void filter_missedBids() throws MalformedURLException, InterruptedException
	{
		
		
		driver.findElement(By.id("in.interactive.luckystars:id/tv_my_bids")).click();
		driver.findElement(By.id("in.interactive.luckystars:id/iv_filter")).click();
		
		driver.findElement(By.id("in.interactive.luckystars:id/et_start_range")).sendKeys("1");
		driver.findElement(By.id("in.interactive.luckystars:id/et_end_range")).sendKeys("2");
		
		driver.findElement(By.id("in.interactive.luckystars:id/ct_missed_bids")).click();
		driver.navigate().back();
		
		driver.findElement(By.id("in.interactive.luckystars:id/bt_apply")).click();
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/"
				+ "android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageButton")).click();
		
		System.out.println("Missed Bids list viewed successfully");
		
		System.out.println("All filters are working properly");
		test.log(LogStatus.INFO, "Testcase - Passed");
		
		report.endTest(test);
		
	}
	
	@AfterTest
	public void quit() 
	{
		super.teardown();
	}
	
}