package automationFramework;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import pageObjects.Home_page;
import pageObjects.Login_page;
import pageObjects.MyAccount_page;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class POM_TC {
	private static WebDriver driver = null;	
	 @BeforeTest
	  public void beforeTest() {
		 
		 ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			String baseUrl = "http://store.demoqa.com/";
			driver.manage().deleteAllCookies();
			driver.get(baseUrl);
		 	driver.manage().window().maximize(); 
	  }
  @Test
  public void run() {
	  Home_page.link_MyAccount(driver).click();
	 Login_page.WaitForElementPresent(driver);
	  Login_page.textbox_UserName(driver).sendKeys("qatek");
	  Login_page.textbox_Password(driver).sendKeys("Automation1!");
	  Login_page.button_Login(driver).click();
	  MyAccount_page.WaitForElementPresent(driver);
	  System.out.println("Login successfully");
	  MyAccount_page.link_Logout(driver).click();
  }
  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
	  
	  
  }

}
