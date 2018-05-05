package automationFramework;
import org.testng.annotations.Test;
import appModule.OpenBrowser;
import appModule.SignIn_Action;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import pageObjects.MyAccount_page;
import utility.Constant;
import utility.ExcelUtils;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
public class Module_TC {
	private static WebDriver driver = null;
	@BeforeTest
	public void beforeTest() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		OpenBrowser.Load_online(driver,Constant.URL);
	}
	@Test

	public void run() throws Exception {
		SignIn_Action.Execute(driver);
		MyAccount_page.WaitForElementPresent(driver);
		MyAccount_page.link_Logout(driver).click();
	}
	@AfterTest
	public void afterTest() throws Exception {
		driver.quit();
		ExcelUtils.SetCellData(Constant.Path_TestData, "Sheet1", 1, 3, "Pass");
	}

}
