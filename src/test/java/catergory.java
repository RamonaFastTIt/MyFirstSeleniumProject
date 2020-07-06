import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class catergory {
    private WebDriver driver;
    @Before
    public  void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resourcces/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }@Test
    public void women(){
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a")).click();
        WebElement women = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div.col-main > div.page-title.category-title > h1"));
        Assert.assertTrue(women.isDisplayed());

    }@Test
    public  void sale(){

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-423")).click();

    }@Test
    public void male() {

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-403")).click();
        driver.findElement(By.cssSelector("#swatch27 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#qty")).sendKeys("114");
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        WebElement male = driver.findElement(By.cssSelector("#messages_product_view > ul > li > ul > li > span"));
        Assert.assertTrue(male.isDisplayed());
        Assert.assertNotEquals("The requested quantity for \"Slim fit Dobby Oxford Shirt\" is not available.\n", male.getText());
    }
    @After
    public void exit(){
        driver.quit();
    }
}
