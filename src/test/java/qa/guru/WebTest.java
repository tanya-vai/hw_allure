package qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class WebTest {

    private static final String REPOSITORY = "qa-guru/qa_guru_14_10";
    private static final int ISSUE = 2;

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com/";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("tanya-vai")
    @Test
    void listenerTest() {
        open("");
        $(".header-search-input").setValue(REPOSITORY).submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#2")).should(Condition.exist);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("tanya-vai")
    @Test
    void lambdaTest() {
        step("Open github", () -> {
            open("");
        });

        step("Find repository" + REPOSITORY, () -> {
            $(".header-search-input").setValue(REPOSITORY).submit();
        });

        step("Click on repo" + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Click on Issues tab", () -> {
            $("#issues-tab").click();
        });

        step("Check the existence of an issue", () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }
    @Severity(SeverityLevel.CRITICAL)
    @Owner("tanya-vai")
    @Test
    void stepAnnotaionTest() {

        Steps steps = new Steps();

        steps
                .openMainPage()
                .findRepository(REPOSITORY)
                .clickOnRepo(REPOSITORY)
                .clickOnIssuesTab()
                .checkExistenceOfIssue(ISSUE);
    }
}
