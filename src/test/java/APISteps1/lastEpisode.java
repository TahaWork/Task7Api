package APISteps1;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import static APISteps1.getCharacter.charId;
import static io.restassured.RestAssured.given;

public class lastEpisode {
    public static int lastEp;
    @Step("Получаем последний эпизод")
    public static void getEpisode()
    {
        Response getLastEpisode = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" + charId)
                .then()
                .extract()
                .response();
        int episode = (new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").length()-1);
        lastEp = Integer.parseInt(new JSONObject(getLastEpisode.getBody().asString()).getJSONArray("episode").get(episode).toString().replaceAll("[^0-9]",""));
        System.out.println("Номер последнего эпизода: " +lastEp);


    }
}
