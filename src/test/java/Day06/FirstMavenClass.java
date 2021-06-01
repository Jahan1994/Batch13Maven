package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstMavenClass {
    public static void main(String[] args) throws InterruptedException {
        /*1- https://www.amazon.com/ sayfasina gidelim
2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
searchBox.sendKeys("Samsung headphone"+ Keys.ENTER);

WebElement num= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(num.getText());
//sadece sonuc ededini istersek num i Stringe atayib string manipulation yapabiliriz
        String str= num.getText();
        System.out.println(str.substring(8,11));//213 ama dinamik olmadi


        Thread.sleep(2000);
        //sadece click() etdikde Webelement yaratmaya ehtiyac yoxdu asagidaki kimi:
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        Thread.sleep(2000);
        //6.geri giderek arama sayfasindali tum basamaklari yazdiralim
        driver.navigate().back();

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for(WebElement w:basliklarListesi){
            System.out.println(w.getText());
            System.out.println("size"+basliklarListesi.size());
        }

    }
}
