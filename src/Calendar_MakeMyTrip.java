import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Calendar_MakeMyTrip {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, ParseException {
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://us.makemytrip.com");
		
		driver.findElement(By.xpath("//*[@id='top_content']/div[2]/div[2]/div[2]/div[1]/div[7]/span/span[2]/a/span[1]")).click();

		selectDate("02/13/2016");
	}

	public static void selectDate(String date) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		Date dateToBeSelected = formatter.parse(date);
		
		String monthYearDisplayed = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div")).getText();
	
		System.out.println("monthYearDisplayed:"+monthYearDisplayed);
		
		String month = new SimpleDateFormat("MMMMM").format(dateToBeSelected);
		
		String year =  new SimpleDateFormat("YYYY").format(dateToBeSelected);
		
		String day = new SimpleDateFormat("d").format(dateToBeSelected);
		
		String monthYearToBeSelected = month+" "+year;
		
		System.out.println("monthYearToBeSelected:"+monthYearToBeSelected);
		
		System.out.println("Day:"+day);
		
		while(true)
		{
			if(monthYearToBeSelected.trim().equals(monthYearDisplayed.trim()))
			{
				driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
				break;
			}
			else{
				
				if(dateToBeSelected.after(new Date()))
				{
					driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[3]/div/a/span")).click();
				}
				else{
					
					driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/a/span")).click();
				}
			}
			
			monthYearDisplayed = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div")).getText();
		}
	}
}
