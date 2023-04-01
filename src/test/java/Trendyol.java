import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Trendyol {

    public static final String API_KEY = "4c33e12a";

    public static final String API_URL = "http://www.omdbapi.com/";

    @Test
 public void harryPotterTest() {
        Response responseBody = given()
                .when()
                .queryParam("apikey", API_KEY)
                .queryParam("s", "Harry Potter")
                .get(API_URL)
                .then()
                .extract()
                .response();

        Gson g = new Gson();

        Model model = g.fromJson(responseBody.toString(), Model.class);
        List<Movie> movieList= model.getSearch();
        responseBody.prettyPrint();
    }

}
