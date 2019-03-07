package pages;

import base.AbstractTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadCrumbs;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCart;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckout;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(AbstractTest testClass) {
        super(testClass);
    }

    /**
     * Verify breadcrumbs
     *
     * @param expectedBreadCrumbs
     */
    public void verifyBreadCrumbs(String expectedBreadCrumbs) {
        testClass.waitElementToBeVisible(breadCrumbs);
        Assert.assertEquals(expectedBreadCrumbs, breadCrumbs.getText());
    }

    /**
     * Add product to the cart and proceed to checkout
     *
     * @return entity of the CheckoutPage
     */
    public CheckoutPage addToCartAndProceedToCheckout() {
        testClass.waitElementToBeClickable(addToCart);
        addToCart.click();
        testClass.waitElementToBeClickable(proceedToCheckout);
        proceedToCheckout.click();
        return new CheckoutPage(testClass);
    }
}
