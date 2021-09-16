package Rest;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Pars {

    private File allPath;

    public void startPas()
    {
      //  allPath = new File("./tetJson/"); //path указывает на директорию
    }

    public File searchFile(String nameFile){

        allPath = new File("./tetJson/");
        File[] arrFiles = allPath.listFiles();

        for (File i : arrFiles) {

            File[] next = i.listFiles();;

            for (File n : next) {

                if(nameFile.equals(n.getName())){
                    return n;
                }
            }
        }
        return null;
    }

    public void verifyJson(String nameFileJsonSchema, Response response){

        JSONObject jsonSchema = new JSONObject(new JSONTokener(readJsonSchema(nameFileJsonSchema)));
        JSONObject fileResponse = new JSONObject( new JSONTokener(response.body().print()));
        Schema schema = SchemaLoader.load(jsonSchema);

        schema.validate(fileResponse);

        int i = 0;
    }

    public File searchJsonSchema(String nameFileJsonSchema){

        allPath = new File("./JsonShems/");
        File[] arrFiles = allPath.listFiles();

        for (File i : arrFiles) {

            File[] next = i.listFiles();;

            for (File n : next) {

                if(nameFileJsonSchema.equals(n.getName())){
                    return n;
                }
            }
        }
        return null;
    }

    public String readJsonSchema(String nameFile){

        File file = searchJsonSchema(nameFile);
        String text = "";

        try(Scanner scan = new Scanner(file)) {

            while (scan.hasNextLine()){
                text = text.concat(scan.nextLine() + "\n");
            }

            return text;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readFile(String nameFile){

        File file = searchFile(nameFile);
        String text = "";

        try(Scanner scan = new Scanner(file)) {

           while (scan.hasNextLine()){
               text = text.concat(scan.nextLine() + "\n");
           }

            return text;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public JsonData serializationFile(String nameFile){

        File file = searchFile(nameFile);

        Gson gson = new Gson();
        JsonData json = gson.fromJson(readFile(nameFile), JsonData.class);

        return json;
    }

    public String readJson(Response response){

        return response.body().print();
    }


}
