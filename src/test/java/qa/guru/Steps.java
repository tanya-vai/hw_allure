package qa.guru;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class Steps {

    @Step("Open github")
    public Steps openMainPage(){
        open("");
        return this;
    }

    @Step("Find repository {repo}")
    public Steps findRepository(String repo){
        $(".header-search-input").setValue(repo).submit();
        return this;
    }

    @Step("Click on {repo}")
    public Steps clickOnRepo(String repo){
        $(linkText(repo)).click();
        return this;
    }

    @Step("Click on Issues tab")
    public Steps clickOnIssuesTab(){
        $("#issues-tab").click();
        return this;
    }

    @Step("Check the existence of {issue} issue")
    public Steps checkExistenceOfIssue(int issue){
        $(withText("#"+ issue)).should(Condition.exist);
        return this;
    }

}
