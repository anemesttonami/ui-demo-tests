package org.rstqb.tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.rstqb.pages.ExamSchedulePage;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

@Epic("Страница \"Расписание экзаменов\".")
public class ExamSchedulePageTests extends BaseTest {

    @BeforeEach
    void openPage() {
        new ExamSchedulePage().openExamSchedulePage();
    }

    @Tag("smoke")
    @DisplayName("Фильтр и его поля видны.")
    @Test
    void checkFilterExistence() {
        new ExamSchedulePage().checkFilterAndHisElements();
    }

    @Tag("smoke")
    @DisplayName("Кнопка перехода на следующую страницу работает и информация о номере текущей страницы коректна.")
    @Test
    void paginationIsWork() {
        step("Проверяем, что страница открывается именно с первой старницы", () ->
                new ExamSchedulePage().getPAGINATION().shouldHave(Condition.exactText("1")));
        IntStream.range(1, 2).forEach(i -> new ExamSchedulePage().checkNumberOfPage(i).goToNextPage());
    }


    @Tag("regress")
    @DisplayName("Поиск по фильтрам город и уровнь.")
    @MethodSource
    @ParameterizedTest(name = "Поиск по городу {0} и уровню {1}.")
    void cityAndLevelFilterSearch(String cityRu, String level, String cityEn) {
        ExamSchedulePage schedulePage = new ExamSchedulePage();

        schedulePage.getCITY_FILTER().click();
        schedulePage.getCITY_FILTER().$(Selectors.withText(cityRu)).click();
        schedulePage.getLEVEL_FILTER().$(Selectors.withText(level)).click();
        schedulePage.getFILTER_SEARCH_BUTTON().click();

        schedulePage.getCITY_IN_SEARCH_RESULT().shouldHave(Condition.text(cityEn));
        schedulePage.checkNumberOfSearchResults();
    }


    private static Stream<Arguments> cityAndLevelFilterSearch() {
        ExamSchedulePage schedulePage = new ExamSchedulePage();
        return Stream.of(
                Arguments.of(
                        schedulePage.getMOSCOW_RU(),
                        schedulePage.getCERTIFIED_TESTER_FOUNDATION_LEVEL(),
                        schedulePage.getMOSCOW_EN()),

                Arguments.of(
                        schedulePage.getKAZAN_RU(),
                        schedulePage.getCERTIFIED_TESTER_AI_TESTING(),
                        schedulePage.getKAZAN_EN()));
    }
}
