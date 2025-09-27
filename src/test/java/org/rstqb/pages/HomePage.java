package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Getter
public class HomePage {

    private final SelenideElement
            RSTQB_IMG = $("img[src='assets/images/b/rstqb-logo-b0c54bad.png']"),
            REGISTRATION_FORM = $(".filter-body"),
            SEARCH_BUTTON = $(withText("Поиск"));

    public HomePage openHomePage() {
        step("Открываем главную страницу.",
                () -> open(""));
        return this;
    }

    public HomePage isRstqbImageVisible() {
        step("Проверяем видимость иконки RSTQB в левом верхнем углу.",
                () -> RSTQB_IMG.shouldBe(Condition.visible));
        return this;
    }

    public HomePage registrationFormIsVisible() {
        step("Проверяем видимость формы регистрации RSTQB в левом верхнем углу.",
                () -> REGISTRATION_FORM.scrollTo().shouldBe(Condition.visible));
        return this;
    }

    public ExamSchedulePage clickRegSearchButton() {
        step("Нажимаем на поиск в модуле регистрации на экзамен.",
                () -> SEARCH_BUTTON.shouldBe(Condition.visible).click());
        return new ExamSchedulePage();
    }
}