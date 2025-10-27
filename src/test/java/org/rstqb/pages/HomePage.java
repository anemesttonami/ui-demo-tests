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
            rstqbImg = $("img[src='files/content/rstqb/images/1920%D1%851080-2.png']"),
            registrationForm = $(".filter-body"),
            searchButton = $(withText("Поиск"));

    @Step("Открываем главную страницу")
    public HomePage openHomePage() {
        open("");
        return this;
    }

    @Step("Проверяем, что RSTQB логотип виден.")
    public HomePage isRstqbImageVisible() {
        rstqbImg.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проматываем до модуля с поиском экзаменов и проверяем, что он виден.")
    public HomePage registrationFormIsVisible() {
        registrationForm.scrollTo().shouldBe(Condition.visible);
        return this;
    }

    @Step("Нажимаем на поиск в модуле регистрации на экзамен.")
    public ExamSchedulePage clickRegSearchButton() {
         searchButton.shouldBe(Condition.visible).click();
        return new ExamSchedulePage();
    }
}