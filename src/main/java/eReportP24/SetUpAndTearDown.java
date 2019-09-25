package eReportP24;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import eReportP24.pages.LoginPage;
import eReportP24.utils.ConfigurationVariables;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class SetUpAndTearDown {
    private static final Logger LOGGER = Logger.getLogger(SetUpAndTearDown.class);
    private final ConfigurationVariables CV = ConfigurationVariables.getInstance();
    private final String browser = CV.currentBrowser;
    private final String locale = CV.locale;
    private LoginPage loginPage;

    @BeforeSuite(alwaysRun = true)
    public void SetUpBrowser() {

        switch (locale) {
            case "UA":
                Locale.setDefault(new Locale("uk", "ua"));
                LOGGER.info("Set locale to uk-UA");
                break;
            case "RU":
                Locale.setDefault(new Locale("ru", "ua"));
                LOGGER.info("Set locale to ru-UA");
                break;
            case "EN":
                Locale.setDefault(new Locale("en", "ua"));
                LOGGER.info("Set locale to en-UA");
                break;
            default:
                Locale.setDefault(new Locale("uk", "ua"));
                LOGGER.info("Locale is uk-UA");
        }

        switch (browser) {
            case "firefox":
                Configuration.browser = "eReportP24.webDriverProviders.FirefoxDriverProvider";
                break;
            case "chrome":
                Configuration.browser = "eReportP24.webDriverProviders.ChromeDriverProvider";
                break;
            default:
                Configuration.browser = "eReportP24.webDriverProviders.ChromeDriverProvider";
                break;
        }
        Configuration.startMaximized = true;
        Configuration.timeout = Long.parseLong(CV.timeout);
    }

    @BeforeSuite(alwaysRun = true)
    void deleteOldDirs() throws IOException {
        File buildReportsDir = new File("build/reports");
        if (buildReportsDir.exists())
            FileUtils.deleteDirectory(buildReportsDir);
    }

    @BeforeMethod(alwaysRun = true)
    void login() {
        loginPage = new LoginPage();
        loginPage.login();
    }

    @AfterSuite(alwaysRun = true)
    void closeBrowser() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            WebDriverRunner.closeWebDriver();
        }
    }

    @AfterTest(alwaysRun = false)
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}