package Task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Task1 {
    public static WebDriver driver;
    Page page;
    @BeforeTest
    public void start()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.get("https://www.amazon.com/");
        page=new Page();
    }
    @Test
    public void firstScenario()
    {
        page.searchForProduct("car accessories");
        page.gotoFirstProduct();
        String asin=page.getAsin();
        String itemPrice=page.getPriceOfProduct();
        String itemName=page.getNameOfProduct();
        page.addProductToCartAndGoToCart();
        Assert.assertEquals(page.getProductAsinInCart(),asin);
        Assert.assertEquals(page.getProductPriceInCart(),itemPrice);
        Assert.assertEquals(page.getProductNameInCart(),itemName);
    }
    @Test
    public void secondScenario()
    {
        page.goToTodaysDeal();
        page.selectProductType("Headphones");
        page.selectProductType("grocery");
        page.goToTenPercentOffOrMore();
        page.goToWantedPageNumber(4);
        page.selectRandomProduct();
        String asin=page.getAsin();
        String itemPrice=page.getPriceOfProduct();
        String itemName=page.getNameOfProduct();
        page.addProductToCartAndGoToCart();
        Assert.assertEquals(page.getProductAsinInCart(),asin);
        Assert.assertEquals(page.getProductPriceInCart(),itemPrice);
        Assert.assertEquals(page.getProductNameInCart(),itemName);
    }

    @AfterTest
    public void end()
    {
        driver.quit();
    }
}
