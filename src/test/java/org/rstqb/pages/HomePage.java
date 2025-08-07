package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Getter
public class HomePage {

    private SelenideElement rstqbImg = $("img[src='assets/images/b/rstqb-logo-b0c54bad.png']");
    private SelenideElement registrationForm = $(".filter-body");
    private SelenideElement registrationSearchButton = $(withText("Поиск"));

    public HomePage openHomePage() {
        step("Открываем главную страницу.",
                () -> open(""));
        return this;
    }

    public HomePage isRstqbImageVisible() {
        step("Проверяем видимость изображения RSTQB в левом верхнем углу.",
                () -> rstqbImg.shouldBe(Condition.visible));
        return this;
    }

    public HomePage registrationFormIsVisible() {
        step("Проверяем видимость формы регистрации RSTQB в левом верхнем углу.",
                () -> registrationForm.scrollTo().shouldBe(Condition.visible));
        return this;
    }

    public ExamSchedulePage clickRegSearchButton() {
        step("Нажимаем на поиск в модуле регистрации на экзамен.",
                () -> registrationSearchButton.shouldBe(Condition.visible)).click();
        return new ExamSchedulePage();
    }
}
