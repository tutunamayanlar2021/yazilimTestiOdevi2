/** *
* @author Kader Oral
* @since  27.05.2023
* <p>
* main fonksiyonunun bulunduğu sınıf
* </p> */
package pkt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class Program {
	static String AnasayfaUrl = "https://www.barobirlik.org.tr/AvukatArama";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chrome-driver/chromedriver");
		WebDriver surucu = new ChromeDriver();
	
		surucu.manage().window().maximize();
		surucu.get("https://www.barobirlik.org.tr/AvukatArama");
		PopUpTest popUpTestleri = new PopUpTest(surucu);
		ImageTest imageTest = new ImageTest(surucu);
		FormTest formTest = new FormTest(surucu);
		FunctionTest functionTest = new FunctionTest(surucu);
		NavigateTest navigateTest = new NavigateTest(surucu);
		ResponsiveTest responsiveTest = new ResponsiveTest(surucu);

		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			printMenu();
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				popUpTestleri.popUpAcmaVeKapamaTest();
				popUpTestleri.popUpAcmaVeKapamaSonucSayisi(AnasayfaUrl);
				break;
			case 2:
				imageTest.runImageVerificationTests();
				imageTest.renkTesti();
				imageTest.changeTextSize(AnasayfaUrl);
				imageTest.getTBBDropdownItemCount();
				imageTest.getMevzuatDropdownItemCount();
				imageTest.haritayiBuyutKucult(surucu, AnasayfaUrl);
				break;
			case 3:
				functionTest.listeSiralamaTesti();
				functionTest.elemanSayisiTest();
				functionTest.sayacGuncellemeTesti();
				functionTest.cevrimIciSayisi();
				break;
			case 4:// dikkat ben robot degilim kutucugu manuel olarak isaretlenmelidir.aksi durumda
					// program hata verir.
				formTest.avukatAra(AnasayfaUrl);
				formTest.oturumAcmaTesti(AnasayfaUrl);
				break;
			case 5:
				navigateTest.sayfaGecisTesti(AnasayfaUrl);
				navigateTest.sayfaDegister(AnasayfaUrl);
				break;
			case 6:
				responsiveTest.changeScreenSize();
				responsiveTest.mobileSimulationTest(AnasayfaUrl);
				break;
			case 0:
				System.out.println("Programdan cikiliyor...");
				break;
			default:
				System.out.println("Gecersiz secenek!");
				break;
			}
		} while (choice != 0);

		surucu.quit();
	}

	private static void printMenu() {
		System.out.println("----------- Test Senaryolari -----------");
		System.out.println("1. Pop-up Testlerini Calistir");
		System.out.println("2. Imaj Kontrol Testlerini Calistir");
		System.out.println("3. Fonksiyon Testleri Calistir");
		System.out.println("4. Form Kontrol Testlerini Calistir");
		System.out.println("5. Sayfa Gecis Testlerini Calistir");
		System.out.println("6. Ekran Boyutu Kontrol Testlerini Calistir");
		System.out.println("0. Cikis");
		System.out.println("----------------------------------------");
		System.out.print("Seciminizi yapin: ");
	}

}
