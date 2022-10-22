package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class Page {
    WebDriver driver = Task1.driver;
    public Page() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "twotabsearchtextbox")
    WebElement search;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchBtn;
    @FindBy(id = "productTitle")
    WebElement productName;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCartButton;
    @FindBy(id="nav-cart")
    WebElement cart;
    @FindBy(className = "sc-product-price")
    WebElement productPriceInCart;
    @FindBy(className = "a-selected")
    WebElement currentPage;
    @FindBy(className = "a-last")
    WebElement nextBtn;
    @FindBy(css = ".sc-list-item-border")
    WebElement productInTheCart;
    @FindBy(css="#gsod_singleOfferDisplay_Desktop")
    WebElement singleOfferDisplay;
    @FindBy(css="#search>div.s-desktop-width-max.s-desktop-content" +
            ".s-opposite-dir.sg-row>div.s-matching-dir.sg-col-16-of-20.sg-col" +
            ".sg-col-8-of-12.sg-col-12-of-16>div>span:nth-child(4)>" +
            "div.s-main-slot.s-result-list.s-search-results.sg-row>div:nth-child(4)")
    WebElement firstProduct;
    @FindBy(css="#corePriceDisplay_desktop_feature_div > " +
            "div.a-section.a-spacing-none.aok-align-center > " +
            "span.a-price.aok-align-center.reinventPricePriceToPayMargin.priceToPay > " +
            "span.a-offscreen")
    WebElement productPrice;
    @FindBy(xpath = "//div[4]/div/div[1]/div/div/div[2]/ul/li[1]/span/a/span[1]/span/span[1]")
    WebElement productNameInCart;
    @FindBy(linkText = "Today's Deals")
    WebElement todayDeals;
    @FindBy(linkText = "10% off or more")
    WebElement tenPercentOffOrMore;
    public void searchForProduct(String productName)
    {
        search.sendKeys(productName);
        searchBtn.click();
    }
    public void addProductToCartAndGoToCart()
    {
        addToCartButton.click();
        cart.click();
    }
    public void goToTodaysDeal()
    {
        todayDeals.click();
    }
    public void goToTenPercentOffOrMore()
    {
        tenPercentOffOrMore.click();
    }
    public void selectProductType(String productTypeName)
    {
        for(WebElement element:driver.findElements(By.className("CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49")))
            if (element.getText().equalsIgnoreCase(productTypeName))
                if (!element.isSelected()) element.click();
    }
    public void goToWantedPageNumber(int pageNumber)
    {
        while (true)
        {
            if (currentPage.getText().equals(Integer.toString(pageNumber))||!nextBtn.isEnabled()) break;
            if (Integer.parseInt(currentPage.getText())<pageNumber) nextBtn.click();
        }
    }
    public void gotoFirstProduct()
    {
        firstProduct.click();
    }
    public void selectRandomProduct()
    {
        List<WebElement> elements=driver.findElements(
                By.cssSelector("#grid-main-container>div.a-row.Grid-module__gridSection_1SEJTeTsU88s6aVeuuekAp>div>div"));
        elements.get(50).click();
    }
    public String getAsin()
    {
        return singleOfferDisplay.getAttribute("data-csa-c-asin");
    }

    public String getPriceOfProduct(){
        return productPrice.getAttribute("textContent");
    }
    public String getNameOfProduct()
    {
        return productName.getText();
    }
    public String getProductAsinInCart()
    {
        return productInTheCart.getAttribute("data-asin");
    }
    public String getProductPriceInCart()
    {
        return productPriceInCart.getText();
    }
    public String getProductNameInCart()
    {
        return productNameInCart.getAttribute("textContent");
    }


}