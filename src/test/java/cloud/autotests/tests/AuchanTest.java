package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AuchanTest extends TestBase {
    @Test
    @Description("Тест на главной странице Ашан")
    @DisplayName("Проверка отображения главного баннера")
    void checkMainBanner() {
        step("Открыть https://www.auchan.ru/", () -> {
            open("https://www.auchan.ru/");
        });

        step("Проверить отображение баннера", () -> {
            $(".main-promo-carousel").shouldBe(visible);
        });
    }

    @Test
    @Description("Тест на главной странице Ашан")
    @DisplayName("Проверка отображения баннера брендов")
    void checkBannerBrands() {
        step("Открыть https://www.auchan.ru/", () -> {
            open("https://www.auchan.ru/");
        });

        step("Проверить отображение баннера брендов", () -> {
            $(byText("Любимые бренды")).parent().shouldBe(visible);
        });
    }

    @Test
    @Description("Тест на главной странице Ашан")
    @DisplayName("Проверка отображения каталога")
    void checkCatalog() {
        step("Открыть https://www.auchan.ru/", () -> {
            open("https://www.auchan.ru");
        });

        step("Проверить отображение каталога", () -> {
            $("#YouMayNeedContainer").shouldBe(visible);
        });
    }

    @Test
    @Description("Тест главной страницы Ашан")
    @DisplayName("Проверка перехода в корзину")
    void checkGoToCart() {
        step("Открыть https://www.auchan.ru/", () -> {
            open("https://www.auchan.ru/");
        });

        step("Кликнуть на корзину", () -> {
            $("#CartLink").click();
        });

        step("Проверить url", () -> {
            String urlPage = WebDriverRunner.url();
            assertEquals(urlPage, "https://www.auchan.ru/cart/");
        });
    }

    @Test
    @Description("Тест главной страницы Ашан")
    @DisplayName("Проверка перехода к авторизации")
    void checkGoToLogin() {
        step("Открыть https://www.auchan.ru/", () -> {
            open("https://www.auchan.ru/");
        });

        step("Кликнуть на вход", () -> {
            $("#login").click();
        });

        step("Проверить url", () -> {
            String urlPage = WebDriverRunner.url();
            assertEquals(urlPage, "https://www.auchan.ru/auth/");
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.auchan.ru/'", () ->
            open("https://www.auchan.ru/"));

        step("Page title should have text 'HTTP 403'", () -> {
            String expectedTitle = "HTTP 403";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.auchan.ru/'", () ->
            open("https://www.auchan.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}