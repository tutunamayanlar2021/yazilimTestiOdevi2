package pkt;

import org.openqa.selenium.By;
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

	

}
