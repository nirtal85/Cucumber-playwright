package steps;

import com.microsoft.playwright.Page;
import di.CucumberConfig;
import di.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.testng.Assert;

/**
 * User: nirtal
 * Date: 27/07/2021
 * Time: 10:52
 * Created with IntelliJ IDEA
 */
@SpringBootTest(classes = {CucumberConfig.class, Hooks.class, ScenarioContext.class})
@EnableAspectJAutoProxy
@CucumberContextConfiguration
public class MyStepdefs {
    @Autowired
    private Page page;

    @And("I click on {string}")
    public void iEnterToAdasdField(String elementText) {
        page.click("text=%s".formatted(elementText));
    }

    @And("I click on {string} {int} times")
    public void iClickOnSeveralTimes(String elementText, int times) {
        for (int i = 0; i < times; i++) {
            page.click("text=%s".formatted(elementText));
        }
    }

    @And("{int} elements are visible")
    public void elementsAreVisible(int elements) {
        Assert.assertEquals(page.querySelectorAll("button.added-manually").size(), elements);
    }

    @Then("I will be logged In")
    public void iWillBeLoggedIn() {
    }

    @Given("I navigate to {string}")
    public void iNavigateTo(String navigationPath) {
        page.navigate(navigationPath);
    }
}
