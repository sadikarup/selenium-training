package qahrm;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//To delete duplicate entries(same name with different id)

public class DeleteEmployeeByName {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		
		driver.get("http://apps.qaplanet.in/qahrm/login.php");
		
		driver.manage().window().maximize();
		
		String username="qaplanet1";
		String passwd="user1";
		//String empid = "7089";
		
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
		
		//Delete an employee 
		
		Actions act1=new Actions(driver);
		WebElement pim=driver.findElement(By.xpath("//*[@id='pim']/a/span"));
		act1.moveToElement(pim).perform();
		
		//select employee list
		driver.findElement(By.xpath("//*[@id='pim']/ul/li[1]/a/span")).click();
		Thread.sleep(2000);
		
		//switch to frame
		driver.switchTo().frame("rightMenu");
		
		String screentext=driver.findElement(By.xpath("//*[@id='standardView']/div[1]/h2")).getText();
		
		//verify employee information page display
		if(screentext.equals("Employee Information"))
		{
			System.out.println("Employee Information page displayed");
		}
		else
		{
			System.out.println("Employee Information page not displayed");
		}
		
		//identify drop down element and select specific element
	    //select empid from dropdown
		WebElement searchBy = driver.findElement(By.xpath("//*[@id='loc_code']"));
	   
		//String selectspecificelement = "Emp. ID";
	    
	    Select sel = new Select(searchBy);
	        
	    sel.selectByIndex(2);
		
	    
	    //enter empname to get duplicate entries in search for
	    
	    String efirstname = "karup";
	    
	    driver.findElement(By.id("loc_name")).sendKeys(efirstname);
	    
	    driver.findElement(By.xpath("//*[@id='standardView']/div[2]/input[2]")).click();
	    
	   //get the row count
	    List<WebElement> lwe=driver.findElements(By.xpath("//*[@id='standardView']/table/tbody/tr"));
			    
	    int rc=lwe.size();
		System.out.println("Row count=" +rc);
		for(int i=1;i<rc;i++){
			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='standardView']/table/tbody/tr["+i+"]/td[1]/input"))).click();
		      	
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='standardView']/div[3]/div[1]/input[2]"))).click();
	      		   
	    //verify delete
	    String msgText = driver.findElement(By.xpath("//*[@id='standardView']/div[2]/span")).getText();
	    if(msgText.equals("Successfully Deleted")){
		  System.out.println("Only one employee is present and Duplicate Employees deleted succesfully");
	     }
		else
		  {System.out.println("Employee is unable to delete");
	      }
	    		
	    	
	   driver.switchTo().defaultContent();

	   //verify logout
	   driver.findElement(By.linkText("Logout")).click();
	   
	   Thread.sleep(2000);
	   
	   String stitle=driver.getTitle();
	   
	   if(stitle.equals("OrangeHRM - New Level of HR Management")){
		  System.out.println("Logout success and Login Page Displayed");
	   }
	   else{
		   System.out.println("Logout failed");
	       driver.close();
	  }
      }
      }
		
		

		


