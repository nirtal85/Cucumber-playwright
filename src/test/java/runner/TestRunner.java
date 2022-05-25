package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        plugin = "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        tags = "not @Ignore",
        glue = "steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}