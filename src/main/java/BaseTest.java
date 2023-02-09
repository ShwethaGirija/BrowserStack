import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	
	@Parameters("browserName")
	@BeforeMethod
	public void setup(String browserName) throws MalformedURLException
	{
		String username = "shwetham_7WPlSg";
		String accessKey = "9CFJK7NtVqhEHoLgzXq3";
		///String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
		//String local = System.getenv("BROWSERSTACK_LOCAL");
		//String Localidentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("browserName", "Chrome");
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
//		browserstackOptions.put("sessionName", "BStack Build Name: " + buildName);
	//	browserstackOptions.put("local", local);
	//	browserstackOptions.put("localIdentifier", localIdentifier);
		browserstackOptions.put("seleniumVersion", "4.0.0");
		capabilities.setCapability("bstack:options", browserstackOptions);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			capabilities.setCapability("browserName", "Chrome");
		} else if (browserName.equals("firefox")) {
		//	WebDriverManager.firefoxdriver().setup();
			capabilities.setCapability("browserName", "Firefox");
		}
	
			
		URL url = new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub");
				 driver = new RemoteWebDriver(url, capabilities);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
