package day07_dropdown_isAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropdownMenu {


    WebDriver driver;
    // ilgili ayarlari yapip
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {






        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusu yanindaki dropdown menuden book secin

        /*
             Dropdown menuden istedigimiz option'i secebilmek icin
         oncelikle Select class'indan bir obje olusturmaliyiz.

         ancak select objesi olusturmak icin Select class'inin constructor'i
         handle edecegimiz webelemnt'i istediginden


         */

        // 1 - select objesi olusturmadan once dropdown webelemntini locate etmeliyiz
        WebElement dropdownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- Select class'indan obje olusturmak
        Select select = new Select(dropdownWebElementi);

        // 3- select objesini kullanarak istedigimiz method/method'lari calistirin.
        select.selectByVisibleText("Books");

        // arama kutusuna java yazdirip aramayi yapin
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        // title'in java icerdigini test edin
        String expectedKelime="Java";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));


        /*
           Locate ettigimiz elementi bulamazsa NoSuchElementException
           sayfa yenilendigi icin var olan bir elementi kullanamazsa
           StaleElementException verir
           bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir
         */

        dropdownWebElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownWebElementi);
        select.selectByVisibleText("Books");


        // dropdown menuden Books seceneginin secildigini test edin

        String actualSecilenOption = select.getFirstSelectedOption().getText();
        String expectedSecilecekOption="Books";
        Assert.assertEquals(expectedSecilecekOption,actualSecilenOption);

        // Dropdown menudeki secenek sayisinin 28 oldugunu test edin
        List<WebElement> optionsWebElementListesi =select.getOptions();
        int actualOptionSayisi = optionsWebElementListesi.size();
        int expectedOptionSayisi=28;
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
        Thread.sleep(5000);
    }
}











