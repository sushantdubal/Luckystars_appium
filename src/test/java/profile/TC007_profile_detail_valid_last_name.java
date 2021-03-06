/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package profile;
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
@Test public class TC007_profile_detail_valid_last_name extends base_sd 
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
	public void profile_detail_valid_last_name_test() throws InterruptedException 
	{
		test = report.startTest("Profile: Verify valid last name");
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
		//wait time 10 second 
		 Thread.sleep(10000); 
		//click profile pic
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]")).click();
		test.log(LogStatus.INFO, "Clicked profile pic");
		//click edit icon
		driver.findElement(By.id("in.interactive.luckystars:id/iv_profile_edit")).click();
		test.log(LogStatus.INFO, "Clicked edit button");
		driver.findElement(By.id("et_last_name")).clear();	
		//Enters first name
		driver.findElement(By.id("et_last_name")).sendKeys("Dubal");
		
		String expected_text ="Dubal";	
		String actual_text=driver.findElement(By.id("et_last_name")).getText();
		System.out.println(""+actual_text);
		System.out.println("Expected text is : " + expected_text);
		System.out.println("Actual text is : " + actual_text);
		
		//Hide Keyboard
		driver.navigate().back();
		//Thread.sleep(1000);
		//driver.findElement(By.id("et_date_of_birth")).click();
		
		//driver.findElement(By.name("23")).click();
		
		//driver.findElement(By.name("OK")).click();
		
		/*List<WebElement> date = driver.findElements(By.className("android.widget.NumberPicker"));
		date.get(0).sendKeys("17");
		date.get(1).sendKeys("Apr");
		date.get(2).sendKeys("1998"); 

		Actions action=new Actions(driver);
		action.sendKeys("Enter").sendKeys(Keys.ENTER).build().perform(); 
		driver.findElement(By.name("Ok")).click();
		// driver.findElement(By.id(lp.changeDate)).click();
*/
		driver.findElement(By.id("et_pin_code")).click();
		driver.findElement(By.id("et_pin_code")).clear();
		driver.findElement(By.id("et_pin_code")).sendKeys("400051");	
		//Hide Keyboard
		driver.navigate().back();
		driver.findElement(By.id("in.interactive.luckystars:id/action_saved")).click();
		driver.findElement(By.id("button1")).click();
		if(expected_text.contentEquals(actual_text))
		{
			System.out.println("Test Passed- Verification Successful - Expected & actual result text matched");
			test.log(LogStatus.INFO, "Profile: Verify valid last name");
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
