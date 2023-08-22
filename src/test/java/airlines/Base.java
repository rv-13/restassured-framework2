package airlines;

import utils.JsonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class Base {

    public static Map<String, Object> dataFromJsonFile;
    public static Properties properties;

    static {

        properties = new Properties();
        File file = new File(System.getProperty("user.dir") + "/src/main/java/configs/config.properties");
        FileInputStream fisConfigFile;
        try {
            fisConfigFile = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fisConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String jsonFileName = properties.getProperty("jsonFileName");
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");

        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("" + env + "/" + jsonFileName + ".json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Object endPoint = dataFromJsonFile.get("createUserEndpoint");
    }
}
