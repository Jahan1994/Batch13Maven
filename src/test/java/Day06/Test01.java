package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        /*1-Test01 isimli bir class olusturun
2- https://www.walmart.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5- Sayfa basliginin “Save” ifadesi icerdigini control edin
6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
7- URL in walmart.com icerdigini control edin
8-”Nutella” icin arama yapiniz
9- Kac sonuc bulundugunu yaziniz
10-Sayfayi kapatin
*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.walmart.com");
        driver.navigate().refresh();

        String tittle= driver.getTitle();

       if(driver.getTitle().contains("Save")){
            System.out.println("iceriyor");
        }else{
            System.out.println("icermiyor");
        }


        if(driver.getTitle().equals("Walmart.com | Save Money.Live Better")){
            System.out.println("esit");
        }else{
            System.out.println("esit degil");
        }

        String url= driver.getCurrentUrl();
        if(driver.getCurrentUrl().contains("walmart.com")){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        WebElement searchBox= driver.findElement(By.id("global-search-input"));
        searchBox.sendKeys("Nutella");
searchBox.submit();
Thread.sleep(1000);

WebElement result= driver.findElement(By.className("result-summary-container"));
        System.out.println(result.getText());
driver.quit();
    }
}
