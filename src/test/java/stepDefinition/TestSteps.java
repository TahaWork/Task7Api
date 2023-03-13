package stepDefinition;

import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static io.restassured.RestAssured.given;


public class TestSteps {


        public static String JSON;


        @When("Получаем данные")
        public static void getJson() {

            FileInputStream fis;
            Properties property = new Properties();

            try {
                fis = new FileInputStream ("./src/test/resources/application.properties");
                property.load(fis);
                JSON = property.getProperty("JSON");
                Allure.addAttachment("JSON", String.valueOf(JSON));
            } catch (IOException e) {
                Assert.assertTrue("Файл application.properties отсуствует", System.err.checkError() );

            } }



    @When("заводим пользователя")
    public static void createU() throws IOException {


        JSONObject body = new JSONObject(JSON);
        body.put("name", "orange");
        body.put("job", "market");
        Response postJson = given()
                .header("Content-Type","application/json")
                .baseUri("https://reqres.in/api")
                .body(body.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract()
                .response();

        Allure.addAttachment("Новый JSON", String.valueOf(body.toString()));
        String name = new JSONObject(postJson.getBody().asString()).get("name").toString();
        String job = new JSONObject(postJson.getBody().asString()).get("job").toString();
        Assert.assertEquals("Имя не совпадает", body.get("name"), name);
        Assert.assertEquals("Работа не совпадает", body.get("job"), job);

    }

}
