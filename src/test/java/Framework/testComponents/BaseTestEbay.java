package Framework.testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Framework.pageobjects.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestEbay 

{
	protected WebDriver driver;
	
	private static final String GLOBAL_DATA_FILE_PATH= "//src//main//java//Framework//resources//GlobalData.Properties";
	
	public static HomePage homePage;

	public WebDriver initializeDriver() throws IOException
	{

		Properties prop = loadProperties();
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

		if(browserName.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		if(browserName.contains("safari"))
		{

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod(alwaysRun=true)
	public HomePage launchApplication() throws IOException
	{
		WebDriver driver = initializeDriver();
		homePage = new HomePage(driver);
		homePage.goTo("https://www.ebay.com/");
		return homePage;
	}
	@AfterMethod(alwaysRun=true)

	public void tearDown()
	{
		if(driver!=null)
		{
			driver.close();
		}
		}
	private Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + GLOBAL_DATA_FILE_PATH);
        prop.load(fis);
        return prop;

}
}
