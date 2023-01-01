package PraticCalısmalarim;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Question2 extends TestBase {

    //              ..Exercise2...


    @Test
    public void test01(){

        //  http://www.bestbuy.com 'a gidin,
        driver.get("http://www.bestbuy.com");
        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
        String expectedKelime="Best";
        String actualKelime=driver.getTitle();
        Assert.assertTrue(actualKelime.contains(expectedKelime));

       // System.out.println(actualKelime);
        //  Ayrica Relative Locator kullanarak;

        //      logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin
        WebElement logoGoruntusu=driver.findElement(By.xpath("//img[@class=\"logo\"]"));
        Assert.assertTrue(logoGoruntusu.isDisplayed());

       //  Ayrica Relative Locator kullanarak;
       //      mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

        WebElement mexicoLink=driver.findElement(By.xpath("//img[@alt=\"Mexico\"]"));
        Assert.assertTrue(mexicoLink.isDisplayed());

    }




}
