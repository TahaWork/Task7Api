package APISteps1;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static APISteps1.getCharacter.charId;
import static io.restassured.RestAssured.given;

public class getSpecies {
    public static String mortySpecies;
    public static String lastCharSpecies;
    @Step("Получаем расу Морти")


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
        System.out.println("Раса Morty: " + mortySpecies);

    }
    @Step("Получаем расу последнего персонажа")
    public static void getLastCharacterSpecies(int id)
    {
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" +id)
                .then()
                .extract()
                .response();

        lastCharSpecies = (new JSONObject(gettingChar.getBody().asString()).get("species").toString());
        System.out.println("Раса последнего персонажа: " + lastCharSpecies);

    }


}
