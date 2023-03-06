package APISteps1;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static APISteps1.lastEpisode.lastEp;
import static io.restassured.RestAssured.given;

public class lastCharacter {
    public static int lastChar;
    @Step("Получаем последнего персонажа")
    public static void getLastCharacter()
    {
        Response getLastChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/episode/" + lastEp)
                .then()
                .extract()
                .response();

        int Character = (new JSONObject(getLastChar.getBody().asString()).getJSONArray("characters").length()-1);
        lastChar = Integer.parseInt(new JSONObject(getLastChar.getBody().asString()).getJSONArray("characters").get(Character).toString().replaceAll("[^0-9]",""));
        System.out.println("Номер последнего персонажа: " +lastChar);
    }

}
