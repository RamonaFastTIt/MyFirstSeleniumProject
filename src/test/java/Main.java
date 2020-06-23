import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","resourcces/chromedriver.exe");
       //login();
       //invalidlogin();
       //searchProduct();
      /// search();
      // cart();
       //women();
        sale();


    }
    public static void login(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a")).click();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("monyk_ramona_16@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.quit();

    }
    public static void invalidlogin(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("monyk_ramona_16@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("ala");
        driver.findElement(By.cssSelector("#send2")).click();
        driver.quit();

    }
    public static void searchProduct(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("SHIRTS");
        driver.findElement(By.cssSelector("#search")).clear();
        driver.quit();

    }
    public static void search(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#search")).sendKeys("SHIRTS");
        driver.findElement(By.cssSelector("body")).getText();
        driver.quit();

    }
    public static void cart(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > p.block-subtitle > a")).click();
        driver.quit();

    }
    public static void women(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.active.parent > a")).click();
        driver.quit();

    }
    public static void sale(){
        WebDriver driver=new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-423")).click();
        driver.quit();
    }
}
