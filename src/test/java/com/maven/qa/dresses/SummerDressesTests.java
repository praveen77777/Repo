package com.maven.qa.dresses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SummerDressesTests {
public WebDriver driver;
	
	@Test(priority=0)
  
		public void login() throws Exception {

		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		WebElement signin=driver.findElement(By.id("SubmitLogin"));
		
		js.executeScript("arguments[0]",signin);
		
		driver.findElement(By.id("email")).sendKeys("demo123@mailsac.com");
		
		driver.findElement(By.id("passwd")).sendKeys("demo123@");
		
		signin.click();
		
		Thread.sleep(2000);
		
	  }	
	
	
	@Test(priority=1)
	  public void placeorder() throws Exception {
		
	  // Click "Dresses" link
	  
	  driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
	  
	  Thread.sleep(2000);
	  
	  //Click Summer Dresses link
	  driver.findElement(By.xpath("//*[@id='categories_block_left']/div/ul/li[3]/a")).click();
	  
	  Thread.sleep(1500);
	  
	  //click "Black" checkbox
	  driver.findElement(By.id("layered_id_attribute_group_11")).click();
	  
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath(".//*[@id='center_column']/ul/li/div/div[2]/h5/a")).click();
	  
	  Thread.sleep(2000);
	  
	  driver.findElement(By.name("Submit")).click();
	  
	  Thread.sleep(2500);
	  
	  driver.findElement(By.xpath(".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
	  
	  WebElement proceed_to_check_out=driver.findElement(By.xpath("//*[text()='Proceed to checkout']"));
	  
	  js.executeScript("arguments[0]",proceed_to_check_out);
	  
	  proceed_to_check_out.click();
	  
	  Thread.sleep(2000);
	  
	  WebElement comments_area=driver.findElement(By.xpath(".//*[@id='ordermsg']/textarea"));
	  
	  js.executeScript("arguments[0]",comments_area);
	  
	  comments_area.sendKeys(" Please ensure that the material is not subject to damage before packing it.");
	  
	  driver.findElement(By.xpath(".//*[@id='center_column']/form/p/button")).click();
	  
	  //click checkbox
	  
	  WebElement check_box=driver.findElement(By.id("cgv"));
	  
	  js.executeScript("arguments[0]", check_box);
	  
	  check_box.click();
	  
	  driver.findElement(By.xpath("//*[@id='form']/p/button")).click();
	  
	  //pay by check
	  
	  js.executeScript("arguments[0]", driver.findElement(By.xpath("//a[@title='Pay by check.']")));
	  
	  
	  driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
	  
	  Thread.sleep(2000);
	  
	  // i confirm my order
	  
	  js.executeScript("arguments[0]", driver.findElement(By.xpath(".//*[@id='cart_navigation']/button")));
	  
	  driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
	  
	  js.executeScript("arguments[0]", driver.findElement(By.xpath("//a[@title='Back to orders']")));
		  
	  driver.findElement(By.xpath("//a[@title='Back to orders']")).click();
		  
	  Thread.sleep(3000);
		  
	 //signout
	  
	 // js.executeScript("arguments[0]",driver.findElement(By.xpath("//a[text()='Sign out']")));
	  
	  //Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	  
	  
	  
	 }
	  
	  @AfterTest
	  public void close()
	  {
		  driver.close();

	  }
	  
	 
	  @BeforeTest
	  public void initialize() {
		
	   driver=new FirefoxDriver();
	   
	   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   
	   driver.get("http://automationpractice.com/index.php");
	

}
}
