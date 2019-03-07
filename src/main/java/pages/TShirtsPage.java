package pages;

import base.AbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TShirtsPage extends AbstractPage {

    // Web element
    @FindBy(xpath = "//div[@class='button-container']/a/span[contains(text(),'More')]")
    private WebElement product;

    @FindBy(xpath = "//div[@class='product-container']")
    private WebElement productContainer;

    /**
     * Constructor
     *
     * @param testClass
     */
    public TShirtsPage(AbstractTest testClass) {
        super(testClass);
    }

    private String PRODUCT_DETAILS_XPATH = "//h5[@itemprop='name']/a[contains(., '%s')]";

    /**
     * Find product by the its name and click on it
     *
     * @param nameOfProduct
     * @return entity of the product page
     */
    public ProductPage clickOnProduct(String nameOfProduct) {
        testClass
                .getDriver()
                .findElement(By.xpath(String.format(PRODUCT_DETAILS_XPATH, nameOfProduct)))
                .click();
        return new ProductPage(testClass);
    }
}
