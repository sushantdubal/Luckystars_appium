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

public class TC006_age_checkbox extends base_sd {
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
	}
	@Test(description="On Boarding: Verify checkbox- age")
	public void age_checkbox_test() throws InterruptedException, MalformedURLException 
	{
		test=report.startTest("On Boarding: Verify checkbox- age");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		test.log(LogStatus.INFO, "User on Get started screen");
		driver.findElement(By.id("in.interactive.luckystars:id/bt_getStarted")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		String expected_text="I am above the age of 18 years and I am not a resident of Assam, Odisha or Telangana. By proceeding further, I expressly agree to the \nTerms & Conditions & Privacy Policy";	
		String actual_text=driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).getText();
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