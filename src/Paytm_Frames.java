import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Paytm_Frames {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		driver.get("http://paytm.com");
		
		driver.findElement(By.xpath("//*[@id='user-detail']/div/div[3]/div[3]/div/span/a[1]")).click();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		
		System.out.println("frames:"+frames.size());
		int frame=-1;
		int size = -1;
		for(int i=0;i<frames.size();i++)
		{
			
				driver.switchTo().frame(i);
			
				try{
					if(driver.findElement(By.xpath("//*[@name='username']")) != null)
					{	
						List<WebElement> usernameElms = driver.findElements(By.xpath("//*[@name='username']"));
						System.out.println(usernameElms.size());
						size = usernameElms.size();
						frame = i;
						driver.switchTo().defaultContent();
						break;
					}
				}
				catch(Exception ex)
				{
					System.out.println("Not found");
				}
				
				driver.switchTo().defaultContent();
			
		}
		
		System.out.println("frame:"+frame);
		
		if(frame != -1 && size == 1)
		{
			driver.switchTo().frame(frame);
			
			driver.findElement(By.xpath("//*[@name='username']")).sendKeys("xxxxx");
			
			driver.findElement(By.xpath("//*[@name='password']")).sendKeys("YYYY");
		}
	    
	}

}
