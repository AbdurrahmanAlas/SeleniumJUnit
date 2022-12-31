package day10_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {


    //   1. Tests packagenin altina bir class oluşturalim : C04_FileDownload

    @Test
    public void test01() {
// 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");


// 3.  Facebookd.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='LambdaTest.txt']")).click();

        ReusableMethods.bekle(5);


        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        //tesst için öncelikle dosyanın indirildiginde dosyaYolu ne olacak bunu olusturmalıyız

        String dosyaYolu=System.getProperty("user.home")+"/Downloads/LambdaTest.txt";


        //Bir dosyanın bilgisayarımızda var olduğunu test etmek için java daki files
        // classindan yardım alırız

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }


    @Test
    public  void test02(){


        //Masaustunde deneme.txt dosyası oldgunu test edin
        //dinamik dosya yolu olusturallim

        String dosyYolu=System.getProperty("user.home")+"/Downloads/LambdaTest.txt";

        //Assert edelm

        Assert.assertTrue(Files.exists(Paths.get(dosyYolu)));












    }

}