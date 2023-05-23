package locator;

import org.openqa.selenium.By;

public interface ProductPageLocator {

  By KERANJANG_BUTTON = By.xpath("//button/span[text()='+ Keranjang']");
  By PRICE_LABEL = By.xpath("//span[@class='sale-price']");
  By PRODUCT_NAME_LABEL = By.cssSelector("div > h1.tt-title.no-translate");
  By CATEGORY_LABEL = By.xpath("");
  By CLOSE_POPUP_BUTTON = By.xpath("//*[@class='modal-dialog']"
      + "/div/div/button[@type='button']");
  By LIHAT_KERANJANG_BUTTON = By.xpath("//div[1]/a[@href='/cart']");
  By LANJUTKAN_BELANJA_BUTTON = By.xpath("//div[1]/a[text()='Lanjutkan Belanja']");
  By ALAMAT_INPUT_FIELD = By.xpath("//*[@id='TextField3']/../input");
  By JUMLAH_CART_LABEL = By.xpath("//*[@role='cell']/span[text()='Jumlah']/../../div[2]/div/div/strong");
  By CHECKOUT_BUTTON = By.xpath("//*[@type='submit' and contains(text(), 'CHECKOUT')]");
  By QUANTITY_LABEL = By.xpath("//*[@class='detach-quantity-desctope']/div/input[1]");
  By CLOSE_BUTTON_POPUP = By.xpath("//*[@aria-label='close']/span");
}
