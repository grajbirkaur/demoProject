
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class DataProviderUtility {
    Map<String, String> map = new HashMap<String, String>();

    public Map<String, String> readMap(String testcase) {
        Properties prop = new Properties();
        InputStream input = null;
        String[] src = {"./src/main/resources/Config.json"};
        try {
            for (String string : src) {
                input = new FileInputStream(string);
                JSONParser parser = new JSONParser();
                try {
                    Object obj = parser.parse(new FileReader(string));
                    JSONObject jsonObject = (JSONObject) obj;
                    map = ((HashMap<String, String>) jsonObject.get("main config"));
                } catch (Exception e) {

                }
            }

    } catch(
    Exception e)

    {
    } finally

    {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
            }
        }
    }
        return map;
}
}
