/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package coins;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import config.base_sd;
import config.constants;
//on boarding class inherits base class
@Test public class TC002_buy_coins extends base_sd 
{
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
	}

	
	@Test()
	public void buy_coins_navigation_test() throws InterruptedException 
	{
		test = report.startTest("Home: Verify buy coins ");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		// click on get started button
		driver.findElement(By.id("bt_getStarted")).click();
		//allow permission
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		// click on mobile number input line & set number
		driver.findElement(By.id("in.interactive.luckystars:id/et_mobile_number")).sendKeys(constants.mobile_no);
		test.log(LogStatus.INFO, "Entered Mobile number- 9999999999");
		driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).click();
		//driver.navigate().back();
		driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
		driver.findElement(By.id("android:id/button1")).click();
		// Thread.sleep(5000); 
		driver.findElement(By.id("in.interactive.luckystars:id/pin_layout")).sendKeys(constants.otp);
		test.log(LogStatus.INFO, "Entered OTP- 111111");
		//click continue button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();
		test.log(LogStatus.INFO, "User signed in & on Home screen");
		//wait time 10 seconds
		 Thread.sleep(10000); 
		driver.findElement(By.id("in.interactive.luckystars:id/tv_coin_cnt")).click();
		test.log(LogStatus.INFO, "Clicked coin count icon");
		driver.findElement(By.id("in.interactive.luckystars:id/btn_buy_stars")).click();
		test.log(LogStatus.INFO, "Clicked buy coins button");
		//Click Rs. 3000
		driver.findElement(By.id("in.interactive.luckystars:id/tv_price")).click();
		//click google play
		driver.findElement(By.id("in.interactive.luckystars:id/iv_google_play")).click();
		//click Buy Now button
		driver.findElement(By.id("com.android.vending:id/continue_button")).click();
		//wait time 10 seconds
		 Thread.sleep(10000); 
		String expected_text ="You are all set\n\nYour purchase was successful.";	
		String actual_text=driver.findElement(By.id("android:id/message")).getText();
		System.out.println(""+actual_text);
		System.out.println("Expected text is : " + expected_text);
		System.out.println("Actual text is : " + actual_text);

		if(expected_text.contentEquals(actual_text))
		{
			System.out.println("Test Passed- Verification Successful - Expected & actual result text matched");
			test.log(LogStatus.INFO, "User able to buy coins");
			test.log(LogStatus.PASS, "Test case- PASS");
		}
		else
		{
			System.out.println("Test Failed- Verification Unsuccessful - Expected & actual result text not matched");
			test.log(LogStatus.INFO, "User not able to buy coins");
			test.log(LogStatus.FAIL, "Test case- FAIL");
		}

		report.endTest(test);
	}

	@AfterTest
	public void quit() 
	{
		super.teardown();
	}
}
