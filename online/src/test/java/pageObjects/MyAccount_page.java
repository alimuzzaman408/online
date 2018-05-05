package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount_page {
	
private static WebElement element = null;
	
	public static WebElement link_Logout(WebDriver driver) {
		element = driver.findElement(By.xpath(".//*[@id='meta']/ul/li/a[text()='Log out']"));
		return element;
	}

	public static void WaitForElementPresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='meta']/ul/li/a[text()='Log out']")));
	}
	
	
	

}
