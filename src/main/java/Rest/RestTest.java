package Rest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
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
    public  void   getUser()
    {
        pars  = new Pars();
        pars.startPas();

       Response response = given().baseUri("https://reqres.in")
                .basePath("/api/users?page=2")
                .when().get();

        pars.verifyJson("jsScem11.json", response);

        //return response;
    }

    @Test
    public void post()
    {
        pars  = new Pars();
        pars.startPas();

        Response response = given().baseUri("https://reqres.in")
                .basePath("/api/users?page=2")
                .contentType(ContentType.JSON)
                .header("Content-Type", "text/plain")
                .body(pars.searchFile("test1.json"))
                .when().post();

        pars.verifyJson("jsScem.json", response);
    }

    @Test
    public  void  ttt()
    {
        pars  = new Pars();
        //pars.startPas();

    }
}
