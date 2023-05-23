package pages;

import static locator.MenuBarLocators.*;
import org.openqa.selenium.By;
import webdriverpool.WebdriverInitializer;

public class MenuBarPage {

  BasePageObject page = new BasePageObject(WebdriverInitializer.driver);

  public void clickSubMenu(String subMenu) {
    page.clickOn(By.xpath(String.format(SUB_MENU_LIST, subMenu)));
  }

  public void clickCart() {
    page.clickOn(CART_BUTTON);
  }

  public void clickButtonBeli() {
    page.clickOn(BELI_BUTTON);
  }
}
