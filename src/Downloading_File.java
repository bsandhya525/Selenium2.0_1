

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Downloading_File {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		FirefoxProfile profile = new FirefoxProfile();
		
		profile.setPreference("browser.download.folderList", 2);// 0(Desktop),1(downloads),2(specific folder)
	
		profile.setPreference("browser.download.manager.showWhenStarting",false);//prevents download mananger window
		
		profile.setPreference("browser.download.dir","C:\\Temp");
		
		//profile.setPreference("browser.helperApps.neverAsk.openFile",
		//		"text/csv,application/msword,text/html,text/plain,image/jpeg,application/javascript,video/mpeg,application/powerpoint,application/excel,application/xml,application/zip,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document");
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"text/csv,application/msword,text/html,text/plain,image/jpeg,application/javascript,video/mpeg,application/powerpoint,application/excel,application/xml,application/zip,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document");
	
		//For Firefox
		/*WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://qtpselenium.com/test/testdownload.php");
		
		driver.findElement(By.xpath("//html/body/a[1]")).click();
		
		driver.findElement(By.xpath("//html/body/a[2]")).click();
		
		driver.findElement(By.xpath("//html/body/a[4]")).click();*/
		
		//for chrome
		
		/*System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qtpselenium.com/test/testdownload.php");
		driver.findElement(By.xpath("//html/body/a[1]")).click();*/
		
		//For IE. It won't work in IE11
		
		System.setProperty("webdriver.ie.driver","C:\\IEDriverServer_x64_2.49.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://qtpselenium.com/test/testdownload.php");
		driver.findElement(By.xpath("//html/body/a[1]")).click();
			
	    Robot robot = new Robot();
	    
	    robot.mouseMove(630, 420); // move mouse point to specific location 
        robot.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step   
       /* robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click 
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click 
        robot.delay(1500);*/  
        robot.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button   
        Thread.sleep(2000); 
        robot.keyPress(KeyEvent.VK_ENTER);
	}

}
