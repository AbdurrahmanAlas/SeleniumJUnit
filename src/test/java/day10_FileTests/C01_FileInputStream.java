package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {

    @Test
    public void test01() throws FileNotFoundException {


        String dosyayolu="C:\\Users\\lenovo\\Desktop\\deneme.txt";
        FileInputStream fis=new FileInputStream(dosyayolu);

        /*

      File testlerinde genellıkle dowloads'a indırılecek bır dosyanın ınırıldıgını test etmek veya
 bır dosyanın web'e yuklenebıldıgını test etmek ısterız
      Ancak herkesın bılgısayarının ısmı , kullanıcı ısımlerı gıbı farklılıklar olacagınsan testler
tek bır bılgısayarda calısacak  gibi yazılmak zorunda kalırnır.
Bu karışıklıgın önüne geçebilmek için Java iki basit kod blogu sunmuş:

System.out.println(System.getProperty("user.dir"));  // o anca çalışan dosyanın (C01_FileInputStream) yolunu verir
System.out.println(System.getProperty("user.home")); //Kullanıcının temel path'ini verir.


                */

        System.out.println(System.getProperty("user.dir"));
        //o anda calısan dosyanın (C01_FileInputStream) yolunu verir.
        // C:\Selenium\comTeam105JUnit



        System.out.println(System.getProperty("user.home"));

        //Kullanıcının temel path'ini verir.
        //Masaustune gitmek istersek
        ///Users/ahmetbulutluoz/IdeaProjects/com.Team105Junit
        //Dowloads'a gitmek istersek
        //User/ahmetbulutluoz+/Downloads eklememız yeterlidir
       /* Kodlarımızın dınamık olması yani kısının bılgısayarındakı kullanıcı adı gibi detaylara takılmaması için
       file testlerinde kullanılacak dosya yolunu "user.home" temel path'ini çalıştıgı bılgısayardan alacak sekılde olustururuz
        */
        String dinamikDosyaYolu=System.getProperty("user.home")+"C:\\Users\\lenovo\\Desktop\\deneme.txt";


    }
}
