package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.rstqb.pages.component.CalendarComponent;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class ExamSchedulePage {

    private final SelenideElement EXAM_SCHEDULE_TITLE = $(withTagAndText("h1", "Расписание экзаменов"));
    private final ElementsCollection INFO_ROW_ELEMENTS = $$("[class='item col-md-3 match-height']");

    public ExamSchedulePage examScheduleTitleVisible() {
        EXAM_SCHEDULE_TITLE.shouldBe(Condition.visible);
        return this;
    }

    public ExamSchedulePage checkStartDate(CalendarComponent.ChosenDate date) {
        INFO_ROW_ELEMENTS.get(3).has(Condition.exactText(date.toString()));
        return this;
    }
}