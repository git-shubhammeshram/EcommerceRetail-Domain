package Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.ExtentReportManager;
import Utility.ReadFileData;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	 public static ExtentReports report = ExtentReportManager.getExtentReportManager();
	 public static ExtentTest logger;
	 
	 
	public static WebDriver driver;

	public static void initialization() throws InterruptedException, IOException {

		String browser = ReadFileData.readConfigData("Browser");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();

                break;
            case "egde":
                WebDriverManager.edgedriver();
                driver = new EdgeDriver();

                break;
            case "firefox":
                WebDriverManager.firefoxdriver();
                driver = new FirefoxDriver();

                break;
            case "safari":
                WebDriverManager.safaridriver();
                driver = new SafariDriver();

                break;
        }
		
		driver.get(ReadFileData.readConfigData("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		

	}

}
