package APISteps1;

import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.restassured.response.Response;
import org.json.JSONObject;
import static APISteps1.getCharacter.charId;
import static io.restassured.RestAssured.given;

public class lastEpisode {
    public static int lastEp;

    @When("Получаем эпизод")
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
        Allure.addAttachment("Номер последнего эпизода: ", String.valueOf(lastEp));

    }
}
