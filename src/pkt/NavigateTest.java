package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigateTest {
	 private WebDriver driver;
		

	    public NavigateTest(WebDriver driver) {
	        this.driver = driver;
	    }
	

	public void sayfaGecisTesti(String anasayfaUrl) throws InterruptedException {
		WebElement link = driver.findElement(By.xpath("//a[@class='logolink']"));
		link.click();
		Thread.sleep(2000);

		driver.navigate().to(anasayfaUrl);
		Thread.sleep(2000);

		String mevcutUrl = driver.getCurrentUrl();

		if (mevcutUrl.equals(anasayfaUrl)) {
			System.out.println("Sayfa yonlendirme Basarili");
		} else {
			System.out.println("Sayfa yonlendirme Basarisiz");
		}
	}
	public void  sayfaDegister(WebDriver driver,String anasayfaUrl) throws InterruptedException {
		
		 driver.get("https://d.barobirlik.org.tr/2023/Secmenler-Icin-Hukuk-Rehberi/");
	        
	        // İstediğiniz sayfayı giriş kutusuna yazma ve Enter tuşuna basma
		 Thread.sleep(3000);
	        WebElement sayfaGirisi = driver.findElement(By.xpath("//input"));
	        for (int sayfaNumarasi = 1; sayfaNumarasi <= 5; sayfaNumarasi++) {
	            sayfaGirisi.sendKeys(String.valueOf(sayfaNumarasi) + Keys.ENTER);

	             Thread.sleep(7000);

	            System.out.println("Geçiş yapılan sayfa: " + sayfaNumarasi);
	          
	        }

	        System.out.println("Sayfa Aciliyor...");
	        Thread.sleep(3000);
	        driver.navigate().to(anasayfaUrl);

	}
	

	

}
