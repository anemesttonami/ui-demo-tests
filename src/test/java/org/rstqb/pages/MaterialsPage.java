package org.rstqb.pages;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class MaterialsPage {

    private final String MATERIALS_PAGE_ENDPOINT = "/istqb-downloads.html";

    private final SelenideElement GEN_AI_SYLLABUS_PDF = $("[title='Загрузка CT-GenAI-Syllabus-v1.0.pdf']");

    @Step("Скачиваем PDF.")
    public PDF downloadPdf(SelenideElement linkElement) throws IOException {
        return new PDF(linkElement.download());
    }

    @Step("Открываем страницу \"Материалы ISTQB®\".")
    public void openMaterialsPage() {
        open(MATERIALS_PAGE_ENDPOINT);
    }
}
