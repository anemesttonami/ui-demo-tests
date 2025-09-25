package org.rstqb.tests.ui;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;
import org.rstqb.pages.HomePage;
import org.rstqb.pages.component.CalendarComponent;

@Epic("Главная страница RSTQB")
public class HomePageTests extends BaseTest {

    @Tag("smoke")
    @Test
    @DisplayName("Главная страница открывается и логотип виден.")
    public void openHomePageAndCheckImgExists() {
        new HomePage().openHomePage().isRstqbImageVisible();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Форма регистрации видна.")
    public void regFormVisible() {
        new HomePage().openHomePage().registrationFormIsVisible();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Кнопка \"Поиск\" перебрасывает на старницу расписания экзаменов.")
    public void canOpenExamSchedulePage() {
        new HomePage()
                .openHomePage()
                .clickRegSearchButton();

        new ExamSchedulePage()
                .examScheduleTitleVisible();
    }

    @Tag("regress")
    @Test
    @DisplayName("Поиск по дате работает.")
    public void searchByDate() {
        CalendarComponent component = new CalendarComponent();

        new HomePage().openHomePage();
        component.setDateFrom(2026, 1, 2);
        component.setDateTo(2026, 6, 18);
        new HomePage().clickRegSearchButton();

        new ExamSchedulePage().checkDateInfo(component.getSTART_DATE(), 3);
        new ExamSchedulePage().checkDateInfo(component.getEND_DATE(), 4);
    }
}