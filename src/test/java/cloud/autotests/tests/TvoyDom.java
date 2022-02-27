package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TvoyDom extends TestBase {

    @BeforeEach
    public void ClosePopup(){
        step("Открыть https://tvoydom.ru/", () -> {
            open("https://tvoydom.ru/");
        });
        step("Закрыть попап подарок", () -> {
            $(".popmechanic-close").click();
        });
    }


    @Test
    @Description("Тест на главной странице Твой Дом")
    @DisplayName("Проверка отображения главного баннера")
    void checkMainBanner() {
        step("Проверить отображение баннера", () -> {
            $("#carousel-homepage").shouldBe(visible);
        });
    }

    @Test
    @Description("Тест на главной странице Твой Дом")
    @DisplayName("Проверка отображения меню")
    void checkMenu() {
        step("Кликнуть на каталог", () -> {
            $(".header-main__menu-link").click();
        });

        step("Проверить отображение каталога", () -> {
            $(".catalog-menu-dropdown__menu").shouldBe(visible);
        });
    }

    @Test
    @Description("Тест главной страницы Твой Дом")
    @DisplayName("Проверка перехода в корзину")
    void checkGoToCart() {
        step("Кликнуть на корзину", () -> {
            $x("//button[@title=\"Корзина\"]").click();
        });

        step("Проверить url", () -> {
            String urlPage = WebDriverRunner.url();
            assertEquals(urlPage, "https://tvoydom.ru/cart/");
        });
    }

    @Test
    @Description("Тест главной страницы Твой дом")
    @DisplayName("Проверка перехода к сравнению")
    void checkGoToSearch() {
        step("Кликнуть на сравнение", () -> {
            $x("//a[@title=\"Сравнение\"]").click();
        });

        step("Проверить url", () -> {
            String urlPage = WebDriverRunner.url();
            assertEquals(urlPage, "https://tvoydom.ru/compare/");
        });
    }

    @Test
    @Description("Тест главной страницы Твой Дом")
    @DisplayName("Проверка перехода к авторизации")
    void checkGoToLogin() {
        step("Кликнуть на вход", () -> {
            $x("//a[@title=\"Авторизация\"]").click();
        });

        step("Проверить наличие текста в попапе авторизации", () -> {
            $x("(//div[@class=\"popup__body\"]/h2)[8]").shouldHave(text("Вход или регистрация"));
        });
    }

    @Test
    @Description("Autogenerated test")
    @DisplayName("Page title should have header text")
    void titleTest() {
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
        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}