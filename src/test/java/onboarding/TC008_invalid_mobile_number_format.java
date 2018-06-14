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
public class TC008_invalid_mobile_number_format extends base_sd {
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
	}
	@Test(description="On Boarding: invalid_mobile_number_format")
	public void invalid_mobile_number_format_test() throws InterruptedException, MalformedURLException 
	{
		test=report.startTest("On Boarding: invalid_mobile_number_format");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		test.log(LogStatus.INFO, "User on Get started screen");
		driver.findElement(By.id("in.interactive.luckystars:id/bt_getStarted")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("in.interactive.luckystars:id/et_mobile_number")).sendKeys("0000000000");
		driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).click();
		driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
		driver.findElement(By.id("android:id/button1")).click();
 
		String expected_text="Invalid mobileNo format";	
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