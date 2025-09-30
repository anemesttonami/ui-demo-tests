package org.rstqb.tests;

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

    private final ExamSchedulePage PAGE = new ExamSchedulePage();

    @BeforeEach
    void openPage() {
        PAGE.openExamSchedulePage();
    }

    @Tag("smoke")
    @DisplayName("Фильтр и его поля видны.")
    @Test
    void checkFilterExistence() {
        PAGE.checkFilterAndHisElements();
    }

    @Tag("smoke")
    @DisplayName("Кнопка перехода на следующую страницу работает и информация о номере текущей страницы корректна.")
    @Test
    void paginationIsWork() {
        step("Проверяем, что \"Расписание экзаменов\" открывается именно с первой старницы.", () ->
                PAGE.getPAGINATION().shouldHave(Condition.exactText("1")));
        IntStream.range(1, 2).forEach(i -> PAGE.checkNumberOfPage(i).goToNextPage());
    }

    @Tag("regress")
    @DisplayName("Поиск по комбинации фильтров \"город\" и \"уровень\" возможен.")
    @MethodSource
    @ParameterizedTest(name = "Поиск по городу {0} и уровню {1}.")
    void cityAndLevelFilterSearch(String cityRu, String level, String cityEn) {
        PAGE.getCITY_FILTER().click();
        PAGE.getCITY_FILTER().$(Selectors.withText(cityRu)).click();
        PAGE.getLEVEL_FILTER().$(Selectors.withText(level)).click();
        PAGE.getFILTER_SEARCH_BUTTON().click();

        PAGE.getCITY_IN_SEARCH_RESULT().shouldHave(Condition.text(cityEn));
        PAGE.checkNumberOfSearchResults();
    }

    private static Stream<Arguments> cityAndLevelFilterSearch() {

        ExamSchedulePage page = new ExamSchedulePage();

        return Stream.of(
                Arguments.of(
                        page.getMOSCOW_RU(),
                        page.getCERTIFIED_TESTER_FOUNDATION_LEVEL(),
                        page.getMOSCOW_EN()),

                Arguments.of(
                        page.getKAZAN_RU(),
                        page.getCERTIFIED_TESTER_AI_TESTING(),
                        page.getKAZAN_EN()));
    }
}
