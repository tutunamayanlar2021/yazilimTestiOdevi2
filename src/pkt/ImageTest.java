package pkt;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class ImageTest {
	private  WebDriver driver;
	
	public ImageTest (WebDriver driver) {
		this.driver=driver;
	}
	public void runImageVerificationTests() {

		// Senaryo 1: Bir resmin yüklenip yüklenmediğini kontrol et

		WebElement image = driver.findElement(By.xpath("//a[@class='logolink']"));
		String imageSource = image.getAttribute("href");
		if (imageSource.isEmpty()) {
			System.out.println("Hata: Resim yüklenemedi!");
		} else {
			System.out.println("Resim yüklendi: " + imageSource);
		}

		// Senaryo 2: Bir resmin boyutunu kontrol et
		int imageWidth = image.getSize().getWidth();
		int imageHeight = image.getSize().getHeight();
		System.out.println("Resim boyutu: " + imageWidth + "x" + imageHeight + " piksel");

	}
	public void renkTesti() throws InterruptedException {

		WebElement liSpan = driver.findElement(By.xpath("//h4"));
		String rgb = liSpan.getCssValue("color");
		String color = Color.fromString(rgb).asHex();

		if (color.equals("#a94442")) {
			System.out.println("Renk dogru!");
		} else {
			System.out.println("Renk hatali!");
		}

	}
	
	public void changeTextSize(String AnasayfaUrl) throws InterruptedException {
		WebElement toSYDF = driver.findElement(By.xpath("//a/i[@class='fa fa-heartbeat cl3']"));
		toSYDF.click();
		Thread.sleep(2000);
        WebElement minusButton = driver.findElement(By.xpath("//i[@class='fa fa-minus']"));
       
        for (int i = 0; i < 3; i++) {
        	 minusButton.click();
            Thread.sleep(1000); // İsteğe bağlı olarak bekleme süresi eklenebilir
        }
        System.out.println("Font boyutu kucultuldu");
        Thread.sleep(2000);
        // Yazi boyutunu buyutme testi
        WebElement plusButton = driver.findElement(By.xpath("//i[@class='fa fa-plus']"));
        
        for (int i = 0; i < 7; i++) {
        	plusButton.click();
           Thread.sleep(1000); // İsteğe bağlı olarak bekleme süresi eklenebilir
       }
        System.out.println("Font boyutu buyutuldu");
        Thread.sleep(3000);
        
        //Resetleme
        WebElement resetButton = driver.findElement(By.xpath("//a[@class='fontReset']"));
        resetButton.click();
        Thread.sleep(2000);
        System.out.println("Font boyutu resetlendi");
        driver.navigate().to(AnasayfaUrl);
		
	}
	public void getTBBDropdownItemCount() {
	    WebElement dropdownElement = driver.findElement(By.xpath("//section[@class='menu']/ul/li/a[text()='TBB']"));
	    dropdownElement.click();

	    List<WebElement> dropdownItems = driver.findElements(By.xpath("//div[@class='grid-container2']/ul/li"));
	    
	    
	    int itemCount = dropdownItems.size();

	    dropdownElement.click(); // Dropdown menüyü kapatmak için tekrar tıklama yapılır
        System.out.println("TBB altinda "+itemCount+ " eleman bulundu.");
	}
	public void getMevzuatDropdownItemCount() {
	    WebElement dropdownElement = driver.findElement(By.xpath("//section[@class='menu']/ul/li/a[text()='Mevzuat']"));
	    dropdownElement.click();
	    List<WebElement> dropdownItems = driver.findElements(By.xpath("//div[@class='col-md-6']/ul/li"));
	    
	    
	    int itemCount = dropdownItems.size();

	    dropdownElement.click(); // Dropdown menüyü kapatmak için tekrar tıklama yapılır
        System.out.println("Mevuzat altinda avukata ozel "+itemCount+ " elaman bulundu.");
	}
	
	

}
