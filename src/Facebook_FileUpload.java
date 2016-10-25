import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Facebook_FileUpload {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("sandhya.boppana@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("fk8#K4214");
		
		driver.findElement(By.xpath("//label[@id='loginbutton']")).click();
		
		driver.findElement(By.xpath("//li[starts-with(@id,'navItem')]/a/div/span[text()='Sandhya Boppana']")).click();

		WebElement uploadElm = driver.findElement(By.xpath("//div[@class='photoContainer']/div/div/a/div"));
	
		Actions act = new Actions(driver);
		
		act.moveToElement(uploadElm).build().perform();
		
		driver.findElement(By.xpath("//div[@class='photoContainer']/div/div/a/div")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		System.out.println("windows:"+windows.size());
		
		WebDriverWait wait = new WebDriverWait(driver,30);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Upload Photo']")));
		
		driver.findElement(By.xpath("//span[text()='Upload Photo']")).click();
		
		Process process = new ProcessBuilder(System.getProperty("user.dir")+"/fileupload.exe","C:\\images\\IMG_1326.JPG","Open").start();
	
	    driver.findElement(By.xpath("//a[text()='Skip Cropping']")).click();
	    
	    driver.findElement(By.xpath("//span[text()='Save']")).click();
	}

}
