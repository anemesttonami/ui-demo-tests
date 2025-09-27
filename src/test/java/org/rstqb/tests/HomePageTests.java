package org.rstqb.tests;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;
import org.rstqb.pages.HomePage;
import org.rstqb.pages.component.CalendarComponent;

@Epic("Главная страница RSTQB")
public class HomePageTests extends BaseTest {

    private final HomePage homePage = new HomePage();

    private final ExamSchedulePage examSchedulePage = new ExamSchedulePage();

    @Tag("smoke")
    @Test
    @DisplayName("Главная страница открывается и логотип виден.")
    public void openHomePageAndCheckImgExists() {
        homePage.openHomePage().isRstqbImageVisible();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Форма регистрации видна.")
    public void regFormVisible() {
        homePage.openHomePage().registrationFormIsVisible();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Кнопка \"Поиск\" перебрасывает на старницу расписания экзаменов.")
    public void canOpenExamSchedulePage() {
        homePage
                .openHomePage()
                .clickRegSearchButton();

        examSchedulePage
                .examScheduleTitleVisible();
    }

    @Tag("regress")
    @Test
    @DisplayName("Поиск по дате работает.")
    public void searchByDate() {
        CalendarComponent component = new CalendarComponent();

        homePage.openHomePage();
        component.setDateFrom(2026, 1, 2);
        component.setDateTo(2026, 6, 18);
        homePage.clickRegSearchButton();

        examSchedulePage.checkDateInfo(component.getSTART_DATE(), 3);
        examSchedulePage.checkDateInfo(component.getEND_DATE(), 4);
    }
}