package pages;

import static locator.LoginPageLocators.*;
import webdriverpool.WebdriverInitializer;

public class LoginPage {

  BasePageObject page = new BasePageObject(WebdriverInitializer.driver);

  public void inputEmail(String email) {
    page.inputText(EMAIL_FORM_INPUT, email);
  }

  public void inputPassword(String password) {
    page.inputText(PASSWORD_FORM_INPUT, password);
  }

  public void clickLogin() { page.clickOn(LOGIN_BUTTON); }

  public void fillOutAllLoginForms(String email, String password) {
    inputEmail(email);
    inputPassword(password);
    clickLogin();
  }

  public Boolean isAlreadyLandedOnLoginPage() {
    return page.expectPageHasText("MY ACCOUNT");
  }
}
