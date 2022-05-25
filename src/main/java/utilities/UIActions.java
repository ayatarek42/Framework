package utilities;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class UIActions {

    public WebDriver driver;

    public UIActions(String className) {
        this.driver = BrowserActions.drivers.get(className);
    }

    public void waitForTime(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void navigateTo(String URL) {
        driver.get(URL);
    }

    public WebElement findWebElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }


    public void waitForPageLoad(By by, int sec) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        } catch (Exception e) {
            System.out.println("element not loaded");
        }
    }

    public void doubleClick(WebElement ele) {
        Actions action = new Actions(driver);
        action.doubleClick(ele).perform();
    }

    public void dragAndDrop(WebElement ele1, WebElement ele2) {
        Actions action = new Actions(driver);
        action.dragAndDrop(ele1, ele2).perform();
    }

    public void selectFromDropdownList(String option, By by) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(option);
    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void enterTextInTextField(String s, By by) {
        driver.findElement(by).sendKeys(s);
    }


    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }
    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }


}
