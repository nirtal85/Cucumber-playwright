package di;

import com.microsoft.playwright.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import java.nio.file.Paths;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

/**
 * User: nirtal
 * Date: 27/07/2021
 * Time: 10:59
 * Created with IntelliJ IDEA
 */
@Configuration
public class CucumberConfig {
    @Autowired
    @Lazy
    private Playwright playwright;
    @Autowired
    @Lazy
    private Browser browser;
    @Autowired
    @Lazy
    private BrowserContext browserContext;

    @Bean(destroyMethod = "close")
    public Playwright getPlaywright() {
        return Playwright.create();
    }

    @Bean(destroyMethod = "close")
    public Browser getBrowser() {
        return playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false));
    }

    @Bean(destroyMethod = "close")
    public BrowserContext getBrowserContext() {
        return browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1920, 1080)
                .setRecordVideoDir(Paths.get("video"))
                .setBaseURL("https://the-internet.herokuapp.com")
                .setHttpCredentials("admin", "admin"));
    }

    @Bean(destroyMethod = "close")
    @Scope(value = SCOPE_CUCUMBER_GLUE)
    public Page getPage() {
        return browserContext.newPage();
    }
}
