package task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;

public class Test1 extends BaseClass {

	@Test
	public void googletask()
	{
		initializebrowser();
		 driver.navigate().to("https://google.com");
	       
	        
	     driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("PRONTO"); //SearchBox
	        
	     List<WebElement> ele=driver.findElements(By.xpath("//div[@class='mkHrUc']")); //All OPtions in search box
	        
	     WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(10));
		 wait3.until(ExpectedConditions.visibilityOfAllElements(ele));
		     
	        for(WebElement all:ele)
	        {
	        	String allop=all.getText();
	        	System.out.println(allop);
	        }
	        
	}     
	  @AfterTest
	  public void closebrowser()
	  {
		 driver.close(); 
	  }
	        
	}
	
	
	
	

