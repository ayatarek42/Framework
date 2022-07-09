package tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class RestAssured {
    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @DataProvider(name = "placeInfo")
    public static Object[][] zipCodes(){
       return new Object[][]{
               { "us", "90210", "Beverly Hills" },
               { "us", "12345", "Schenectady" },
               { "ca", "B2R", "Waverley"}
       };
    }

    @BeforeClass
    public static void createRequestAndResponseSpecification(){
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }


    @Test(dataProvider = "placeInfo")
    public void requestUsZipCodeBody(String country, String code, String state) {
        String placeName=
        given().spec(requestSpec).pathParam("country",country).pathParam("code",code).
                when().get("{country}/{code}").
                then().assertThat().body("places[0].'place name'", equalTo(state)).
                extract().path("places[0].'place name'");
        Assert.assertEquals(placeName,state);
    }

    @Test
    public void requestUsZipCodeContentType() {

        given().
                spec(requestSpec).
                when().
                get("us/90210").
                then().
                spec(responseSpec);
    }

    @Test
    public void requestUsZipCodeStatusCode() {

        given().spec(requestSpec).
                when().
                get("us/90210").
                then().
                spec(responseSpec);
    }

    @Test
    public void requestUsZipCodeLog() {

       given().spec(requestSpec).
                log().all().
           when().
               get("us/12345").
            then().
               log().body();

    }

    @Test
    public void requestUsZipCodeCheckStateName() {
        given().spec(requestSpec).
            when().
                get("us/90210").
            then().
                assertThat().
                body("places[0].'state'", equalTo("California"));
    }

}
