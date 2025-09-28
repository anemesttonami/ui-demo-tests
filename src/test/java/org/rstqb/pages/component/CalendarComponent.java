package org.rstqb.pages.component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class CalendarComponent {

    private final String
            MONTH_NUMBER = "option[class='flatpickr-monthDropdown-month'][value='%d']";

    private final ElementsCollection
            MONTH_DROPDOWNS = $$(".flatpickr-monthDropdown-months"),
            YEAR_MODULES = $$("input.numInput.cur-year"),
            DAYS = $$("[class='flatpickr-day ']");

    private final SelenideElement
            DATE_FROM = $("#ctrl_date_from"),
            DATE_TO = $("#ctrl_date_to");

    private final ChosenDate START_DATE = new ChosenDate(),
            END_DATE = new ChosenDate();

    @Step("Вписываем дату от в календаре.")
    public void setDateFrom(int year, int month, int day) {
        DATE_FROM.click();
        selectDate(year, month, day, START_DATE);
        DATE_FROM.setValue(START_DATE.toString());
    }

    @Step("Вписываем дату до в календаре.")
    public void setDateTo(int year, int month, int day) {
        DATE_TO.click();
        selectDate(year, month, day, END_DATE);
        DATE_TO.setValue(END_DATE.toString());
    }

    private void selectDate(int year, int month, int day, ChosenDate date) {
        date.setYear(year);
        date.setMonth(month);
        date.setDay(day);
    }

    @Getter
    @Setter
    public class ChosenDate {

        private int day;
        private int month;
        private int year;

        @Override
        public String toString() {
            return String.format("%02d.%02d.%d", day, month, year);
        }
    }
}
