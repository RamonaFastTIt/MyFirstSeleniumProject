import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class checkout {
    private WebDriver driver;
    @Before
    public  void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resourcces/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");



    }@Test
    public void checkout () throws InterruptedException {
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a")).click();
        driver.findElement(By.cssSelector("#product-collection-image-423")).click();
        driver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        driver.findElement(By.cssSelector("#swatch78 > span.swatch-label")).click();
        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.page-title.title-buttons > ul > li > button > span > span")).click();
        driver.findElement(By.cssSelector("#login\\:guest")).click();
        driver.findElement(By.cssSelector("#onepage-guest-register-button > span > span")).click();
        driver.findElement(By.cssSelector("#billing\\:firstname")).sendKeys("ramona");
        driver.findElement(By.cssSelector("#billing\\:lastname")).sendKeys("tamas");
        driver.findElement(By.cssSelector("#billing\\:email")).sendKeys("monyk_ramona_16@yahoo.com");
        driver.findElement(By.cssSelector("#billing\\:street1")).sendKeys("bibescu");
        driver.findElement(By.cssSelector("#billing\\:city")).sendKeys("cluj napoca");
        Select dropdown = new Select(driver.findElement(By.cssSelector("#billing\\:region_id")));
        dropdown.selectByVisibleText("Alaska");
        driver.findElement(By.cssSelector("#billing\\:postcode")).sendKeys("00255");
        //Select dropdown2 = new Select(driver.findElement(By.cssSelector("#billing\\:country_id")));
        driver.findElement(By.cssSelector("#billing\\:country_id")).click();
        //dropdown.selectByVisibleText("Serbia");
        driver.findElement(By.cssSelector("#billing\\:telephone")).sendKeys("+40747979665");
        driver.findElement(By.cssSelector("#billing-buttons-container > button")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("#checkout-shipping-method-load > dl > dd:nth-child(4) > ul > li > label")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#shipping-method-buttons-container > button > span > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#payment-buttons-container > button > span > span")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#review-buttons-container > button > span > span")).click();
        WebElement checkout = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
        Assert.assertFalse(checkout.isDisplayed());
    }
    @Test

    public void invalidCheckout(){
       driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
       driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(4) > a")).click();
       WebElement emptyForCheckout = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1"));
       Assert.assertTrue(emptyForCheckout.isDisplayed());

    }

    @After
    public void exit(){
        driver.quit();
    }
}
