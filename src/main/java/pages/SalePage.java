package pages;

import static locator.SalePageLocators.*;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webdriverpool.WebdriverInitializer;

public class SalePage {

  BasePageObject page = new BasePageObject(WebdriverInitializer.driver);

  public void chooseFilterSort(String filterName) {
    page.findAll(FILTER_DROPDOWN_BUTTON).get(1).click();
    page.findAll(By.xpath(String.format(FILTER_PICKER, filterName))).get(1).click();
  }

  public void clickFilterCategory(String catName) {
    By xpath = By.xpath(String.format(CATEGORY_FILTER_CHECKBOX, catName));
    page.clickOn(xpath);
    // make sure checkbox is already checked
    page.driverWait(xpath)
        .until(ExpectedConditions.attributeContains(xpath, "aria-checked", "true"));
  }

  public void clickFilterProductType(String type) {
    By xpath = By.xpath(String.format(PRODUCT_TYPE_FILTER_CHECKBOX, type));
    page.clickOn(xpath);
    // make sure checkbox is already checked
    page.driverWait(xpath)
        .until(ExpectedConditions.attributeContains(xpath, "aria-checked", "true"));
  }

  public void clickItemName(String itemName) {
    page.clickOn(By.xpath(String.format(ITEM_NAME_LABEL, itemName)));
  }

  public void clickItemProductOnNumber(Integer number) {
    Integer num = 1;
    if (number > getLengthItemInAPage() || number < 1) {
      number = num;
    } else {
      num = number;
    }
    page.clickOn(By.cssSelector(String.format(ITEM_LIST_NUMBER, number)));
  }

  public void inputMaxPrice(String price) {
    int x = 0;
    int length = page.find(TOTAL_LENGTH_MAX_VALUE_PRICE)
        .getAttribute("aria-valuemax").length() + 1;
    while (x < length) {
      page.find(MAX_RANGE_PRICE_INPUT).sendKeys(Keys.BACK_SPACE);
      x += 1;
    };
    page.inputText(MAX_RANGE_PRICE_INPUT, price);
    page.find(MAX_RANGE_PRICE_INPUT).sendKeys(Keys.ENTER);
  }

  private Integer getLengthItemInAPage() {
    return page.findAll(GET_TOTAL_ITEMS_IN_PAGE).size();
  }
}
