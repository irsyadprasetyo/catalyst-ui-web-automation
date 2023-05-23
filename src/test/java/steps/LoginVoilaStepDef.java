package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.regex.Matcher;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import pages.LoginPage;
import pages.VisitPage;
import properties.ConfigLoader;
import webdriverpool.WebdriverInitializer;

public class LoginVoilaStepDef {

  VisitPage visit = new VisitPage(WebdriverInitializer.driver);

  LoginPage loginPage = new LoginPage();


  @Given("User logged into {string}")
  public void userLoggedInOn(String site) throws FileNotFoundException {
    Map<String, Object> properties = ConfigLoader.loadProperties();
    visit.openPage("https://" + site + properties.get("loginPath"));

    loginPage.inputEmail((String) properties.get("email"));
    loginPage.inputPassword((String) properties.get("password"));
    loginPage.clickLogin();
  }

  @And("User verify is already logged in")
  public void userVerifyIsAlreadyLoggedIn() {
    Assert.assertTrue("user not logged in!",
        loginPage.isAlreadyLandedOnLoginPage());
  }
}
