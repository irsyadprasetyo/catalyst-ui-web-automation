package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisitPage {

  ChromeDriver driver;


  private static WebElement element;

  public VisitPage(ChromeDriver driver) {
    this.driver = driver;
  }

  public void openPage(String url) {
    driver.get(url);
  }

  public void getTitle() {
    driver.getTitle();
  }
}
