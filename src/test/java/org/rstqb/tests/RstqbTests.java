package org.rstqb.tests;

import static com.codeborne.selenide.Selenide.*;
import static org.rstqb.pages.HomePage.rstqbImg;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class RstqbTests extends BaseTest {

    @Test
    public void openHomePageAndCheckImgExists() {
        open("");
        rstqbImg.shouldBe(Condition.visible);
    }
}
