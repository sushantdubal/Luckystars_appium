/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package config;

import io.appium.java_client.android.AndroidDriver;

public class swipe 
{
	
	public AndroidDriver driver;
	
	
	public void horizontalSwipeRtL(AndroidDriver driver)
	{
		driver.swipe(0, 600, 10, 600, 500);
	}

	public void verticalSwipeBtU(AndroidDriver driver)
	{
		driver.swipe(0, 800, 100, 40, 500);
	}
	
	public void horizontalSwipeLtR(AndroidDriver driver)
	{
		driver.swipe(0, 0, 990, 100, 500);
	}	
	
	public void verticalSwipeUtB(AndroidDriver driver)
	{
		driver.swipe(0, 264, 0, 0, 3000);
	}

}