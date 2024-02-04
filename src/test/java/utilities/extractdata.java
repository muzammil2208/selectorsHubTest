package utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class extractdata {
    static Properties prop;
    static String HomePath=System.getProperty("user.dir");
    public static String getData(String value)
    {
        String result="null";
        try{
            prop=new Properties();
            InputStream input=new FileInputStream(HomePath+"/config.properties");
            prop.load(input);
            result=prop.getProperty(value);
            return result;
        }
        catch(Exception e)
        {
            System.out.println("Error while retrieving data configurations file"+e.getMessage());
        }
        return result;
    }
}
