package steps;

import io.cucumber.java.en.And;
import pages.MenuBarPage;

public class MenuBarStepDef {

  MenuBarPage menuPage = new MenuBarPage();

  @And("User go to sub-menu {string}")
  public void userGoToSubMenu(String subMenu) {
    menuPage.clickSubMenu(subMenu);
  }
}
