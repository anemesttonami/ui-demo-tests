package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Getter
public class HomePage {

    private final SelenideElement
            RSTQB_IMG = $("img[src='assets/images/9/rstqb_w_full-fbe358ed.png']"),
            REGISTRATION_FORM = $(".filter-body"),
            SEARCH_BUTTON = $(withText("Поиск"));

    @Step("Открываем главную страницу")
    public HomePage openHomePage() {
        open("");
        return this;
    }

    @Step("Проверяем, что RSTQB логотип виден.")
    public HomePage isRstqbImageVisible() {
        RSTQB_IMG.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проматываем до модуля с поиском экзаменов и проверяем, что он виден.")
    public HomePage registrationFormIsVisible() {
        REGISTRATION_FORM.scrollTo().shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажимаем на поиск в модуле регистрации на экзамен.")
    public ExamSchedulePage clickRegSearchButton() {
         SEARCH_BUTTON.shouldBe(Condition.visible).click();
        return new ExamSchedulePage();
    }
}