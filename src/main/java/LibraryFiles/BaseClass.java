package LibraryFiles;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
public 	WebDriver driver;
	
	public void initializebrowser()
	{
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Avenger\\eclipse-workspace\\TaskPronto\\Browsers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
		driver.manage().window().maximize();		
		
	}
}
