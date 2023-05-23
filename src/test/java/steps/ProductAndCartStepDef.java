package steps;

import data.ProductData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import pages.ProductAndCartPage;

public class ProductAndCartStepDef {

  ProductData datas = new ProductData();

  ProductAndCartPage page = new ProductAndCartPage();

  @And("User click {string} button on popup product added")
  public void userClickButtonOnPopupProductAdded(String option) {
    try {
      page.clickModalPopUpButton(option);
    } catch (Exception e) {
      page.handleClosePopUpSale();
    }
  }

  @And("User click checkout button on cart page")
  public void userClickCheckoutButtonOnCartPage() {
    try {
      page.clickCheckoutButton();
    } catch (Exception e) {
      page.handleClosePopUpSale();
    }
  }

  @When("User click + keranjang button on product page")
  public void userClickKeranjangButtonOnProductPage() {
    datas.setProductPrice(page.getProductPrice());
    datas.setProductName(page.getProuctName());
    datas.setLimit(10000000);
    page.clickKeranjangButton();
  }

  @And("User input alamat field with {string} on informasi page")
  public void userInputAlamatFieldWithOnInformasiPage(String text) {
    page.inputAlamat(text);
  }

  @And("User verify data item price and product name is correct on informasi page")
  public void userVerifyDataItemPriceProductNameQuantityIsCorrectOnInformasiPage() {
    Assert.assertThat("item price isn't same!", page.getJumlahCart(),
        CoreMatchers.equalTo(datas.getProductPrice()));
    // item price must less than 10 mil
    Assert.assertTrue("item price > 10 mil!", page.getJumlahCart() < datas.getLimit());
    // item name on product page should be same like informasi page
    Assert.assertTrue("product name isn't correct!",
        page.informasiPageHasText(datas.getProductName()));
  }

  @And("User verify is already landed on {string} page")
  public void userVerifyIsAlreadyLandedOnInformasiPage(String text) throws InterruptedException {
    Assert.assertTrue("title isn't eq with text", page.titleEqString(text));
  }
}
