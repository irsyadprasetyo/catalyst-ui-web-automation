package locator;

import org.openqa.selenium.By;

public interface MenuBarLocators {

  By CART_BUTTON = By.xpath("//*[@data-tooltip='Keranjang']");
  By BELI_BUTTON = By.xpath("//div[1]/a[@href='/checkout']");

  String SUB_MENU_LIST = "//*[@class='tt-desctop-menu']"
      + "/nav/ul/li/a/span[contains(text(), '%s')]";
}
