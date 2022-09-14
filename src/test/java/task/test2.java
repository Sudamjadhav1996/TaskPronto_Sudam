package task;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;

public class test2 extends BaseClass {
	
	@BeforeTest
	public void openBrowser()
	{
		initializebrowser();	
	}
	
	@BeforeClass
	public void LaunchApp()
	{
		 driver.get("https://flipkart.com");
		 Actions act=new Actions(driver);
	     act.sendKeys(Keys.ESCAPE).perform();
	    // driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys("8799819979");
	    // driver.findElement(By.xpath("(//input[@autocomplete='off'])[3]")).sendKeys("Sudam@123");
	    //  driver.findElement(By.xpath(" //button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
        driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Mobiles under 20000");
	    act.sendKeys(Keys.ENTER).perform();     
	}
	
	@Test (priority=1)
	
	public void mobile1()
	{
		 
	     //   driver.findElement(By.xpath("//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)']")).click();  stale element exception
	     WebElement opt1=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));  //  
	        try
	        {
	        	opt1.click();
	        }
	        catch(StaleElementReferenceException e)
	        {
	        	opt1=driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
	        	opt1.click();
	        }
	     List<String> allwindow=new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(allwindow.get(1));
	     driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();  //add to cart
	        
	}

	@Test  (priority=2)
	public void mobile2()
	{
		//2nd mobile
	    List<String> allwindow=new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(allwindow.get(0));
        driver.findElement(By.xpath("//div[text()='vivo T1 5G (Rainbow Fantasy, 128 GB)']")).click();   //vivo
        
        List<String> allwindow1=new ArrayList<String>(driver.getWindowHandles());
	    
	     
        driver.switchTo().window(allwindow1.get(2));
        
      
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();  //add to cart
        
	        
	}
	
	@Test  (priority=3)
	public void mobile3()
	{
		 List<String> allwindow=new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(allwindow.get(0));
         
	     WebElement ele3=driver.findElement(By.xpath("//div[text()='realme 9 5G (Supersonic Black, 64 GB)']"));
	      
	      WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(10));
	      wait2.until(ExpectedConditions.elementToBeClickable(ele3));
	     
	     JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].click();", ele3);
	        //Thread.sleep(3000);
	     List<String> allwindow2=new ArrayList<String>(driver.getWindowHandles());   
	     driver.switchTo().window(allwindow2.get(3));
	     driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();  //add to cart
	   
	}
	
	@Test  (priority=4)
	public void saveForLater()
	{
         WebElement save=driver.findElement(By.xpath("(//div[text()='Save for later'])[3]"));   //save for later
         JavascriptExecutor js=(JavascriptExecutor)driver;
	     js.executeScript("arguments[0].click();", save);
	     
	     
	   
	     WebElement vivo=driver.findElement(By.xpath("//a[text()='vivo T1 5G (Rainbow Fantasy, 128 GB)']"));
	  
       
	     System.out.println(vivo.getText());
	     

	     WebElement realme=driver.findElement(By.xpath("//a[text()='realme 9 5G (Supersonic Black, 64 GB)']"));
	     
        System.out.println(realme.getText()); 
	    
	   
	}
	
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
}
