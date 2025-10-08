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

    private final ExamSchedulePage page = new ExamSchedulePage();

    @BeforeEach
    void openPage() {
        page.openExamSchedulePage();
    }

    @Tag("smoke")
    @DisplayName("Фильтр и его поля видны.")
    @Test
    void checkFilterExistence() {
        page.checkFilterAndHisElements();
    }

    @Tag("smoke")
    @DisplayName("Кнопка перехода на следующую страницу работает и информация о номере текущей страницы корректна.")
    @Test
    void paginationIsWork() {
        step("Проверяем, что \"Расписание экзаменов\" открывается именно с первой старницы.", () ->
                page.getPagination().shouldHave(Condition.exactText("1")));
        IntStream.range(1, 2).forEach(i -> page.checkNumberOfPage(i).goToNextPage());
    }

    @Tag("regress")
    @DisplayName("Поиск по комбинации фильтров \"город\" и \"уровень\" возможен.")
    @MethodSource
    @ParameterizedTest(name = "Поиск по городу {0} и уровню {1}.")
    void cityAndLevelFilterSearch(String cityRu, String level, String cityEn) {
        page.getCityFilter().click();
        page.getCityFilter().$(Selectors.withText(cityRu)).click();
        page.getLevelFilter().$(Selectors.withText(level)).click();
        page.getFilterSearchButton().click();

        page.getCityInSearchResult().shouldHave(Condition.text(cityEn));
        page.checkNumberOfSearchResults();
    }

    private static Stream<Arguments> cityAndLevelFilterSearch() {

        ExamSchedulePage examSchedulePage = new ExamSchedulePage();

        return Stream.of(
                Arguments.of(
                        examSchedulePage.getMoscowRu(),
                        examSchedulePage.getCertifiedTesterFoundationLevel(),
                        examSchedulePage.getMoscowEn()),

                Arguments.of(
                        examSchedulePage.getKazanRu(),
                        examSchedulePage.getCertifiedTesterAiTesting(),
                        examSchedulePage.getKazanEn()));
    }
}
