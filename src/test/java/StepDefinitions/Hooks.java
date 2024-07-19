package StepDefinitions;

import Utilities.PropertiesReader;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Base64;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static ThreadLocal<FirefoxDriver> driver = new ThreadLocal<>();

    @Before
    public void openBrowser() throws Exception {
        WebDriverManager.firefoxdriver().setup();
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1440,768", "--disable-gpu");
        driver.set(new FirefoxDriver());
        Hooks driver = new Hooks();

        PropertiesReader propertiesReader = new PropertiesReader();
        driver.getDriver().manage().timeouts().implicitlyWait(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.getDriver().manage().timeouts().setScriptTimeout(propertiesReader.getTimeout(), TimeUnit.SECONDS);
        driver.getDriver().manage().deleteAllCookies();
        driver.getDriver().manage().window().maximize();
//        driver.getDriver().get(PropertiesReader.getValue("url"));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                String base64Image = Base64.getEncoder().encodeToString(screenshot);
                scenario.attach(base64Image, "image/png", "screenshot");
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
//        getDriver().close();
    }
}
