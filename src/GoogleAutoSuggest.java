import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class GoogleAutoSuggest {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		//System.setProperty("webdriver.firefox.marionette", "C:/geckodriver-v0.10.0-win64/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
		driver.get("http://google.com");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");

		List<WebElement> box = driver.findElements(By.xpath("//div[@class='sbdd_b']"));
		
		List<WebElement> links = box.get(0).findElements(By.xpath("//*[contains(text(),'selenium')]"));
		
		System.out.println(links.size());
		
		for(int i=0;i<links.size();i++)
		{
			WebElement link = links.get(i);
			System.out.println(link.getTagName());
			if(link.getTagName().equals("a"))
				System.out.println(link.getText()+"---"+link.getAttribute("href"));
			else
				System.out.println(link.getText());
		}
	}

}
