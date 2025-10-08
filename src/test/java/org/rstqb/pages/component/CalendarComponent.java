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
            monthNumber = "option[class='flatpickr-monthDropdown-month'][value='%d']";

    private final ElementsCollection
            monthDropdowns = $$(".flatpickr-monthDropdown-months"),
            yearModules = $$("input.numInput.cur-year"),
            days = $$("[class='flatpickr-day ']");

    private final SelenideElement
            dateFrom = $("#ctrl_date_from"),
            dateTo = $("#ctrl_date_to");

    private final ChosenDate startDate = new ChosenDate(),
            endDate = new ChosenDate();

    @Step("Вписываем дату от в календаре.")
    public void setDateFrom(int year, int month, int day) {
        dateFrom.click();
        selectDate(year, month, day, startDate);
        dateFrom.setValue(startDate.toString());
    }

    @Step("Вписываем дату до в календаре.")
    public void setDateTo(int year, int month, int day) {
        dateTo.click();
        selectDate(year, month, day, endDate);
        dateTo.setValue(endDate.toString());
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
