package unitTests;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CalculatorTest {

//    Calculator calculator = new Calculator();

    @DataProvider
    public Object[][] sumData() {
        return new Object[][]{
                {2, 3, 5},
                {0, 3, 3},
                {-5, 7, 2}};
    }

//    @Test(dataProvider = "sumData")
//    public void test1Sum(int x1, int x2, int x3) {
//        Assert.assertEquals(calculator.sum(x1, x2), x3);
//    }
//
//    @Test
//    public void test1Multiply() {
//        Assert.assertEquals(calculator.multiply(4,7), 28);
//    }
//
//    @Test
//    public void test2Multiply() {
//        Assert.assertEquals(calculator.multiply(4,0), 0);
//    }
}