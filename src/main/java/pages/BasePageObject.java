package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

  ChromeDriver driver;

  public BasePageObject(ChromeDriver driver) {this.driver = driver;}

  // this function for checking selected elements can be accessed
  private void expectElementIsPresent(By element) {
    WebDriverWait wait = driverWait(element);
    wait.until(ExpectedConditions.presenceOfElementLocated(element)).isEnabled();
  }

  public WebDriverWait driverWait(By element) {
    return new WebDriverWait(driver, 5);
  }

  // find web element component
  public WebElement find(By element) {
    expectElementIsPresent(element);
    return driver.findElement(element);
  }

  public List<WebElement> findAll(By element) {
    expectElementIsPresent(element);
    return driver.findElements(element);
  }

  // find selenium driver component
  public ChromeDriver finds() {
    return driver;
  }

  // function for input text
  // By element (cssSelector / id / xpath / name)
  public void inputText(By element, String text) {
    waitUntilVisible(element);
    find(element).sendKeys(text);
  }

  // function for clicking some button
  // By element (cssSelector / id / xpath / name)
  public void clickOn(By element) { find(element).click(); }

  // function for search any text inside the page
  // return always Boolean true | and will break the step if return != true
  public Boolean expectPageHasText(String expectedText) {
    String pageText = find(By.tagName("body")).getText();
    return pageText.contains(expectedText);
  }

  // function for search the element inside the page and make sure the elment is
  // displayed (return Boolean true) | and will break the step if return != true
  public Boolean expectPageHasElement(By element) {
    return find(element).isDisplayed();
  }

  // this function for getting text in some element, usually this step
  // will used for assertion between current text & expected text
  public String getText(By element) {
    expectPageHasElement(element);
    return find(element).getText();
  }

  // evaluating javascript function to be used on this java framework
  public Object evaluateJavascript(String script, Object args) {
    JavascriptExecutor jse = ((JavascriptExecutor) driver);
    return jse.executeScript(script, args);
  }

  // waiting until this element is not visible
  public Boolean waitUntilInvisible(By element) {
    WebDriverWait wait = driverWait(element);
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
  }

  // waiting until this element visible
  public Boolean waitUntilVisible(By element) {
    WebDriverWait wait = driverWait(element);
    return wait.until(ExpectedConditions.visibilityOfElementLocated(element))
        .isDisplayed();
  }

  // scroll down site
  public void scrollDown(String value) {
    evaluateJavascript(String.format("window.scrollBy(0,%s)", value), "");
  }

  // trim a String variable with IDR format to integer
  public Integer rupiahToInteger(String amount) {
    return Integer.parseInt(
        amount.replace("(", "").replace("Rp", "").replace(".", "").replace(")", "")
            .replace("\u00A0", "").trim());
  }

  public Boolean waitUntilPageIsLoaded() {
    WebDriverWait wait = driverWait(By.tagName("body"));
    return evaluateJavascript("return document.readyState", "").equals("complete");
  }
}
