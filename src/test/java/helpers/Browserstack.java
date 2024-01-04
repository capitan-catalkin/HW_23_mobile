package helpers;

import org.aeonbits.owner.ConfigFactory;
import owner.UserConfig;

import static io.restassured.RestAssured.given;

public class Browserstack {
    static UserConfig userConfig = ConfigFactory.create(UserConfig.class, System.getProperties());
    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic(userConfig.getUserName(), userConfig.getAccessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
