import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
        1) Postman manuel API testi için kullanılır.
        2) API otomasyon testi için Rest-Assured Library kullanıyoruz.
        3) Otomasyon kodlarının yazımı için şu adımları izliyoruz:
            a) Gereksinimleri anlama
            b) Test case'i yazma
               - Test case yazımı için 'Gherkin Language' kullanıyoruz.
                  'Gherkin' bazı keywordlere sahip, bunlar:
                  x) Given: Ön koşullar
                  y) When: Aksiyonlar-->Get, Put, ...
                  z) Then: Dönütler--> Assert,Doğrulama, response, ...
                  t) And: Çoklu işlemler için kullanılır.

            c) Testing kodunun yazımı

                   i)  Set the URL
                   ii) Set the expected data(POST-PUT-PATCH)
                   iii)Type code to send request
                   iv) Do Assertion
     */

        /*
        Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

          */


    @Test
    public void get01(){
        // i)  Set the URL
        String url = "https://restful-booker.herokuapp.com/booking";

        // ii) Set the expected data(POST-PUT-PATCH)

        // iii)Type code to send request
        Response response= given().when().get(url);

       // response.prettyPrint();   --> (tum booking kodlarini gormek icin bu sekilde yazdiririz)

        // iv) Do Assertion
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //Not:  Assert yapmak icin then  kullanmamiz gerekiyor. when, and, given kullanamayiz.

        ////response.then().assertThat().statusCode(400).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        //// status code u 400 yapınca
        //// java.lang.AssertionError: 1 expectation failed.
        ////Expected status code <400> but was <200>.  hatasını veriyor


        //// response.then().assertThat().statusCode(200).contentType("application/xml").statusLine("HTTP/1.1 200 OK");
        //// contentType ı xml yapınca
        //// java.lang.AssertionError: 1 expectation failed.
        ////Expected content-type "application/xml" doesn't match actual content-type "application/json; charset=utf-8".  hatası veriyor

    //Status Code, Status Line, Content Type nasil yazdirilir:
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.statusLine() = " + response.statusLine());
        System.out.println("response.contentType() = " + response.contentType());

    //'Header' nasil yazdirilir:

        System.out.println(response.header("Connection"));

    //'Headers' nasil yazdirilir

        System.out.println("Headers: \n"+ response.headers());

    //'Time' nasil yazdirilir
        System.out.println("Time: "+response.getTime());






    }





}