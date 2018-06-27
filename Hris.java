package qainfotech;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Hris {
	WebDriver wd;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\chavisikand\\eclipse-workspace\\qainfotech\\driver\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.get("https://hris.qainfotech.com/login.php");
	}

	@Test(priority = 0)
	public void positiveLoginAndLogoutTest() throws InterruptedException {
		wd.findElement(By.className("icon-lock")).click();
		wd.findElement(By.id("txtUserName")).sendKeys("chavisikand");
		wd.findElement(By.id("txtPassword")).sendKeys("Chavi@321#");
		wd.findElement(By.name("Submit")).click();
		wd.findElement(By.className("user-image")).click();

		Thread.sleep(5000);
		wd.findElement(By.xpath("//span[.='Logout']")).click();
	}

	@Test(priority = 1)
	public void invalidUsername() throws InterruptedException {
		wd.findElement(By.className("icon-lock")).click();
		wd.findElement(By.id("txtUserName")).sendKeys("123");
		wd.findElement(By.id("txtPassword")).sendKeys("Chavi@321#");

		wd.findElement(By.name("Submit")).click();
		wd.findElement(By.className("icon-lock")).click();
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void enterOnlyPassword() {

		wd.findElement(By.id("txtPassword")).sendKeys("Chavi@321#");
		wd.findElement(By.name("Submit")).click();

	}

}
