package org.rstqb.tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;

@Epic("Страница \"Расписание экзаменов\"")
public class ExamSchedulePageTests extends BaseTest {

    @Tag("smoke")
    @Description("Фильтр и его поля видны.")
    @Test
    void checkFilterExistence() {
        new ExamSchedulePage().openExamSchedulePage().checkFilterAndHisElements();
    }
}
