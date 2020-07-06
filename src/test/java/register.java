import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class register {
    private WebDriver driver;
    @Before
    public  void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resourcces/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");

    }@Test
    public void registerOk(){
         driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
         driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
         driver.findElement(By.cssSelector("#firstname")).sendKeys("ramo");
         driver.findElement(By.cssSelector("#lastname")).sendKeys("moni");
         driver.findElement(By.cssSelector("#email_address")).sendKeys("ramo.moni1991@gmail.com");
         driver.findElement(By.cssSelector("#password")).sendKeys("123456");
         driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
         driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
         WebElement register = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-create > ul > li > ul > li > span"));
         Assert.assertTrue(register.isDisplayed());
         Assert.assertNotEquals("There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.\n", register.getText());

    }@Test
    public void failRegister(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.cssSelector("#firstname")).sendKeys("ramo");
        driver.findElement(By.cssSelector("#lastname")).sendKeys("moni");
        driver.findElement(By.cssSelector("#email_address")).sendKeys("ramo.moni1991@gmail");
        driver.findElement(By.cssSelector("#password")).sendKeys("1234");
        driver.findElement(By.cssSelector("#confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        WebElement wrongRegister = driver.findElement(By.cssSelector("#advice-validate-cpassword-confirmation"));
        Assert.assertTrue(wrongRegister.isDisplayed());


    }
    @After
    public void exit(){
        driver.quit();
    }
}
