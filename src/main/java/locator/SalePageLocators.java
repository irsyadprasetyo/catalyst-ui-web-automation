package locator;

import org.openqa.selenium.By;

public interface SalePageLocators {

  // static locator
  By FILTER_DROPDOWN_BUTTON = By.xpath("//button[@aria-label='Sort by']");
  By MODAL_CONTENT_BOX = By.xpath("////*[@class='customModalBg'][1]");
  By MODAL_CLOSE_BUTTON = By.xpath("//*[@id='modal-title1']/div/button/span");
  By MAX_RANGE_PRICE_INPUT = By.xpath("//div/input[@aria-label='Max value']");
  By GET_TOTAL_ITEMS_IN_PAGE = By.cssSelector("div.boost-pfs-filter-products > div > div");
  By TOTAL_LENGTH_MAX_VALUE_PRICE =  By.xpath("//*[@class='noUi-handle noUi-handle-upper']");

  // dynamic locator
  String CATEGORY_FILTER_CHECKBOX = "//*[@role='checkbox']/span[contains(text(), '%s')]/..";
  String PRODUCT_TYPE_FILTER_CHECKBOX = "//*[@role='checkbox']/span[contains(text(), '%s')]/..";
  String ITEM_NAME_LABEL = "//*[@class='boost-pfs-filter-product-bottom-inner']"
      + "/a[contains(text(), '%s')]";
  String FILTER_PICKER = "//li[@aria-label='%s']/a";
  String ITEM_LIST_NUMBER = "div.boost-pfs-filter-products > div:nth-child(%d) > div "
      + "> div:nth-child(2) > div > a:nth-child(2)";
}
