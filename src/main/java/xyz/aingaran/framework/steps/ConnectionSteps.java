package xyz.aingaran.framework.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import xyz.aingaran.framework.core.Framework;

public class ConnectionSteps {

    @Given("user loads browser")
    public void user_loads_browser() {
        Framework.init();
    }

    @When("user navigates to http:\\/\\/34.221.37.187:3000\\/")
    public void user_navigates_to_google_com() {
        Framework.getWebDriver().navigate().to("http:\\/\\/34.221.37.187:3000\\/");
    }

    @Then("user sees element image1")
    public void user_sees_element_hplogo() {
        Framework.getWebDriver().findElement(By.id("image1"));
    }

    @Then("user takes a screenshot")
    public void user_takes_a_screenshot() {
        Framework.takeScreenShot("pwa", "page1");
    }
    
    @Given("user loads browser")
    public void user_loads_browser1() {
        Framework.init();
    }

    @When("user navigates to http:\\/\\/34.221.37.187:3000\\/")
    public void user_navigates_to_pwa() {
        Framework.getWebDriver().navigate().to("http:\\/\\/34.221.37.187:3000\\/");
    }

    @Then("user sees element link1")
    public void user_sees_element_pwalink() {
        Framework.getWebDriver().findElement(By.id("link1"));
    }

    @Then("user takes a screenshot")
    public void user_takes_a_screenshot1() {
        Framework.takeScreenShot("pwa1", "page2");
    }
    
  /*  @Given("user loads browser")
    public void user_loads_browser() {
        Framework.init();
    }
    
     @When("navigates to http://34.221.37.187:3000/")
    public void user_navigates_to_google_com() {
        Framework.getWebDriver().navigate().to("http://34.221.37.187:3000/");
    }

    @Then("user sees element link1")
    public void user_sees_element_hplogo() {
        Framework.getWebDriver().findElement(By.id("link1"));
    }

    @Then("user takes a screenshot")
    public void user_takes_a_screenshot() {
        Framework.takeScreenShot("pwa", "page2");
    }
    
    @Given("user loads browser")
    public void user_loads_browser() {
        Framework.init();
    }
    
     @When("navigates to http://34.221.37.187:3000/")
    public void user_navigates_to_google_com() {
        Framework.getWebDriver().navigate().to("http://34.221.37.187:3000/");
    }

    @Then("user sees element link2")
    public void user_sees_element_hplogo() {
        Framework.getWebDriver().findElement(By.id("link2"));
    }

    @Then("user takes a screenshot")
    public void user_takes_a_screenshot() {
        Framework.takeScreenShot("pwa", "page3");
    }*/
}
