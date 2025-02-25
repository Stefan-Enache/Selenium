import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class _20_ReadingPropertiesFile {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
        properties.load(file);

        String url = properties.getProperty("appurl");
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        String orderId = properties.getProperty("orderid");
        String customerId = properties.getProperty("customerid");
        System.out.println(url + " " + email + " " + password + " " + orderId + " " + customerId);

        Set<String> keys = properties.stringPropertyNames();
        System.out.println(keys);
        Set<Object> keys2 = properties.keySet();
        System.out.println(keys2);

        Collection<Object> values = properties.values();
        System.out.println(values);

        file.close();
    }
}
