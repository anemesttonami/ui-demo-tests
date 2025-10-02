package org.rstqb.tests;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.rstqb.pages.MaterialsPage;

import java.io.IOException;

import static io.qameta.allure.Allure.step;

@Epic("Страница \"Материалы ISTQB®\".")
public class MaterialsPageTests extends BaseTest {

    private final MaterialsPage PAGE = new MaterialsPage();

    @BeforeEach
    void openPage() {
        PAGE.openMaterialsPage();
    }

    @Test
    @Tag("smoke")
    @DisplayName("PDF скачивается, соответствующий текст в PDF присутствует.")
    void checkPdf() throws IOException {
        String checkedText = "Testing with Generative AI";

        PDF pdf = PAGE.downloadPdf(PAGE.getGEN_AI_SYLLABUS_PDF());

        step("Проверяем, что в PFD присутствует текст \"" + checkedText + "\"", () ->
                Assertions.assertTrue(pdf.text.contains(checkedText),
                        "В PDF не найден текст " + checkedText)
        );
    }
}
