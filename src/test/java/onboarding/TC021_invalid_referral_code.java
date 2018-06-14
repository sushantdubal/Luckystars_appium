/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package onboarding;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import config.base_sd;
public class TC021_invalid_referral_code extends base_sd
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
	public void invalid_referral_code_test() throws InterruptedException 
	{	
		test=report.startTest("On Boarding: Verify registration with invalid referral code");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		
		driver.findElement(By.id("in.interactive.luckystars:id/bt_getStarted")).click();
		//allow permission
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("in.interactive.luckystars:id/et_mobile_number")).sendKeys("9619633251");
		driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).click();
		//driver.navigate().back();
		driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
		driver.findElement(By.id("android:id/button1")).click();
		// Thread.sleep(5000); 
		driver.findElement(By.id("in.interactive.luckystars:id/pin_layout")).sendKeys("111111");
		driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();
		test.log(LogStatus.INFO, "User on Registration screen");
		driver.findElement(By.id("in.interactive.luckystars:id/et_first_name")).sendKeys("Prasad");
		driver.findElement(By.id("in.interactive.luckystars:id/et_last_name")).sendKeys("Kesarkar");
		driver.findElement(By.id("in.interactive.luckystars:id/et_dob")).click();
		//Birth date- Ok button click
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("in.interactive.luckystars:id/et_ref_code")).sendKeys("abc");
		driver.navigate().back();
		//Click finish button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
		//Click confirm button
		driver.findElement(By.id("android:id/button1")).click();

		String expected_text="Sorry, this is an invalid referral code. Please check and re-enter.";	
		String actual_text=driver.findElement(By.id("android:id/message")).getText();
		System.out.println(""+actual_text);
		System.out.println("Expected text is : " + expected_text);
		System.out.println("Actual text is : " + actual_text);

		if(expected_text.contentEquals(actual_text))
		{
			System.out.println("Test Passed- Verification Successful - Expected & actual result text matched");
			test.log(LogStatus.PASS, "Test case- PASS");
		}
		else
		{
			System.out.println("Test Failed- Verification Unsuccessful - Expected & actual result text not matched");
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