package qahrm;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Javascriptalert {
	public static void main(String arg[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.findElement(By.name("proceed")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a1=driver.switchTo().alert();
		Thread.sleep(3000);
		String alertmsg=a1.getText();
		System.out.println("Alert message is "+alertmsg);
		
		if(alertmsg.equals("Please enter thea valid user name"))
			System.out.println("Alert msg displayed");
		else
			System.out.println("alert msg mismatched");
		a1.accept();
		
		driver.switchTo().defaultContent();
		
		driver.close();
	}
}
