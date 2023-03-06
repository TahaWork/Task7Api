package APIHooks;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.apache.http.protocol.ExecutionContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;


public  class APIHook implements BeforeAllCallback {
    private static boolean started = false;
    @BeforeEach
    public void before()
    {
        if (!started) {
            started = true;
            RestAssured.filters(new AllureRestAssured());
        }
    }

    @AfterEach
    public void driverClose()
    {
        WebDriverRunner.closeWebDriver();

    }


    @Override
    public void beforeAll(ExtensionContext context) throws Exception {

    }
}
