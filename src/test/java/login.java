
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class login {
    private WebDriver driver;
    @Before
    public  void initDriver() {
        System.setProperty("webdriver.chrome.driver", "resourcces/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");


    }@Test
    public  void login(){

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > a")).click();
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ramo.moni1991@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement welcomeElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
        Assert.assertTrue(welcomeElement.isDisplayed());
        Assert.assertEquals( "Hello, ramo moni!", welcomeElement.getText());


    }@Test
    public void invalidlogin(){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("monyk_ramona_16@yahoo.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("alaala");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement wronglogin = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.account-login > ul > li > ul > li > span"));
        Assert.assertTrue(wronglogin.isDisplayed());
        Assert.assertNotEquals("Invalid login or password", wronglogin.getText());



    }
    @Test
    public void password (){
        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label")).click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("ramo.moni1991@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("bau");
        driver.findElement(By.cssSelector("#send2")).click();
        WebElement shortpass = driver.findElement(By.cssSelector("#advice-validate-password-pass"));
        Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", shortpass.getText());
    }
    @After
    public void exit(){
        driver.quit();
    }

}
