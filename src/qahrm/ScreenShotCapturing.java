package qahrm;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.java.util.jar.pack.Package.File;

public class ScreenShotCapturing {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

System.setProperty("webdriver.chrome.driver","C:\\seleniumPractice\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
//driver.get("http://apps.qaplanet.in/qahrm/login.php");
driver.get("http://www.echoecho.com/htmlforms10.htm");
driver.manage().window().maximize();
//Thread.sleep(2000);

//take screen shot of current driver page
File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

FileUtils.copyFile(srcfile, new File("C:\\Users\\USER\\Documents\\scrshot\\xyz.jpg"));

Thread.sleep(4000);
driver.close();
//driver.quit();



	}
	

}
