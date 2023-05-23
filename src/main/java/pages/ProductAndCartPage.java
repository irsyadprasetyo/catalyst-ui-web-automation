package pages;

import static locator.ProductPageLocator.ALAMAT_INPUT_FIELD;
import static locator.ProductPageLocator.CHECKOUT_BUTTON;
import static locator.ProductPageLocator.JUMLAH_CART_LABEL;
import static locator.ProductPageLocator.KERANJANG_BUTTON;
import static locator.ProductPageLocator.LANJUTKAN_BELANJA_BUTTON;
import static locator.ProductPageLocator.LIHAT_KERANJANG_BUTTON;
import static locator.ProductPageLocator.PRICE_LABEL;
import static locator.ProductPageLocator.PRODUCT_NAME_LABEL;
import static locator.ProductPageLocator.QUANTITY_LABEL;
import webdriverpool.WebdriverInitializer;

public class ProductAndCartPage {

  BasePageObject page = new BasePageObject(WebdriverInitializer.driver);

  public void clickKeranjangButton() {page.clickOn(KERANJANG_BUTTON);}

  public void clickCheckoutButton() {page.clickOn(CHECKOUT_BUTTON);}

  public Integer getQuantityCartPage() {
    return Integer.valueOf(page.find(QUANTITY_LABEL).getAttribute("value"));
  }

  public void clickModalPopUpButton(String option) {
    if (option.equalsIgnoreCase("lihat keranjang")) {
      page.clickOn(LIHAT_KERANJANG_BUTTON);
    } else {
      page.clickOn(LANJUTKAN_BELANJA_BUTTON);
    }
  }

  public void handleClosePopUpSale() {
    page.finds().navigate().refresh();
  }

  public Integer getProductPrice() {
    return Integer.valueOf(page.getText(PRICE_LABEL).replace("IDR ", "").replace(".", ""));
  }

  public String getProuctName() {return page.getText(PRODUCT_NAME_LABEL);}

  public Boolean titleEqString(String text) throws InterruptedException {
    page.waitUntilPageIsLoaded();
    return page.finds().getTitle().contains(text);
  }

  public void inputAlamat(String text) {
    page.find(ALAMAT_INPUT_FIELD).clear();
    page.inputText(ALAMAT_INPUT_FIELD, text);
  }

  public Integer getJumlahCart() {
    String price = page.getText(JUMLAH_CART_LABEL).replace(",00", "").replace(".", "")
        .replace("Rp", "");
    return Integer.valueOf(price);
  }

  public Boolean informasiPageHasText(String text) {
    return page.expectPageHasText(text);
  }
}
