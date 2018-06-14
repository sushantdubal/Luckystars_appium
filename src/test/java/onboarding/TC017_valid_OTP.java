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

//on boarding class inherits base class
public class TC017_valid_OTP extends base_sd 
{

	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
	}

	@Test(priority = 1, groups = "Regression")
	public void valid_OTP_Test() throws InterruptedException 
	{
		test = report.startTest("On boarding: Verify valid OTP");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		
		// click on get started button
		driver.findElement(By.id("bt_getStarted")).click();
		//allow permission
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		// click on mobile number input line & set number
		driver.findElement(By.id("in.interactive.luckystars:id/et_mobile_number")).sendKeys("9999999999");
		driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).click();
		//driver.navigate().back();
		driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
		driver.findElement(By.id("android:id/button1")).click();
		test.log(LogStatus.INFO, "User on OTP screen");
		// Thread.sleep(5000); 
		driver.findElement(By.id("in.interactive.luckystars:id/pin_layout")).sendKeys("111111");
		//Click continue button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();
		
		String expected_text="STARS";	
		String actual_text=driver.findElement(By.id("in.interactive.luckystars:id/tv_star")).getText();
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
