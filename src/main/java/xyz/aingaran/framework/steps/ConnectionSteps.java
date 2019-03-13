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

    @When("user navigates to http:\\/\\/34.220.2.144:3000\\/")
    public void user_navigates_to_google_com() {
        Framework.getWebDriver().navigate().to("http:\\/\\/34.220.2.144:3000\\/");
    }

    @Then("user sees element image1")
    public void user_sees_element_hplogo() {
        Framework.getWebDriver().findElement(By.id("image1"));
    }
    
    @Then("user sees element link1")
    public void user_sees_element_link1() {
        Framework.getWebDriver().findElement(By.id("link1"));
    }  
    
    @Then("user sees element link3")
    public void user_sees_element_link3() {
        Framework.getWebDriver().findElement(By.id("link3"));
    } 
    
    @Then("user takes a screenshot")
    public void user_takes_a_screenshot() {
        Framework.takeScreenShot("pwa", "page1");
    }    
    
}
