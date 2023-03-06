package CreateUserSteps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;


public class createUser {
    @Step(value = "Создаем пользователя из JSON")
    public static void createU() throws IOException {

        JSONObject body = new JSONObject(new String(Files.readAllBytes(Paths.get("src/main/resources/JSON/user.json"))));
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
        System.out.println( "Отправили вот такой JSON:" +body);
        String name = new JSONObject(postJson.getBody().asString()).get("name").toString();
        String job = new JSONObject(postJson.getBody().asString()).get("job").toString();
        Assert.assertEquals("Имя не совпадает", body.get("name"), name);
        Assert.assertEquals("Работа не совпадает", body.get("job"), job);

    }

}
