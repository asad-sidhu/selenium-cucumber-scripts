package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseClass {

    private static WebDriver driver;

    public BaseClass(WebDriver driver) {

        BaseClass.driver = driver;
    }

}