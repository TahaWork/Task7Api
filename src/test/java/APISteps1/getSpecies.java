package APISteps1;

import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.json.JSONObject;
import static APISteps1.getCharacter.charId;
import static APISteps1.lastCharacter.lastChar;
import static io.restassured.RestAssured.given;

public class getSpecies {
    public static String mortySpecies;
    public static String lastCharSpecies;

    @When("Получаем расу Морти")


    public static void getMortySpecies()
    {
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" +charId)
                .then()
                .extract()
                .response();

        mortySpecies = (new JSONObject(gettingChar.getBody().asString()).get("species").toString());
        Allure.addAttachment("Раса Морти: ", mortySpecies);

    }

    @When("Получаем расу последнего персонажа")
    public static void getLastCharacterSpecies()
    {
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" +lastChar)
                .then()
                .extract()
                .response();

        lastCharSpecies = (new JSONObject(gettingChar.getBody().asString()).get("species").toString());
        Allure.addAttachment("Раса последнего персонажа: ", lastCharSpecies);

    }


}
