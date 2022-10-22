package Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page {
    WebDriver driver = Task2.driver;

    public Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "fromPlaceName")
    WebElement fromPlaceName;
    @FindBy(id = "toPlaceName")
    WebElement toPlaceName;
    @FindBy(id = "txtJourneyDate")
    WebElement journeyDate;
    @FindBy(xpath = "/html/body/main/form/section/div/div[6]/div[3]/div[2]/div[1]/div[1]/div[5]/div/input[4]")
    WebElement selectSeatsBtn;
    @FindBy(id = "mobileNo")
    WebElement mobileNo;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "passengerNameForward0")
    WebElement passengerName;
    @FindBy(id = "genderCodeIdForward0")
    WebElement gender;
    @FindBy(id = "passengerAgeForward0")
    WebElement passengerAge;
    @FindBy(id = "concessionIdsForward0")
    WebElement concession;
    @FindBy(id = "PgBtn")
    WebElement makePaymentBtn;
    @FindBy(linkText = "Credit Card")
    WebElement creditCard;
    @FindBy(css = ".panel-footer > strong")
    WebElement pay;
    @FindBy(xpath = "/html/body/main/form/div[1]/div/div[2]/div[3]/button")
    WebElement searchForBusBtn;
    @FindBy(className = "availSeatClassS")
    WebElement availSearClass;
    @FindBy(xpath = "//div[2]/div/div/div/div/ul/li")
    WebElement boardingPoint;
    @FindBy(xpath = "//div[2]/div/div[2]/div/div/ul/li")
    WebElement dropingPoint;
    @FindBy(xpath = "//*[@id=\"ForwardResults\"]/div[2]/div[1]/div[1]/div[5]/div/h3")
    WebElement ticketPrice;
    @FindBy(id="cnumber")
    WebElement cardNumber;
    @FindBy(id="expmon")
    WebElement expairyMonth;
    @FindBy(id="expyr")
    WebElement expairyYear;
    @FindBy(id="cvv2")
    WebElement cvv2;
    @FindBy(id="cname2")
    WebElement cardHolderName;


    public void setFromPlaceName(String placeName) {
        fromPlaceName.sendKeys(placeName);
        driver.findElement(By.linkText(placeName)).click();
    }

    public void setToPlaceName(String placeName) {
        toPlaceName.sendKeys(placeName);
        driver.findElement(By.xpath("//a[contains(.,'" + placeName + "')]")).click();
    }

    public void setJourneyDate(int Day) {
        journeyDate.click();
        driver.findElement(By.linkText(Integer.toString(Day))).click();
    }

    public void searchForBus() {
        searchForBusBtn.click();
    }

    public void selectSeats() {
        selectSeatsBtn.click();
    }

    public void selectAvailableSeat() {
        availSearClass.click();
    }

    public void choosingBoardingPointAndDropingPoint() {
        boardingPoint.click();
        dropingPoint.click();
    }

    public void fillCustomerAndPassenger(String phoneNo, String email, String name, int gender, int age) {
        mobileNo.sendKeys(phoneNo);
        this.email.sendKeys(email);
        passengerName.sendKeys(name);
        passengerAge.sendKeys(Integer.toString(age));
        Select se = new Select(this.gender);
        se.selectByIndex(gender);
        se = new Select(this.concession);
        se.selectByIndex(1);
    }

    public void fillcreditCardForm()
    {
        cardNumber.sendKeys("0000000000000000000");
        Select se=new Select(expairyMonth);
        se.selectByIndex(2);
        se=new Select(expairyYear);
        se.selectByIndex(2);
        cvv2.sendKeys("000");
        cardHolderName.sendKeys("bla bla");
    }

    public void makePayment()
    {
        makePaymentBtn.click();
    }
    public String getTicketPrice()
    {
        return ticketPrice.getText();
    }
    public String getPay()
    {
        return pay.getAttribute("textContent");
    }


}
