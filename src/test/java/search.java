import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


    public class search {
        private WebDriver driver;
        @Before
        public  void initDriver() {
            System.setProperty("webdriver.chrome.driver", "resourcces/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://testfasttrackit.info/selenium-test/");

            }

    @Test
    public  void searchProduct(){

        driver.findElement(By.cssSelector("#search")).sendKeys("SHIRTS");
        driver.findElement(By.cssSelector("#search")).clear();


    }@Test
        public void searchProducts(){
            driver.findElement(By.cssSelector("#search")).sendKeys("PEARL STUD EARRINGS");
            driver.findElement(By.cssSelector("#search")).click();
            WebElement search = driver.findElement(By.cssSelector("#product-collection-image-551"));
            Assert.assertTrue(search.isDisplayed());
        }
    @Test
    public  void search(){

        driver.findElement(By.cssSelector("#search")).sendKeys("SHIRTS");
        driver.findElement(By.cssSelector("body")).getText();


    }
    @After
            public void exit(){

                driver.quit();
    }
}
