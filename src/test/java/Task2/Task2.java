package Task2;

import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task2 {
    public static WebDriver driver;
    Page page;
    @BeforeTest
    public void start()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
        page=new Page();
    }
    @Test
    public void runScenario()
    {
        page.setFromPlaceName("CHIKKAMAGALURU");
        page.setToPlaceName("BENGALURU");
        page.setJourneyDate(31);
        page.searchForBus();
        page.selectSeats();
        String ticketPrice=page.getTicketPrice();
        page.selectAvailableSeat();
        page.choosingBoardingPointAndDropingPoint();
        page.fillCustomerAndPassenger("6789125987","blabla@bla.com","bla bla",1,30);
        page.makePayment();
        String pay=page.getPay();
        page.fillcreditCardForm();
        Assert.assertTrue(pay.contains(ticketPrice));
    }

}
