package org.rstqb.tests;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;
import org.rstqb.pages.HomePage;
import org.rstqb.pages.component.CalendarComponent;

@Epic("Главная страница RSTQB.")
public class HomePageTests extends BaseTest {

    private final HomePage HOME_PAGE = new HomePage();

    private final ExamSchedulePage EXAM_SCHEDULE_PAGE = new ExamSchedulePage();

    @Tag("smoke")
    @Test
    @DisplayName("Логотип виден.")
    public void openHomePageAndCheckImgExists() {
        HOME_PAGE.openHomePage().isRstqbImageVisible();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Форма регистрации видна.")
    public void regFormVisible() {
        HOME_PAGE.openHomePage().registrationFormIsVisible();
    }

    @Tag("smoke")
    @Test
    @DisplayName("Кнопка \"Поиск\" перебрасывает на страницу \"Расписание экзаменов\".")
    public void canOpenExamSchedulePage() {
        HOME_PAGE
                .openHomePage()
                .clickRegSearchButton();

        EXAM_SCHEDULE_PAGE
                .examScheduleTitleVisible();
    }

    @Tag("regress")
    @Test
    @DisplayName("Поиск по дате работает.")
    public void searchByDate() {
        CalendarComponent component = new CalendarComponent();

        HOME_PAGE.openHomePage();
        component.setDateFrom(2026, 1, 2);
        component.setDateTo(2026, 6, 18);
        HOME_PAGE.clickRegSearchButton();

        EXAM_SCHEDULE_PAGE.checkDateInfo(component.getSTART_DATE(), 3);
        EXAM_SCHEDULE_PAGE.checkDateInfo(component.getEND_DATE(), 4);
    }
}