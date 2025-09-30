package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.Getter;
import org.rstqb.pages.component.CalendarComponent;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class ExamSchedulePage {

    private final String EXAM_SCHEDULE_PAGE_ENDPOINT = "/raspisanie-ehkzamenov.html";

    private final ElementsCollection INFO_ROW_ELEMENTS = $$("[class='item col-md-3 match-height']");

    private final SelenideElement
            EXAM_SCHEDULE_TITLE = $(withTagAndText("h1", "Расписание экзаменов")),
            PAGINATION = $(".pagination .active"),
            PAGINATION_DESCRIPTION = $("[class='pagination text-right'] p"),
            NEXT_PAGE_BUTTON = $(".next a"),
            SEARCH_FILTER = $(".filter-body"),
            SHEMA_FILTER = $("#ctrl_scheme"),
            LEVEL_FILTER = $("#ctrl_level"),
            CITY_FILTER = $("#ctrl_city"),
            COUNTRY_FILTER = $("#ctrl_country"),
            DATE_FROM_FILTER = $("#ctrl_date_from"),
            DATE_TO_FILTER = $("#ctrl_date_to"),
            FILTER_SEARCH_BUTTON = $("#ctrl_submit"),
            CITY_IN_SEARCH_RESULT = $(".table_body .table_cell.col-sm-1.city"),
            NUMBER_OF_SEARCH_RESULTS = $(".h2.item-count");

    private final String
            MOSCOW_RU = "Москва",
            MOSCOW_EN = "Moscow",
            KAZAN_RU = "Казань",
            KAZAN_EN = "Kazan",
            CERTIFIED_TESTER_AI_TESTING = "Certified Tester AI Testing (CT-AI)",
            CERTIFIED_TESTER_FOUNDATION_LEVEL = "Certified Tester Foundation Level (CTFL) v4.0";

    @Step("Открываем страницу \"Расписание экзаменов\".")
    public ExamSchedulePage openExamSchedulePage() {
        open(EXAM_SCHEDULE_PAGE_ENDPOINT);
        return this;
    }

    @Step("Проверяем,отображается ли заголовок \"Расписание экзаменов\".")
    public ExamSchedulePage examScheduleTitleVisible() {
        EXAM_SCHEDULE_TITLE.shouldBe(visible);
        return this;
    }

    public ExamSchedulePage checkDateInfo(CalendarComponent.ChosenDate date, int index) {
        Allure.step("Проверяем, корректно ли отображается введённая в фильтре регистрации на экзамен " + (index == 3 ? "дата от" : "дата до"),
                () -> INFO_ROW_ELEMENTS.get(index).has(Condition.exactText(date.toString())));
        return this;
    }

    @Step("Фильтр и все его элементы существуют и видны.")
    public ExamSchedulePage checkFilterAndHisElements() {
        SEARCH_FILTER.shouldBe(visible);
        SHEMA_FILTER.shouldBe(visible);
        LEVEL_FILTER.shouldBe(visible);
        CITY_FILTER.shouldBe(visible);
        COUNTRY_FILTER.shouldBe(visible);
        DATE_FROM_FILTER.shouldBe(visible);
        DATE_TO_FILTER.shouldBe(visible);
        FILTER_SEARCH_BUTTON.shouldBe(visible);
        return this;
    }

    @Step("Надпись \"{число} результатов\" отображает кол-во результатов отличное от нуля.")
    public void checkNumberOfSearchResults() {
        NUMBER_OF_SEARCH_RESULTS.shouldHave(matchText("[1-9]\\d* результатов"));
    }

    @Step("Надпись \"Страница {число} из {число}\" отображается корректно.")
    public ExamSchedulePage checkNumberOfPage(int pageNumber) {
        PAGINATION_DESCRIPTION.shouldHave(matchText("Страница " + pageNumber + " из [1-9]\\d*"));
        return this;
    }

    @Step("Нажать на кнопку перехода на следующую страницу")
    public ExamSchedulePage goToNextPage() {
        NEXT_PAGE_BUTTON.click();
        return this;
    }
}