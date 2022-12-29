package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {

    /*

       Istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
        Bu durumda driver'imiz da otomatik olarak yeni sayfaya gecmis olur.
        Testin ilerleyen asamalarinda yeniden eski sayfalara donus gorevi varsa
        o sayfada iken o sayfanin window Handle Degeri alinip kaydedilir
        ve o sayfaya gecemek istendiginde
        driver.switchTo().window(istenenSayfaninWindowHanleDegeri)
        kodu ile o sayfaya gecis yapilir.
     */


    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();


    }

    @After
    public void teardown() {
        driver.quit();

    }


    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);


        //yeni bir tab da wisequarter.com a gidini ve gittigimizi test edin
        // Testin ilerlleyen asamalarinda yeniden amazon sayfasina donmek gerekiyorsa
        //amazon sayfasiindayken bu windowun window handdle degerini alip kaydetmeliyiz


        String ilkSayfaHandleDegeri=driver.getWindowHandle();

//yeni bir tab da wisequarter.com a gidini ve gittigimizi test edin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Thread.sleep(3000);


        // wisequarter testini yaptıktan sonra yeniden amazonun
        // acık olduğu tab a gecin ve amazon anasayfanin acik oldugunu
        // test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);
         actualUrl = driver.getCurrentUrl();
         expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Thread.sleep(3000);


    }

}