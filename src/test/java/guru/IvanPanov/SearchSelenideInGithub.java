package guru.IvanPanov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchSelenideInGithub {
    @Test
    void findSelenideRepossitoryInGithub(){
        //Открыть сраницу github
        open("https://github.com");
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        $("ul.repo-list li").$("a").click();
        $("h1").shouldHave(text("selenide\n" +
                "/\n" +
                "selenide"));
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5 extension"));
    }
}
