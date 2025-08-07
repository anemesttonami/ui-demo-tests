package org.rstqb.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.rstqb.pages.ExamSchedulePage;
import org.rstqb.pages.HomePage;

public class RstqbTests extends BaseTest {

    @Tag("smoke")
    @Test
    public void openHomePageAndCheckImgExists() {
        new HomePage().openHomePage().isRstqbImageVisible();
    }

    @Tag("smoke")
    @Test
    public void regFormVisibleAndSearch() {
        new HomePage()
                .openHomePage()
                .isRstqbImageVisible()
                .registrationFormIsVisible()
                .clickRegSearchButton();

        new ExamSchedulePage()
                .examScheduleTitleVisible();
    }
}