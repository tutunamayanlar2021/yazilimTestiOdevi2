package pkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FunctionTest {
	 private WebDriver driver;
		

	    public FunctionTest(WebDriver driver) {
	        this.driver = driver;
	    }
	
	
	
	public void sayacGuncellemeTesti() throws InterruptedException {
	    // Sayfanin baslangic durumunu kontrol etmek icin sayacin baslangic degerini aliyoruz
	    WebElement sayacElementi = driver.findElement(By.id("okunma"));
	    int baslangicDegeri = Integer.parseInt(sayacElementi.getText());
	    System.out.println("Sayacin Baslangic Degeri: " + baslangicDegeri);
	    Thread.sleep(2000);

	    // Sayacin güncellenmesini sağlamak için sayfayi yeniliyoruz
	    driver.navigate().refresh();
	    Thread.sleep(9000);

	    // Guncellenmis sayacin degerini kontrol ediyoruz
	    sayacElementi = driver.findElement(By.id("okunma")); // Elementi yeniden buluyoruz hata veriyor diger turlu
	    int guncelDeger = Integer.parseInt(sayacElementi.getText());
	    
	   
	    System.out.println("Sayacin Güncel Degeri: " + guncelDeger);
         
	    // Baslangic degerine gore sayacin degerini kontrol ediyoruz 
	    if (guncelDeger != baslangicDegeri) {
	        System.out.println("Sayac guncelledi");
	    } else {
	        System.out.println("Sayac henuz guncellenmedi");
	    }
	}
	
	//Select icindeki eleman sayisini test ediyorum
		public void elemanSayisiTest() {
		    List<WebElement> liste = driver.findElements(By.cssSelector("select[name='baroId'] option"));

		    List<String> urunIsimleri = new ArrayList<>();
		    for (WebElement urun : liste) {
		        urunIsimleri.add(urun.getText());
		    }

		    List<String> siraliListe = new ArrayList<>(urunIsimleri);
		    Collections.sort(siraliListe);

		    int elemanSayisi = urunIsimleri.size();
		    System.out.println("Listedeki eleman sayısı: " + elemanSayisi);
		}
		// select kismindaki liste elemanlarinin dogru siralamada olup olmadigini
		// kontrol etmek için kullanilir.
		public void listeSiralamaTesti() {
			List<WebElement> liste = driver.findElements(By.name("baroId"));

			List<String> urunIsimleri = new ArrayList<>();
			for (WebElement urun : liste) {
				urunIsimleri.add(urun.getText());
			}

			List<String> siraliListe = new ArrayList<>(urunIsimleri);
			Collections.sort(siraliListe);

			if (urunIsimleri.equals(siraliListe)) {
				System.out.println("Liste Sirali");
				// System.out.println(urunIsimleri);

			} else {
				System.out.println("Liste Düzensiz");
			}
		}

}
