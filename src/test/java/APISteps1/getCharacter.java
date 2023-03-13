package APISteps1;

import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class getCharacter {
    public static int charId;
    public static String name;

    @Step("Получаем данные из applicaton.properties")
    public static void getProp() {

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream ("./src/test/resources/application.properties");
            property.load(fis);
            name = property.getProperty("character");
            Allure.addAttachment("ИМЯ: ", name);
        } catch (IOException e) {
            Assert.assertTrue("Файл application.properties отсуствует", System.err.checkError() );

        } }

    @Step("Получаем id персонажа")
    @When("Получаем персонаж")
    public static void getCharacter()

    {
        getProp();
        Response gettingChar = given()
                .baseUri("https://rickandmortyapi.com/api")
                .when()
                .get("/character/" )
                .then()
                .extract()
                .response();

        int charNumber = Integer.parseInt(new JSONObject(gettingChar.getBody().asString()).getJSONObject("info").get("count").toString());
        charId = -1;
        for (int i = 0; i < charNumber; i++) {

            String charName = new JSONObject(gettingChar.getBody().asString()).getJSONArray("results")
                    .getJSONObject(i).get("name").toString();

            if (charName.equals(name))
            { charId = i+1; break; }
        }
        Assert.assertNotEquals("Персонаж не найден " , -1, charId);
        Allure.addAttachment("ID: ", String.valueOf(charId));

    }
}
