package org.rstqb.tests.ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;
import org.rstqb.pages.HomePage;
import org.rstqb.pages.component.CalendarComponent;

public class HomePageTests extends BaseTest {

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
    @Description("Кнопка \"Поиск\" успешно перебрасывает на старницу расписания экзаменов.")
    public void canOpenExamSchedulePage() {
        new HomePage()
                .openHomePage()
                .clickRegSearchButton();

        new ExamSchedulePage()
                .examScheduleTitleVisible();
    }

    @Tag("regress")
    @Test
    @Description("Поиск по дате.")
    public void searchByDate() {
        CalendarComponent component = new CalendarComponent();

        new HomePage().openHomePage();
        component.setDateFrom(2026,1,2);
        component.setDateTo(2026,6,18);
        new HomePage().clickRegSearchButton();
        new ExamSchedulePage().checkStartDate(component.getSTART_DATE());
    }

}