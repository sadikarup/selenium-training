package qahrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NumberOfLinks_Page {

	
	
		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,60);
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		driver.manage().window().maximize();
		String username="qaplanet1";
		String passwd="user1";
		driver.findElement(By.name("txtUserName")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(passwd);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(4000);
		
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	      System.out.println("Number of Links in the Page is " + links.size());
	      
	      for (int i = 1; i<=links.size(); i=i+1) {
	         System.out.println("Name of Link# " + i +" is: " +links.get(i).getText());
	         
	        // Thread.sleep(4000);
	       //  driver.close();
	}

}
		}
