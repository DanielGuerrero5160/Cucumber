package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties prop;
   public static Properties readProperties(){
       String path=Constants.PROPERTY_FILE_PATH;
       try {
           FileInputStream file=new FileInputStream(path);
           prop=new Properties();
           prop.load(file);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
       return prop;
   }
public static String getPropertyValue(String propertyKey){
      return prop.getProperty(propertyKey);
}

}
