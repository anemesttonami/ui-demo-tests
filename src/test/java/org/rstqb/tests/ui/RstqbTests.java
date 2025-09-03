package org.rstqb.tests.ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;
import org.rstqb.pages.HomePage;

public class RstqbTests extends BaseTest {

    @Tag("smoke")
    @Test
    @Description("Главная страница открывается и логотип виден.")
    public void openHomePageAndCheckImgExists() {
        new HomePage().openHomePage().isRstqbImageVisible();
    }

    @Tag("regress")
    @Test
    @Description("Форма регистрации видна.")
    public void regFormVisible() {
        new HomePage().openHomePage().registrationFormIsVisible();
    }

    @Tag("regress")
    @Test
    @Description("Кнопка поиск перебрасывает на старницу расписания экзаменов.")
    public void canOpenExamSchedulePage() {
        new HomePage()
                .openHomePage()
                .clickRegSearchButton();

        new ExamSchedulePage()
                .examScheduleTitleVisible();
    }
}