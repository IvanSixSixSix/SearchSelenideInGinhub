package gure.IvanPanov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchSelenideInGithub {
    @Test
    void FindSelenideRepossitoryInGithub(){
        //Открыть сраницу github
        open("https://github.com");
        //Ввести в поле Selenide нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //Нажать линк первого результата поиска
        $$("ul.repo-list li").first().$("a").click();//ul - "unordered list" ‒ «неупорядоченный список» (ul class = "repo-list"),
        // li - "list item" - элемент списка, "$$" - ищут массив элементов
        //sleep(5000);
         //Check: в заголовке встречается selenide/selenide
        $("h1").shouldHave(text("selenide\n" +
                "/\n" +
                "selenide"));
        $("[id=wiki-tab]").click();
        $(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("JUnit5 extension"));
    }
}
