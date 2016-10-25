import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MouseMovements {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://americangolf.co.uk");
		
		WebElement golfClubs = driver.findElement(By.xpath("//*[@id='navigation']/nav/ul/li[1]/a"));
		
		Actions act = new Actions(driver);
		
		
		//Move the mouse pointer
		act.moveToElement(golfClubs).build().perform();
		
		//click on random link
		
		WebElement box = driver.findElement(By.xpath("//*[@id='CLUBS_1']"));
		
		List<WebElement> links = box.findElements(By.tagName("a"));
		
		int totalLinks = links.size();
		
		Random random = new Random();
		
		int randomNum = random.nextInt(totalLinks);
		
		links.get(randomNum).click();
		
		//click on specific link
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='CLUBS_1']/div[1]/ul[2]/li/ul/li[2]/ul/li[1]/a")));
		
		driver.findElement(By.xpath("//*[@id='CLUBS_1']/div[1]/ul[2]/li/ul/li[2]/ul/li[1]/a")).click();*/
      
		
		WebElement draggableElm = driver.findElement(By.xpath("//*[@id='secondary']/div[1]/div[2]/div[1]/div[1]/span[1]"));
		//drag the element
		
		act.dragAndDropBy(draggableElm, 70, 0).build().perform();
		
	}

}
