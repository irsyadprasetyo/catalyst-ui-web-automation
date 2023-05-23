package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;
import pages.SalePage;

public class SaleStepDef {

  SalePage page = new SalePage();

  @And("User choose item with name {string} on sale page")
  public void userChooseItemWithNameOnSalePage(String itemName) {
    page.clickItemName(itemName);
  }

  @And("User choose product number {int} product on sale page")
  public void userChooseProductNumberProductOnSalePage(int number) {
    page.clickItemProductOnNumber(number);
  }

  @And("User find product on sale page by sort:")
  public void userFindProductOnSalePageBySort(DataTable dataTable) {
    List<Map<String, String>> data = dataTable.asMaps();
    data.forEach(dt -> {
      page.clickFilterCategory(dt.get("category"));
      page.clickFilterProductType(dt.get("productType"));
      page.chooseFilterSort(dt.get("filter"));
      page.inputMaxPrice(dt.get("maxPrice"));
    });
  }
}
