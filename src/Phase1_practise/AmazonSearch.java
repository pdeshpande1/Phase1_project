package Phase1_practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		//WebDriverWait wait= new WebDriverWait(driver, 50);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='fb_logo _8ilh img']")));
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement product= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement search= driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		product.sendKeys("IPhone12");
		search.click();
		
		List<WebElement> product_list= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")); //a-size-medium a-color-base a-text-normal, span[contains(text(),'Apple iPhone 1')]
		List<WebElement> product_price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		System.out.println("Count of Iphone = " +product_list.size());
		for (WebElement elm: product_list )
		{
			System.out.println(elm.getText());
			}
		
		System.out.println("Count of prices= " +product_price.size());
		for (WebElement elm1: product_price)
		System.out.println("Prices are = " +elm1.getText());
		
		for(int i=0; i<product_list.size();i++)
		{
			if (product_list.get(i).getText().contains("Apple iPhone 1"))
			{
				System.out.println("Name of Product : " +product_list.get(i).getText() + " Price =" +product_price.get(i).getText());
			}
		}
		

}
}
