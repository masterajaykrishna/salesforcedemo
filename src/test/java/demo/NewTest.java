package demo;

import java.sql.Driver;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class NewTest {
 WebDriver driver;
	
	@SuppressWarnings("deprecation")

  public void f() throws InterruptedException {
 //WebDriver driver = new HtmlUnitDriver();
	  
	  System.setProperty("webdriver.chrome.driver", "D:\\salesforceSelenium\\BasicDemo\\WebDrivers\\chromedriver.exe");
	   driver = new ChromeDriver();
	   
 driver.get("https://litdev-dev-ed.my.salesforce.com");
 Thread.sleep(2000);
 
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

 
  Assert.assertEquals("Salesforce - Developer Edition", driver.getTitle());
  }
 @Test
  public void createAccount()throws Exception{
	 f();
	 Thread.sleep(5000);

	 WebElement campaign=  driver.findElement(By.xpath("//*[@id=\"Campaign_Tab\"]/a"));
	 campaign.click();
	 Thread.sleep(2000);
	 WebElement acct=  driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
	
	acct.click();
	 Thread.sleep(2000);
	 
	 WebElement newBtn=  driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
	 	newBtn.click();
		 Thread.sleep(4000);
		 WebElement acctName=  driver.findElement(By.xpath("//*[@id=\"acc2\"][@tabindex=\"1\"]"));
		 acctName.sendKeys("ajay");
		 Thread.sleep(2000);
		 WebElement saveBtn=  driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		 saveBtn.click();
		 Thread.sleep(3000);
		 WebElement editBtn=  driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[3]"));
		 Assert.assertTrue(editBtn.isEnabled());	
		 
		 //
	 
	
	 
  }
  
  @Test
  public void createAccountError()throws Exception{
	 f();
	 WebElement campaign=  driver.findElement(By.xpath("//*[@id=\"Campaign_Tab\"]/a"));
	 campaign.click();
	 Thread.sleep(2000);
	 WebElement acct=  driver.findElement(By.xpath("//*[@id=\"Account_Tab\"]/a"));
	 acct.click();
	 Thread.sleep(2000);
	 WebElement newBtn=  driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
	 	newBtn.click();
	 Thread.sleep(2000);
	 WebElement saveBtn=  driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
	saveBtn.click();
	 Thread.sleep(2000);
	 
	

	WebElement messageOne= driver.findElement(By.xpath("//*[@id=\"errorDiv_ep\"]"));
	Assert.assertEquals("Error: Invalid Data."
			+"\n"+ "Review all error messages below to correct your data.",messageOne.getText());
	
	
}
}
