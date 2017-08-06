package qahrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddLocation_AlertHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	System.setProperty("webdriver.chrome.driver", "C:\\seleniumPractice\\chromedriver.exe");
	
	ChromeDriver driver = new ChromeDriver();
	
	WebDriverWait wait = new WebDriverWait(driver,60);
	
	driver.manage().window().maximize();
	
	driver.navigate().to("http://apps.qaplanet.in/qahrm/login.php");
	driver.navigate().back();
	driver.navigate().forward();
	
	//Login details and submit
	
	String loginusername = "qaplanet1";
	String loginpassword = "user1";
	
	
	driver.findElement(By.name("txtUserName")).sendKeys(loginusername);
	driver.findElement(By.name("txtPassword")).sendKeys(loginpassword);
	driver.findElement(By.name("Submit")).click();
	
	//verify login welcome page
	
	String welText = driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
	
	if(welText.equals("Welcome "+ loginusername)){
		System.out.println("Home page is displayed");
	}
	else{
		System.out.println("Login failed");
		driver.quit();
		return;
		
	}
	
	/*----Add location----******--------
	 * 
	 * ------*******--------------------*/
	
	//mouse hover to admin element
	
	Actions act1 = new Actions(driver);
	
	WebElement admin = driver.findElement(By.xpath("//*[@id='admin']/a"));
	act1.moveToElement(admin).perform();
	
	//mouse hover to company info
	
	WebElement companyinfo = driver.findElement(By.xpath("//*[@id='admin']/ul/li[1]/a/span"));
	act1.moveToElement(companyinfo).perform();
	
	//click on Locations link
	
	driver.findElement(By.xpath("//*[@id='admin']/ul/li[1]/ul/li[2]/a/span")).click();
	
	//wait for frame and switch to it
	
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
	
	String screentext = driver.findElement(By.xpath("/html/body/div/div[2]/form/div[1]/h2")).getText();
	
	if(screentext.equals("Company Info : Locations")){
		System.out.println("Company Info : Locations page displayed");
	}
	else{
		System.out.println("Company Info : Locations page NOT displayed");
	}
	
	//Locate Add and click
	
	driver.findElement(By.xpath("/html/body/div/div[2]/form/div[3]/div[1]/input[1]")).click();
	
	driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	
	
    String titletext = driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/h2")).getText();
	
	if(screentext.equals("Company Info : Locations")){
		System.out.println("Company Info : Locations (inside page) displayed");
	}
	else{
		System.out.println("Company Info : Locations page NOT displayed");
	}

	//click on SAVE without entering any data
	
	driver.findElement(By.id("editBtn")).click();
	
	 wait.until(ExpectedConditions.alertIsPresent());
	 Alert alt1 = driver.switchTo().alert();
	String alttext1 = alt1.getText();
	String actualtext = "Please correct the following\n\n - Location Name has to be specified\n - Country should be selected!\n - Address should be specified\n - Zip Code should be specified";
	
	//if(alttext1.equals(actualtext)){
		
		System.out.println("Alert displayed as below :\n "+actualtext);
		//System.out.println("alert is displayed");
		alt1.accept();
	
    //else{
	//	System.out.println("the below unexpected msg displayed\n "+alttext1);
	

	driver.close();
	
	}		
	}
	
