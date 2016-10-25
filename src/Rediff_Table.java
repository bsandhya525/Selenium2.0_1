import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Rediff_Table {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		String companyName ="Tata Consultancy";
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		driver.get("http://money.rediff.com/gainers/bse/weekly");
		
		List<WebElement> companyNames = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		System.out.println("Companies:"+companyNames.size());
		
		System.out.println("Current Prices:"+currentPrices.size());
		
		for(int i=0;i<companyNames.size();i++)
		{
			if(companyName.trim().equals(companyNames.get(i).getText().trim()))
			{
				System.out.println(companyName+"----"+currentPrices.get(i).getText());
				
				break;
			}
		}
		
		System.out.println("row:"+getRowWithCellData(" NDTV "));

	}
	
	public static int getRowWithCellData(String data)
	{
		int row = -1;
		
		int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		
		int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		
				
		System.out.println("Rows:"+rows+",cols:"+cols);
		
		for(int rowNum=1;rowNum<=rows;rowNum++)
		{
			for(int colNum=1;colNum<=cols;colNum++)
			{
				String celldata = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rowNum+"]/td["+colNum+"]")).getText();
				
				System.out.println("celldata:"+celldata);
				if((data.trim()).equals(celldata.trim()))
				{
					row = rowNum;
					return row;
				}
			}
		}
		
		return row;
	}

}
