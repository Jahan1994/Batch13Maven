package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Tekrar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("phone"+ Keys.ENTER);
        Thread.sleep(1000);
       WebElement num= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(num.getText());
        Thread.sleep(1000);
 driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

 driver.navigate().back();
Thread.sleep(1000);
 List<WebElement> list=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
  for (WebElement each:list){
      System.out.println(each.getText());

  }
        System.out.println(list.size());

 }
    }

