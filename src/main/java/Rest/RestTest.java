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
    public  void  getUser()
    {
       Response response = given().baseUri("https://reqres.in")
                .basePath("/api/users?page=2")
                .when().get();

       int i = 0;
    }

    @Test
    public  void  post()
    {
        pars  = new Pars();
        pars.startPas();

        String ttt = pars.readFile("test.json");

        Response response = given().baseUri("https://reqres.in")
                .basePath("/api/users?page=2")
                .contentType(ContentType.JSON)
                .header("Content-Type", "text/plain")
                .body(ttt)
                .when().post();


        System.out.println("Ух");
        System.out.println(response.body().print());
        int i = 0;
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
