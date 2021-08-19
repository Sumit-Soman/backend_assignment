package utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class YamlReader {

    private String endPointConfigs = "./src/test/resources/endPoints.yaml";
    private Map<String, Map<String , String>> mapConfig = new HashMap<>();

    public YamlReader(){
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(endPointConfigs);
        mapConfig = new Yaml().load(inputStream);
    }

    public Map<String, String> getKeyValue(String key) {
        return mapConfig.get(key);
    }
}
