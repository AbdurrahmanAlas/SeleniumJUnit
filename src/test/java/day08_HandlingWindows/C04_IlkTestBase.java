package day08_HandlingWindows;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_IlkTestBase extends TestBase {

    @Test
    public  void  test01(){


        driver.get("https://www.amazon.com");

        ReusableMethods.bekle(4);


    }


}
