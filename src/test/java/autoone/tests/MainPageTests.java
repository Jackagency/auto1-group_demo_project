package autoone.tests;

import autoone.helpers.DriverUtils;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @Description("Job searching tests")
    @DisplayName("Search for QA positions")
    void searchForQa() {
        step("Open https://www.auto1-group.com/", () -> {
           open("https://www.auto1-group.com/");
        });

        step("Open Jobs page", () -> {
            $("#navbarNav li", 4).click();
        });

        step("Set 'QA' in the search field", () -> {
            $(".form-control").setValue("QA").pressEnter();
        });

        step("Check results", () -> {
            $("#jobs-list div div:nth-child(1) a").shouldHave(Condition.text("QA"));
        });
    }

    @Test
    @Description("Job searching tests")
    @DisplayName("Search for Java developer positions")
    void searchForJava() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Jobs page", () -> {
            $("#navbarNav li", 4).click();
        });

        step("Set 'Java' in the search field", () -> {
            $(".form-control").setValue("Java").pressEnter();
        });

        step("Check results", () -> {
            $("#jobs-list div div:nth-child(1) a").shouldHave(Condition.text("Java"));
        });
    }

    @Test
    @Description("Job searching tests")
    @DisplayName("Search for DevOps positions")
    void searchForDevOps() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Jobs page", () -> {
            $("#navbarNav li", 4).click();
        });

        step("Set 'DevOps' in the search field", () -> {
            $(".form-control").setValue("DevOps").pressEnter();
        });

        step("Check results", () -> {
            $("#jobs-list div div:nth-child(1) a").shouldHave(Condition.text("DevOps"));
        });
    }

    @Test
    @Description("Titles checks")
    @DisplayName("Home page title check")
    void homePageTitleCheck() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Home page", () -> {
            $("#navbarNav li", 0).click();
        });

        step("Check the Title", () -> {
            $("section.video div .plyr-overlay h2").shouldHave(Condition.text("Our Mission is to build the best way to buy and sell cars online"));
        });
    }

    @Test
    @Description("Titles checks")
    @DisplayName("Company page title check")
    void companyPageTitle() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Company page", () -> {
            $("#navbarNav li", 1).click();
        });

        step("Check the Title", () -> {
            $("div div:nth-child(1) h1 span").shouldHave(Condition.text("With entrepreneurial passion, we build the best way to buy and sell cars online"));
        });
    }

    @Test
    @Description("Titles checks")
    @DisplayName("Team page title check")
    void teamPageTitle() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Team page", () -> {
            $("#navbarNav li", 3).click();
        });

        step("Check the Title", () -> {
            $("div div:nth-child(1) h1 span").shouldHave(Condition.text("Working at AUTO1 Group"));
        });
    }

    @Test
    @Description("Language change")
    @DisplayName("German language")
    void germanLanguage() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Language dropdown", () -> {
            $("#navbarNav li.nav-item.nav-languages.dropdown > a").click();
        });

        step("Set Deutsch ", () -> {
            $(byText("Deutsch")).click();
        });

        step("Check if the language changed", () -> {
            $("section.headline-text-image div > h2").shouldHave(Condition.text("Was wir tun"));
        });
    }

    @Test
    @Description("Language change")
    @DisplayName("Portuguese language")
    void portugalLanguage() {
        step("Open https://www.auto1-group.com/", () -> {
            open("https://www.auto1-group.com/");
        });

        step("Open Language dropdown", () -> {
            $("#navbarNav li.nav-item.nav-languages.dropdown > a").click();
        });

        step("Set  Português", () -> {
            $(byText("Português")).click();
        });

        step("Check if the language changed", () -> {
            $("section.headline-text-image div > h2").shouldHave(Condition.text("O que fazemos"));
        });
    }

    @Test
    @Description("Page title test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.auto1-group.com/'", () ->
            open("https://www.auto1-group.com/"));

        step("Page title should have text 'AUTO1 Group - Europe's leading digital automotive platform'", () -> {
            String expectedTitle = "AUTO1 Group - Europe's leading digital automotive platform";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Page console test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.auto1-group.com/'", () ->
            open("https://www.auto1-group.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}