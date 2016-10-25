import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FileUploads_Selenium {

	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://qtpselenium.com/test/uploadform/contactform.php");

		//driver.findElement(By.xpath("//input[@id='photo']")).sendKeys("C:\\images\\flowers.png");
		
		driver.findElement(By.xpath("//input[@id='photo']")).click();
		
		Process process = new ProcessBuilder(System.getProperty("user.dir")+"/fileupload.exe","C:\\images\\flowers.png","Open").start();
	}
   //AUTO - IT tool - for uploading files
} 
