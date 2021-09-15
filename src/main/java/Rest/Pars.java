package Rest;

import com.google.gson.Gson;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;

public class Pars {

    private File allPath;

    public void startPas()
    {
        allPath = new File("./tetJson/"); //path указывает на директорию
    }

    public File searchFile(String nameFile){

        File[] arrFiles = allPath.listFiles();

        for (File i : arrFiles)
        {
            File[] next = i.listFiles();;

            for (File n : next) {
                if(nameFile.equals(n.getName())){
                    return n;
                }
            }
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
