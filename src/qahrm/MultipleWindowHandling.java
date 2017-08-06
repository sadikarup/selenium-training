package qahrm;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com/gmail/about/#");
		
		WebDriverWait wait = new WebDriverWait(driver,60);
		
		driver.findElement(By.xpath("/html/body/nav/div/a[2]")).click();
		
		//locate element Help and click
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='initialView']/footer/ul/li[1]/a"))).click();;
		
		Set<String> handles = driver.getWindowHandles();
		
		 Object[] array = handles.toArray();
		 String handle1 = (String) array[0];
		 String handle2 = (String) array[1];
		 
		 //print handles just for info
		 
		 System.out.println("Window hanlde1 ="+handle1);
		 System.out.println("Window hanlde2 ="+handle2);
		 
		 //switch to window 2
		 
		 driver.switchTo().window(handle2);
		 System.out.println("I am in window 2");
		 
		 //get text present in element1 from window 2
		 String win2Text1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/section/div/article/nav/h1"))).getText();
		 //print text present in element from window 2
		 System.out.println("Window 2 element text (should be\"Welcome to the Google Account Help Centre)\"="+win2Text1);
		 
		 //switch to window1
		 driver.switchTo().window(handle1);
		 
		 System.out.println("I am in window 1");
		 
		 String textinfirstwindow = driver.findElement(By.xpath("//*[@id='initialView']/footer/ul/li[3]/a")).getText();
		 System.out.println("window 1 text should be\"Terms\" ="+textinfirstwindow);
		 
		 //switch to window2
		 driver.switchTo().window(handle2);
		 
		 driver.manage().window().maximize();
		 
		 String win2text2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/footer/div[1]/div[1]/div/div/h2"))).getText();
		 
		 System.out.println("window 2 text of element2 should be\"Protect your account\"="+win2text2);
		 Thread.sleep(2000);
		 
		 //close window2
		 driver.close();
		 Thread.sleep(2000);
		 //swich to window 1
		 
		 driver.switchTo().window(handle1);
		 driver.close();
		 
		
	}

}
