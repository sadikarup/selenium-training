package qahrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployee {

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
	//Thread.sleep(3000);
	String weltext=driver.findElement(By.xpath("//*[@id='option-menu']/li[1]")).getText();
	if(weltext.equals("Welcome "+username))
	{
	 System.out.println("Login success");
	}
	else
	{
		System.out.println("Login failed");
		driver.quit();
		return;
	}
	
	//Add an employee 
	
	Actions act1=new Actions(driver);
	WebElement pim=driver.findElement(By.xpath("//*[@id='pim']/a/span"));
	act1.moveToElement(pim).perform();
	driver.findElement(By.xpath("//*[@id='pim']/ul/li[2]/a/span")).click();
	Thread.sleep(3000);
	driver.switchTo().frame("rightMenu");
	String screentext=driver.findElement(By.xpath("//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText();
	
	if(screentext.equals("PIM : Add Employee"))
	{
		System.out.println("Add Employee page displayed");
	}
	else
	{
		System.out.println("Add Employee  page not displayed");
	}
	
	String lname="Harshika";
	String fname="Karup";
	String empid=driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
	WebElement lastname=driver.findElement(By.id("txtEmpLastName"));
	lastname.isDisplayed();
	lastname.clear();
	lastname.sendKeys(lname);
	
    JavascriptExecutor js=(JavascriptExecutor)driver;
    String jsUN="document.getElementsByName('txtEmpFirstName')[0].value="+"'"+fname+"'";
    js.executeScript(jsUN);
    
    // Save Employee details
    
    driver.findElement(By.id("btnEdit")).click();
    
    Thread.sleep(2000);
    driver.switchTo().defaultContent();
    Actions act2=new Actions(driver);
    act2.moveToElement(pim).perform();
    driver.findElement(By.xpath("//*[@id='pim']/ul/li[1]/a/span")).click();
    
    driver.switchTo().frame("rightMenu");
    List<WebElement> lwe=driver.findElements(By.xpath("//*[@id='standardView']/table/tbody/tr"));
	int rc=lwe.size();
	System.out.println("Row count=" +rc);
	for(int i=1;i<=rc;i++)
	{
		String eid=driver.findElement(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[2]")).getText();
	if(eid.equals(empid))
	{
		System.out.println("Matching empid found ="+empid);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[3]/a"))).click();
	break;
	}
	
	}
	
	String title=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='personal']/div[1]/div[2]/div[1]/h2"))).getText();
	System.out.println(title+" Page displayed");
	String sfirstname=driver.findElement(By.id("txtEmpFirstName")).getAttribute("value");
	String slastname=driver.findElement(By.id("txtEmpLastName")).getAttribute("value");
    if(fname.equals(sfirstname) && lname.equals(slastname))
    {
	System.out.println(empid+" "+sfirstname+" "+slastname+ "Matching found");
	System.out.println("Test passed");
    }
	
    driver.switchTo().defaultContent();
    driver.findElement(By.linkText("Logout")).click();
    Thread.sleep(2000);
    String stitle=driver.getTitle();
    if(stitle.equals("OrangeHRM - New Level of HR Management"))
	System.out.println("Logout success and Login Page Displayed");
    else
	System.out.println("Logout failed");
   driver.close();
	}


	}


