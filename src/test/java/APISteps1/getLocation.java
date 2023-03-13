package APISteps1;

import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.json.JSONObject;
import static APISteps1.getCharacter.charId;
import static APISteps1.lastCharacter.lastChar;
import static io.restassured.RestAssured.given;

public class getLocation {
    public static String mortyLocation;
    public static String lastCharLocation;

    @When("Получаем локацию Морти")
    public static void getMortyLocation()
    {
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" +charId)
                .then()
                .extract()
                .response();
        mortyLocation = (new JSONObject(gettingChar.getBody().asString()).get("location").toString());
        Allure.addAttachment("Локация Морти: ", mortyLocation);
    }

    @When("Получаем локацию последнего персонажа")
    public static void getLastCharacterLocation()
    {
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" +lastChar)
                .then()
                .extract()
                .response();
        lastCharLocation = (new JSONObject(gettingChar.getBody().asString()).get("location").toString());
        Allure.addAttachment("Локация последнего персонажа: ", lastCharLocation);
    }
}
