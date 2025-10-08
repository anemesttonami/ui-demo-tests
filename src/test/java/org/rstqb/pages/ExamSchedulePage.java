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

    private final ElementsCollection infoRowElements = $$("[class='item col-md-3 match-height']");

    private final SelenideElement
            examScheduleTitle = $(withTagAndText("h1", "Расписание экзаменов")),
            pagination = $(".pagination .active"),
            paginationDescription = $("[class='pagination text-right'] p"),
            nextPageButton = $(".next a"),
            searchFilter = $(".filter-body"),
            shemaFilter = $("#ctrl_scheme"),
            levelFilter = $("#ctrl_level"),
            cityFilter = $("#ctrl_city"),
            countryFilter = $("#ctrl_country"),
            dateFromFilter = $("#ctrl_date_from"),
            dateToFilter = $("#ctrl_date_to"),
            filterSearchButton = $("#ctrl_submit"),
            cityInSearchResult = $(".table_body .table_cell.col-sm-1.city"),
            numberOfSearchResults = $(".h2.item-count");

    private final String
            moscowRu = "Москва",
            moscowEn = "Moscow",
            kazanRu = "Казань",
            kazanEn = "Kazan",
            certifiedTesterAiTesting = "Certified Tester AI Testing (CT-AI)",
            certifiedTesterFoundationLevel = "Certified Tester Foundation Level (CTFL) v4.0";

    @Step("Открываем страницу \"Расписание экзаменов\".")
    public ExamSchedulePage openExamSchedulePage() {
        open(EXAM_SCHEDULE_PAGE_ENDPOINT);
        return this;
    }

    @Step("Проверяем,отображается ли заголовок \"Расписание экзаменов\".")
    public ExamSchedulePage examScheduleTitleVisible() {
        examScheduleTitle.shouldBe(visible);
        return this;
    }

    public ExamSchedulePage checkDateInfo(CalendarComponent.ChosenDate date, int index) {
        Allure.step("Проверяем, корректно ли отображается введённая в фильтре регистрации на экзамен " + (index == 3 ? "дата от" : "дата до"),
                () -> infoRowElements.get(index).has(Condition.exactText(date.toString())));
        return this;
    }

    @Step("Фильтр и все его элементы существуют и видны.")
    public ExamSchedulePage checkFilterAndHisElements() {
        searchFilter.shouldBe(visible);
        shemaFilter.shouldBe(visible);
        levelFilter.shouldBe(visible);
        cityFilter.shouldBe(visible);
        countryFilter.shouldBe(visible);
        dateFromFilter.shouldBe(visible);
        dateToFilter.shouldBe(visible);
        filterSearchButton.shouldBe(visible);
        return this;
    }

    @Step("Надпись \"{число} результатов\" отображает кол-во результатов отличное от нуля.")
    public void checkNumberOfSearchResults() {
        numberOfSearchResults.shouldHave(matchText("[1-9]\\d* результатов"));
    }

    @Step("Надпись \"Страница {число} из {число}\" отображается корректно.")
    public ExamSchedulePage checkNumberOfPage(int pageNumber) {
        paginationDescription.shouldHave(matchText("Страница " + pageNumber + " из [1-9]\\d*"));
        return this;
    }

    @Step("Нажать на кнопку перехода на следующую страницу")
    public ExamSchedulePage goToNextPage() {
        nextPageButton.click();
        return this;
    }
}