package locator;

import org.openqa.selenium.By;

public interface LoginPageLocators {

  By EMAIL_FORM_INPUT = By.id("loginInputName");
  By PASSWORD_FORM_INPUT = By.id("loginInputEmail");
  By LOGIN_BUTTON = By.xpath("//*[@class='form-group']/button[text()='LOGIN']");
  By LOGIN_LABEL = By.xpath("//*[@class='tt-item']/div/h2[text()='LOGIN']");
}
