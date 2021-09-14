package Rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class RestTest {

    Pars pars;

    @BeforeClass
    public void tets()
    {
    //    pars  = new Pars();
    //    pars.startPas();
    }


    @Test
    public  void  getUser()
    {
       Response response = given().baseUri("https://reqres.in")
                .basePath("/api/users?page=2")
                .contentType(ContentType.JSON)
                .when().get();

       int i = 0;
    }

    @Test
    public  void  post()
    {
        pars  = new Pars();
        pars.startPas();

        Response response = given().baseUri("https://reqres.in")
                .basePath("/api/users?page=2")
                .contentType(ContentType.JSON)
                .body(pars.searchFile("test.json"))
                .when().post();

    }

    @Test
    public  void  ttt()
    {
        pars  = new Pars();
        pars.startPas();
        pars.serializationFile("test.json");
   //     pars.readFile("test.json");
        int i =0;
    }
}
