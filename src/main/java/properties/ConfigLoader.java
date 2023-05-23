package properties;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.yaml.snakeyaml.constructor.Constructor;

public class ConfigLoader {

  // test read config yml
  public static void main(String[] args) throws FileNotFoundException {
    Map<String, Object> properties = loadProperties();
    System.out.println(properties);
  }

  // load config yml
  public static Map<String, Object> loadProperties() throws FileNotFoundException {
    try (InputStream inputStream = new FileInputStream("./src/test/resources/config.yml")) {
      Yaml yaml = new Yaml();
      return yaml.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}

