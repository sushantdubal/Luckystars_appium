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
public class TC004_third_intro extends base_sd {


	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
	}

	@Test(description="On Boarding: Verify text on third intro screen")
	public void third_intro_test() throws InterruptedException, MalformedURLException 
	{
		test=report.startTest("On Boarding: Verify text on third intro screen");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		test.log(LogStatus.INFO, "User on third intro screen");
		Thread.sleep(10000);
		super.horizontalSwipeRtL(driver);
		Thread.sleep(1000);
		super.horizontalSwipeRtL(driver);
		String expected_text="Earn Stars through various modes and Redeem them for cool freebies!";
		String actual_text=driver.findElement(By.id("in.interactive.luckystars:id/tv_intro")).getText();
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