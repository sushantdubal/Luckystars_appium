/**
 * modified by @author Sushant
 * Jun 8, 2018
 * 5:38:01 PM
 */
package config;
 
public class constants {
 
	//This is the list of System Variables
    //Declared as 'public', so that it can be used in other classes of this project
    //Declared as 'static', so that we do not need to instantiate a class object
    //Declared as 'final', so that the value of this variable can be changed
    // 'String' & 'int' are the data type for storing a type of value	
	
	//Lucky stars
	public static final String sDevice = "ZY222W9V5J";
	public static final String kDevice = "F5AZFG14R535";
	
	public static final String mobileNo = "9089089086";
	public static final String filterMobile_no="9619666881";
	public static final String refundedText="9619633333";

	public static final String kg_Path_apk ="/Users/apple/Desktop/krishnag/appdebug.apk";
	public static final String kg_Path_Report ="/Users/apple/Desktop/excelFiles/sushant.xlsm";

	public static final String sd_Path_apk ="/Users/Documents/Share For QA/2. Automation testing/Functional Testing- Appium /Luckystars_apk/19_05_2018/Luckystars.apk";
	public static final String sd_Path_Report ="/Users/Documents/Automation_Reports_Excel/sushant.xlsm";

	public static final String Path_OR = "/Users/Documents/LS/I_love_london/src/test/java/config/OR.txt";
	public static final String File_TestData = "DataEngine.xlsx";
	//List of Data Sheet Column Numbers
	public static final int Col_TestCaseID = 0;	
	public static final int Col_TestScenarioID =1;
	//This is the new column for 'Page Object'
	public static final int Col_PageObject =4;
	public static final int Col_ActionKeyword =5;
	//Test case-New entry in Constant variable
	public static final int Col_RunMode =2;
	//Test case- result
	public static final int Col_Result =3;
	//test data
	public static final int Col_DataSet =6;
	//test step result
	public static final int Col_TestStepResult =7;
	public static final String KEYWORD_FAIL = "FAIL";
	public static final String KEYWORD_PASS = "PASS";
	//List of Data Engine Excel sheets
	public static final String Sheet_TestSteps = "TestSteps";
	//New entry in Constant variable
    public static final String Sheet_TestCases = "TestCases";
    // List of Test Data
	public static final String data="";
	//public static final String Password = "Passw0rd";
	
	public static final String mobile_no="9090909090";
	public static final String otp="111111";
 
}