package Misc;


import StepDefinitions.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static StepDefinitions.Hooks.getDriver;


public class Methods {

    static Hooks driver = new Hooks();
    static Actions actions = new Actions(getDriver());
    public static WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1);
    static Robot robot;

    public static void pressEnter(){
        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    public static void click(By locator) {
        scroll(locator);
        waitElementClickable(locator);
        getDriver().findElement(locator).click();
    }

    public static void doubleClick(By locator) {
        scroll(locator);
        waitElementClickable(locator);
        actions.doubleClick(getDriver().findElement(locator)).perform();
    }

    public static void rightClick(By locator) {
        scroll(locator);
        waitElementClickable(locator);
        actions.contextClick(getDriver().findElement(locator)).perform();
    }

    public static void type(By locator, String text) {
        scroll(locator);
        waitElementClickable(locator);
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(text);
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);    }

    public static void doubleKeyAction(Keys key1, String key2) {
        actions.keyDown(key1)
                .sendKeys(key2)
                .keyUp(key1)
                .perform();
    }

    public static boolean isDisplayed(By locator) throws InterruptedException {
        return getDriver().findElement(locator).isDisplayed();
    }

    public static boolean isEnabled(By locator) throws InterruptedException {
        return getDriver().findElement(locator).isEnabled();
    }

    public static void enterKey(By locator) {
        waitElementVisible(locator);
        getDriver().findElement(locator).sendKeys(Keys.ENTER);
    }

    public static String getText(By locator) {
        scroll(locator);
        waitElementVisible(locator);
        return getDriver().findElement(locator).getText();
    }

    public static String getAttribute(By locator) {
        return getDriver().findElement(locator).getAttribute("value");
    }

    public static void clear(By locator) {
        waitElementVisible(locator);
        getDriver().findElement(locator).clear();
    }

    public static int size(By locator) {
        return getDriver().findElements(locator).size();
    }

    public static void waitElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitElementInvisible(String locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
    }

    public static void waitElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void scroll(By locator) {
        WebElement scroll = getDriver().findElement(locator);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
    }

    public static void scrollToTopOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, 0)");
    }

    public static void hover(By locator) {
        WebElement hover = getDriver().findElement(locator);
        Actions action = new Actions(getDriver());
        action.moveToElement(hover).perform();
    }

    public static String getJsonValue(WebDriver driver, String jsonString, String key) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = String.format("return JSON.parse(arguments[0]).%s;", key);
        return (String) jsExecutor.executeScript(script, jsonString);
    }

    public static String getAbsolutePath(String relativePath) {
        File file = new File(relativePath);
        return file.getAbsolutePath();
    }

}
