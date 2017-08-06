package qahrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.uk/");
		Thread.sleep(2000);
		WebElement serch = driver.findElement(By.xpath("//*[@id='lst-ib']"));
		serch.sendKeys("selenium");
		
		Thread.sleep(5000);
		
		List<WebElement> lic = driver.findElements(By.xpath("//*[@id='sbse0']/div[2]"));
	
		
		for(WebElement LI:lic){
			System.out.println(LI.getText());
			Thread.sleep(2000);
			driver.close();
			
			
		}
		
	}

}
