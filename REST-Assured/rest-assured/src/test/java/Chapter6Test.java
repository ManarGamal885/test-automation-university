import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import dataentities.Location;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Chapter6Test {

    // Using java objects for serialization and deserialization
    private WireMockServer wireMockServer;

    @BeforeClass
    public void setUp() {
        wireMockServer = new WireMockServer(WireMockConfiguration.options().port(9876));
        wireMockServer.start();
    }

    @AfterClass
    public void tearDown() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {
        Location location = given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .as(Location.class);

        Assert.assertEquals(
                location.getPlaces().get(0).getPlaceName(),
                "Beverly Hills"
        );
    }

    @Test
    public void sendLvZipCode1050_checkStatusCode_expect200() {
        Location location = new Location();
        location.setCountry("Netherlands");

        given()
                .contentType(ContentType.JSON)
                .body(location)
                .log().body()
                .when()
                .post("http://localhost:9876/lv/1050")
                .then()
                .assertThat()
                .statusCode(200);
    }
}