package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormTest {
	 private WebDriver driver;
	

	    public FormTest(WebDriver driver) {
	        this.driver = driver;
	    }
	//Dikkat burda ben robot degilim kutusunu manuel olarak isaretlemeniz gerekmektedir.aksi durumda program hata verir.
	public  void avukatAra(String AnasayfaUrl) throws InterruptedException {
		// Ad alanını doldur
		WebElement adElement = driver.findElement(By.name("ad"));
		adElement.sendKeys("Joe");

		// Soyad alanını doldur
		WebElement soyadElement = driver.findElement(By.name("soyad"));
		soyadElement.sendKeys("Dos");

		// Baro Sicil Numarası alanını doldur
		WebElement baroSicilElement = driver.findElement(By.name("barosicil"));
		baroSicilElement.sendKeys("12345");
		//
		WebElement baroName = driver.findElement(By.name("baroId"));
		Select selectBaroNumber = new Select(baroName);
		Thread.sleep(1000);
		selectBaroNumber.selectByValue("54");
		Thread.sleep(5000);

		/*
		 * WebElement benRobotDegilim
		 * =driver.findElement(By.xpath("//div[@class='rc-anchor-center-container']"));
		 * benRobotDegilim.click();
		 */

		// İlk submit butonunu tıkla
		WebElement submitButton1 = driver.findElement(By.xpath("//button[@value='Avukat']"));
		submitButton1.click();

		// Sonucları kontrol et
		WebElement sonucElement1 = driver.findElement(By.xpath("//span[@class='label label-danger']"));
		String sonuc1 = sonucElement1.getText();

		if (sonuc1.equals("0")) {
			System.out.println("Form dogru sekilde dolduruldu fakat aranan kriterlere gore avukat bulunamadi");
		} else {
			System.out.println("Kriterlere uyan avukat sayisi: " + sonuc1);
		}
		driver.navigate().to(AnasayfaUrl);
		

	}
	public  void stajyerAvukatAra(String AnasayfaUrl) throws InterruptedException {
		// Ad alanını doldur
		WebElement adElement = driver.findElement(By.name("ad"));
		adElement.sendKeys("Joe");

		// Soyad alanını doldur
		WebElement soyadElement = driver.findElement(By.name("soyad"));
		soyadElement.sendKeys("Dos");

		// Baro Sicil Numarası alanını doldur
		WebElement baroSicilElement = driver.findElement(By.name("barosicil"));
		baroSicilElement.sendKeys("12345");
		//
		WebElement baroName = driver.findElement(By.name("baroId"));
		Select selectBaroNumber = new Select(baroName);
		Thread.sleep(1000);
		selectBaroNumber.selectByValue("54");
		Thread.sleep(5000);

		/*
		 * WebElement benRobotDegilim
		 * =driver.findElement(By.xpath("//div[@class='rc-anchor-center-container']"));
		 * benRobotDegilim.click();
		 */

		// İlk submit butonunu tıkla
		WebElement submitButton1 = driver.findElement(By.xpath("//button[@value='Stajyer']"));
		submitButton1.click();

		// Sonucları kontrol et
		WebElement sonucElement1 = driver.findElement(By.xpath("//span[@class='label label-danger']"));
		String sonuc = sonucElement1.getText();

		if (sonuc.equals("0")) {
			System.out.println("Form dogru sekilde dolduruldu fakat aranan kriterlere gore stajyer avukat bulunamadi");
		} else {
			System.out.println("Kriterlere uyan stajyer avukat sayisi: " + sonuc);
		}
		
		driver.navigate().to(AnasayfaUrl);

	}
	
	public  void oturumAcmaTesti(String AnasayfaUrl) throws InterruptedException {

		// Oturum acma sayfasına gidin
		driver.get("https://www.uhap.com.tr/#/kullanici/giris/");

		// Kullanıcı adı (TC) ve sifre alanlarını doldurun
		WebElement kullaniciAdi = driver.findElement(By.xpath("//input[@name ='kullaniciAdi']"));
		WebElement sifre = driver.findElement(By.name("sifre"));

		kullaniciAdi.sendKeys("kullaniciAdi123");
		sifre.sendKeys("sifre123");

		// Oturum açma dugmesine tiklama
		WebElement oturumAcDugmesi = driver.findElement(By.id("loginButton"));
		oturumAcDugmesi.click();

		Thread.sleep(2000);

		String anasayfaUrl = driver.getCurrentUrl();
		if (anasayfaUrl.equals("https://www.example.com/anasayfa")) {
			System.out.println("Oturum Acma Testi Basarili");
		} else {
			System.out.println("Form dogru sekilde dolduruldu fakat kullanıcı bulunamadı");
		}
		driver.navigate().to(AnasayfaUrl);
	}
}
