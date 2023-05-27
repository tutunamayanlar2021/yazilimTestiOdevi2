package pkt;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class ResponsiveTest {
	
	private WebDriver driver;
	
	 public ResponsiveTest(WebDriver driver) {
		 this.driver=driver;
	 }
	public void changeScreenSize() throws InterruptedException {
		//Tarayici pencersinin boyutunu degistiriyorum
		Dimension smallSize = new Dimension(800, 600);
        driver.manage().window().setSize(smallSize);
        Thread.sleep(2000);

        // Ekran boyutunu kontrol et
        Dimension currentSize = driver.manage().window().getSize();
        System.out.println("Mevcut Ekran Boyutu: " + currentSize);
        driver.manage().window().maximize();

        
	}

}
