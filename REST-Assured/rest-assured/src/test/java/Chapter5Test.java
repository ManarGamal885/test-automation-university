import com.github.tomakehurst.wiremock.WireMockServer;
    import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
    import org.testng.annotations.AfterClass;
    import org.testng.annotations.BeforeClass;
    import org.testng.annotations.Test;

    import static io.restassured.RestAssured.given;
    import static org.hamcrest.Matchers.equalTo;
    import static org.hamcrest.Matchers.hasSize;

    public class Chapter5Test {

        // Using XML as a response format
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
            given().
                    when().
                    get("http://localhost:9876/us/90210").
                    then().
                    assertThat().
                    body("response.places.place.placeName", equalTo("Beverly Hills"));
        }

        @Test
        public void requestDeZipCode24848_checkThirdPlaceNameInResponseBody_expectKropp() {
            given().
                    when().
                    get("http://localhost:9876/de/24848").
                    then().
                    assertThat().
                    body("response.places.place[2].placeName", equalTo("Kropp"));
        }

        @Test
        public void requestDeZipCode24848_checkLastPlaceNameInResponseBody_expectKleinBennebek() {
            given().
                    when().
                    get("http://localhost:9876/de/24848").
                    then().
                    assertThat().
                    body("response.places.place[-1].placeName", equalTo("Klein Bennebek"));
        }

        @Test
        public void requestDeZipCode24848_checkLatitudeForSecondPlaceInResponseBody_expect5445() {
            given().
                    when().
                    get("http://localhost:9876/de/24848").
                    then().
                    assertThat().
                    body("response.places.place[1].@latitude", equalTo("54.45"));
        }

        @Test
        public void requestDeZipCode24848_checkNumberOfPlacesWithStateAbbreviationSH_expect4() {
            given().
                    when().
                    get("http://localhost:9876/de/24848").
                    then().
                    assertThat().
                    body("response.places.place.findAll{it.stateAbbreviation=='SH'}", hasSize(4));
        }
    }