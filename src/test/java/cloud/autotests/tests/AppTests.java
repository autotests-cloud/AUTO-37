package cloud.autotests.tests;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTests extends TestBase {
    @Test
    @Description("Soon to be implemented by QA.GURU engineers")
    @DisplayName("Купить алису в яндекс маркете")
    void generatedTest() {
        step("Открыть market.yandex.ru", () -> {
            open("https://market.yandex.ru/");
        });

        step("найти алису в поиске", () -> {
            $("#header-search").setValue("алиса").submit();
            $$("article[data-autotest-id=\"product-snippet\"]").shouldHave(CollectionCondition.sizeGreaterThan(0));

        });

        step("купить ее", () -> {
            $(By.xpath("//*[contains(@title,'Умная колонка Яндекс.Станция')]")).click();
            switchTo().window(1);
            WebElement addToCartButton = $(By.xpath("//*[@data-zone-name='cpa-offer']//div//div[6]//button[@type='button']"));
            JavascriptExecutor executor = (JavascriptExecutor)getWebDriver();
            executor.executeScript("arguments[0].click();", addToCartButton);
        });
    }
}