/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package onboarding;
import java.io.IOException;
import java.net.MalformedURLException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import config.base_sd;
public class TC001_first_intro extends base_sd

{
	XSSFWorkbook wb;
	XSSFSheet sh1;
	int i;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException
	{
		super.startReport();
		//call precondition method from base class
		super.precondition();
		
		
	}

	@Test(description="On boarding: Verify text on first intro screen")
	public void first_intro_test() throws InterruptedException, IOException 
	{
		test=report.startTest("On boarding: Verify text on first intro screen");
		test.log(LogStatus.INFO, "Lucky Stars application is up and running");
		test.log(LogStatus.INFO, "User on first intro screen");
		
		String expected_text="Play different Quizzes \n and stand a chance \n to win exciting prizes ";
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
