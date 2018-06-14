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
public class TC015_send_query extends base_sd 
{
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
	}

	@Test(description="On boarding: Verify Customer support- send query")
	public void send_query_Test() throws InterruptedException 
	{
		test = report.startTest("On boarding: Verify Customer support- send query");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		
		// click on get started button
		driver.findElement(By.id("bt_getStarted")).click();
		//allow permission
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		// click on mobile number input line & set number
		driver.findElement(By.id("in.interactive.luckystars:id/et_mobile_number")).sendKeys("9999999999");
		//Checks check box- age restriction
		driver.findElement(By.id("in.interactive.luckystars:id/cb_age_restriction")).click();
		//driver.navigate().back();
		//clicks continue button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_signup")).click();
		//clicks confirm button
		driver.findElement(By.id("android:id/button1")).click();
		test.log(LogStatus.INFO, "Waiting time- 360 seconds");
		//waiting time- 360 seconds
		Thread.sleep(360000); 
		//clicks Resend button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();
		test.log(LogStatus.INFO, "Waiting time- 360 seconds");
		//waiting time- 360 seconds
		Thread.sleep(360000); 
		test.log(LogStatus.INFO, "Clicks Call Me button");
		//clicks Call Me button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();
		test.log(LogStatus.INFO, "Clicks Customer support button");
		//clicks Customer support button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_resend")).click();
		test.log(LogStatus.INFO, "User on customer support screen");
		test.log(LogStatus.INFO, "feedback-adds message");
		//clicks feedback & adds message
		driver.findElement(By.id("in.interactive.luckystars:id/et_feedback_message")).sendKeys("Issue in sign up");
		driver.navigate().back();
		test.log(LogStatus.INFO, "clicks SEND button");
		//clicks SEND button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_submit")).click();
		String expected_text="CLOSE";	
		String actual_text=driver.findElement(By.id("in.interactive.luckystars:id/btn_close")).getText();
		//clicks CLOSE button
		driver.findElement(By.id("in.interactive.luckystars:id/btn_close")).click();
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
