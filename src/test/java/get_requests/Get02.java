package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class Get02 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */


    @Test
    public void get01(){

        // i)  Set the URL
        String url="https://restful-booker.herokuapp.com/booking/1005";

        // ii) Set the expected data(POST-PUT-PATCH)

        // iii)Type code to send request
        Response response= given().when().get(url);
        response.prettyPrint();

        // iv) Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Response body'de bulunan specifik bir veri nasil assert edilir:
        //assertTrue() methodu parantezin icindeki deger true ise testi gecirir.
         assertTrue( response.asString().contains("Not Found"));

        //Response body'de specifik bir veri bulunmadigini nasil assert edilir:
        //assertFalse() methodu parantezin icindeki deger false ise testi gecirir.
        assertFalse(response.asString().contains("TechProEd")) ;

        //assertEquals() methodu parantez icindeki iki deger esitse testi gecirir.
        System.out.println(response.header("Server"));   //Cowboy verir
        assertEquals("Cowboy",response.header("Server"));


    }


}
