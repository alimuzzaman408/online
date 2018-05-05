package appModule;

import org.openqa.selenium.WebDriver;

import pageObjects.Home_page;
import pageObjects.Login_page;
import utility.Constant;
import utility.ExcelUtils;

public class SignIn_Action {
		public static void Execute(WebDriver driver) throws Exception {
			
			String UserName=ExcelUtils.GetCellData(Constant.Path_TestData, "Sheet1", 1, 1);
			System.out.println("User Name:"   +UserName);
			String Password=ExcelUtils.GetCellData(Constant.Path_TestData, "Sheet1", 1, 2);
			System.out.println("Pass word:"  + Password);
			
			Home_page.link_MyAccount(driver).click();
			Login_page.WaitForElementPresent(driver);
			Login_page.textbox_UserName(driver).sendKeys(UserName);
			Login_page.textbox_Password(driver).sendKeys(Password);
			Login_page.button_Login(driver).click();
			System.out.println("Login Successfully");	
		
		
	}
	

}
