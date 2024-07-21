package StepDefinitions;

import Utilities.PropertiesReader;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() throws Exception {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            PropertiesReader propertiesReader = new PropertiesReader();
            driver.manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String base64Image = Base64.getEncoder().encodeToString(screenshot);
                scenario.attach(base64Image, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
