package fileReaders.jsonFile;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    public String locat;

    public  String jsonReaderLocator(int i) throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/main/java/fileReaders/jsonFile/LocatorsData.json";
        File srcFile = new File(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(srcFile));
        Object jsonObject = jsonArray.get(i);
        JSONObject locator = (JSONObject) jsonObject;
        locat = (String) locator.get("locator");
        return  locat;
        }

    }

