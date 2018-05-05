package appModule;

import org.openqa.selenium.WebDriver;

public class OpenBrowser {
	
	public static void  Load_online(WebDriver driver,String baseUrl ){
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	

}
