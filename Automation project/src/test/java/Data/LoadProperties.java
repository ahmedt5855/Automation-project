package Data;

import io.qameta.allure.util.PropertiesUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties  {
    //Load properties file from the folder
    public static Properties userdata = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties\\UserDataProperties");

    public static Properties loadProperties(String path)
    {
        Properties pro = new Properties();
        //Stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error Ocurred :"+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error Ocurred :"+e.getMessage());
        }
        return pro;
    }
}
