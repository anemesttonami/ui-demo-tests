package org.rstqb.tests;

import com.codeborne.pdftest.PDF;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;
import org.rstqb.pages.MaterialsPage;

import java.io.IOException;

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
        PDF pdf = PAGE.downloadPdf(PAGE.getGEN_AI_SYLLABUS_PDF());

        Assertions.assertTrue(pdf.text.contains("Testing with Generative AI"));
    }
}
