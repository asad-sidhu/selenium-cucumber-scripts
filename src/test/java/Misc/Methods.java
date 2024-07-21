package Misc;


import StepDefinitions.Hooks;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Methods {

    static Hooks driver = new Hooks();
    public static WebDriverWait wait = new WebDriverWait(driver.getDriver(), 10, 1);

    public static void click(By locator) {
        scroll(locator);
//        waitElementClickable(locator);
        driver.getDriver().findElement(locator).click();
    }

    public static void type(By locator, String text) {
        scroll(locator);
        waitElementClickable(locator);
        driver.getDriver().findElement(locator).clear();
        driver.getDriver().findElement(locator).sendKeys(text);
    }

    public static boolean isDisplayed(By locator) throws InterruptedException {
        boolean isDisplayed = driver.getDriver().findElement(locator).isDisplayed();
        return isDisplayed;
    }

    public static boolean isEnabled(By locator) throws InterruptedException {
        boolean isEnabled = driver.getDriver().findElement(locator).isEnabled();
        return isEnabled;
    }

    public static void enterKey(By locator) {
        waitElementVisible(locator);
        driver.getDriver().findElement(locator).sendKeys(Keys.ENTER);
    }

    public static String getText(By locator) {
        scroll(locator);
        waitElementVisible(locator);
        return driver.getDriver().findElement(locator).getText();
    }

    public static String getAttribute(By locator) {
        return driver.getDriver().findElement(locator).getAttribute("value");
    }

    public static void clear(By locator) {
        waitElementVisible(locator);
        driver.getDriver().findElement(locator).clear();
    }

    public static int size(By locator) {
        int elementSize = driver.getDriver().findElements(locator).size();
        return elementSize;
    }

    public static void waitElementVisible(By locator) {
        Methods methods = new Methods();
        methods.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitElementInvisible(String locator) {
        Methods methods = new Methods();
        methods.wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
    }

    public static void waitElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public static void scroll(By locator) {
        WebElement scroll = driver.getDriver().findElement(locator);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", scroll);
    }

    public static void scrollToTopOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver.getDriver();
        js.executeScript("window.scrollTo(0, 0)");
    }

    public static void hover(By locator) {
        WebElement hover = driver.getDriver().findElement(locator);
        Actions action = new Actions(driver.getDriver());
        action.moveToElement(hover).perform();
    }

    public static String getJsonValue(WebDriver driver, String jsonString, String key) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = String.format("return JSON.parse(arguments[0]).%s;", key);
        return (String) jsExecutor.executeScript(script, jsonString);
    }

}
