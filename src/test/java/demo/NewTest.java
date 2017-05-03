package demo;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class NewTest {
  @SuppressWarnings("deprecation")
@Test
  public void f() throws InterruptedException {
 //WebDriver driver = new HtmlUnitDriver();
	  
	  System.setProperty("webdriver.chrome.driver", "\WebDrivers\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
 driver.get("https://litdev-dev-ed.my.salesforce.com");
 Thread.sleep(2000);

 WebElement uname = driver.findElement(By.id("username"));
 uname.sendKeys("ajay.sadgurujaggi@gmail.com.devops");
 Thread.sleep(2000);
 
 WebElement pwd = driver.findElement(By.id("password"));
 pwd.sendKeys("Naani@1234");
 Thread.sleep(2000);
 
 WebElement login = driver.findElement(By.id("Login"));
 login.submit();
 Thread.sleep(3000);
 
 
  Assert.assertEquals("Verify Your Identity | Salesforce", driver.getTitle());
  }
}
