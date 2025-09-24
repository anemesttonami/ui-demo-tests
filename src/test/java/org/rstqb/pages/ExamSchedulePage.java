package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import lombok.Getter;
import org.rstqb.pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

@Getter
public class ExamSchedulePage {

    private final String PAGE_ENDPOINT = "/raspisanie-ehkzamenov.html";
    private final ElementsCollection INFO_ROW_ELEMENTS = $$("[class='item col-md-3 match-height']");
    private final SelenideElement EXAM_SCHEDULE_TITLE = $(withTagAndText("h1", "Расписание экзаменов"));
    private final SelenideElement SEARCH_FILTER = $(".filter-body");
    private final SelenideElement SHEMA_FILTER = $("#ctrl_scheme");
    private final SelenideElement LEVEL_FILTER = $("#ctrl_level");
    private final SelenideElement COUNTRY_FILTER = $("#ctrl_country");
    private final SelenideElement DATE_FROM_FILTER = $("#ctrl_date_from");
    private final SelenideElement DATE_TO_FILTER= $("#ctrl_date_to");
    private final SelenideElement FILTER_SEARCH_BUTTON = $("#ctrl_submit");

    @Step("Открываем страницу \"Расписание экзаменов\"")
    public ExamSchedulePage openExamSchedulePage() {
        open(PAGE_ENDPOINT);
        return this;
    }

    @Step("Проверяем, отображается ли заголовок \"Расписание экзаменов\"")
    public ExamSchedulePage examScheduleTitleVisible() {
        EXAM_SCHEDULE_TITLE.shouldBe(Condition.visible);
        return this;
    }

    public ExamSchedulePage checkDateInfo(CalendarComponent.ChosenDate date, int index) {
        Allure.step("Проверяем, корректно ли отображается введённая " + (index == 3 ? "дата от" : "дата до"),
                () -> INFO_ROW_ELEMENTS.get(index).has(Condition.exactText(date.toString())));
        return this;
    }

    @Step("Проверяем, что фильтр и все его элементы существуют и видны")
    public ExamSchedulePage checkFilterAndHisElements() {
        SEARCH_FILTER.should(Condition.visible);
        SHEMA_FILTER.should(Condition.visible);
        LEVEL_FILTER.should(Condition.visible);
        COUNTRY_FILTER.should(Condition.visible);
        DATE_FROM_FILTER.should(Condition.visible);
        DATE_TO_FILTER.should(Condition.visible);
        FILTER_SEARCH_BUTTON.should(Condition.visible);
        return this;
    }
}