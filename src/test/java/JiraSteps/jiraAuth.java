package JiraSteps;


import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Assert;


import java.io.IOException;
import static io.restassured.RestAssured.given;


public class jiraAuth  {
    @Step("Логинимся в Jira")
    public static void auth() {
        String logopass = "Basic bmRhdnlkb3ZhOlF3ZXJ0eTEyMw==";
        String username = "ndavydova";

        Response postJson = given()
                .header("Content-Type","application/json")
                .baseUri("https://edujira.ifellow.ru/login.jsp")
                .body(logopass)
                .when()
                .header("Authorization",logopass)
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();


        Assert.assertEquals("Залогинится на удалось", username, postJson.header("X-AUSERNAME"));

    }
}
