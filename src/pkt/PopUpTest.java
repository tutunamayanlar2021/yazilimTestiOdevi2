
/** *
* @author Kader Oral
* @since  27.05.2023
* <p>
* Bu sınıfta açma kapama ile alakalı testler bulunmaktadır.
* </p> */

package pkt;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopUpTest {
    private WebDriver driver;

    public PopUpTest(WebDriver driver) {
        this.driver = driver;
    }

    public void popUpAcmaVeKapamaTest() throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("//button[@class='btn btn-default glyphicon glyphicon-search']"));
        btn.click();
        Thread.sleep(1000);
        System.out.println("Buton basariyla tiklandi");
    }

    public void popUpAcmaVeKapamaSonucSayisi(String AnasayfaUrl) throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("//button[@class='btn btn-default glyphicon glyphicon-search']"));
        btn.click();
        Thread.sleep(1000);
        driver.findElement(By.name("q")).sendKeys("avukat");
        Thread.sleep(1000);
        WebElement form = driver.findElement(By.xpath("//form[@action='/Arama']"));
        form.submit();
        Thread.sleep(2000);

        WebElement sonucDiv = driver.findElement(By.xpath("//div//p[contains(text(), 'bulundu')]"));
        String text = sonucDiv.getText();
        String[] texts = text.split(" ");
        int sonucSayisi = Integer.parseInt(texts[0]);
        if (sonucSayisi > 0) {
            System.out.println("Bulunan sonuc sayisi:"+sonucSayisi);
        } else {
            System.out.println("Hicbir Sonuc Bulunamadi");
        }
        driver.navigate().to(AnasayfaUrl);
    }
    
    
}
