package org.rstqb.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class ExamSchedulePage {
    private SelenideElement examScheduleTitle = $(withTagAndText("h1", "Расписание экзаменов"));

    public ExamSchedulePage examScheduleTitleVisible() {
        examScheduleTitle.shouldBe(Condition.visible);
        return this;
    }
}