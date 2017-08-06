package qahrm;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPS_PageHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		File file = new File("C:\\seleniumPractice\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		WebDriver driver = new ChromeDriver(capability);
		driver.get("http:axisbank.com");
		
		
	}

}
