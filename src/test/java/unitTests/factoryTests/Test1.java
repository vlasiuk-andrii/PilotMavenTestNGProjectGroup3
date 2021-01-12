package unitTests.factoryTests;

import org.testng.annotations.Test;
import utils.PropertiesReaderClassLoader;

public class Test1 {

    @Test
    public void test1() {
        System.out.println("Test1 test method");
    }

    @Test
    public void test2() {
        String baseUrl = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "baseUrl");
        String defaultTimeoutValue = PropertiesReaderClassLoader.getInstance().getValueFromProperty( "defaultTimeout");
        System.out.println("baseUrl = " + baseUrl);
        System.out.println("defaultTimeoutValue = " + defaultTimeoutValue);
    }
}
