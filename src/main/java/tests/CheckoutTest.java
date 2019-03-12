package tests;

import base.AbstractTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.*;

public class CheckoutTest extends AbstractTest {

    private HomePage homePage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private TShirtsPage tShirtsPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;

    // Open Site
    @Given("The user opens site sees Home Page")
    public void theUserOpensSiteSeesHomePage() {
        homePage = openSite();
        log("Opened Site");
    }

    // Proceed to signInPage
    @When("User click on sign in button")
    public void userClickOnSignInButton() {
        signInPage = homePage.signInClick();
        log("Entered the signIn page");
    }

    // Log in to the account
    @And("Enters username '([^\\\"]*)', password '([^\\\"]*)' and clicks on sign in")
    public void entersUsernamePasswordAndClicksOnSignIn(String username, String password) {
        myAccountPage = signInPage.signIn(username,password);
        log("Signed in into account");
    }

    // Verify that user is logged in
    @Then("User is logged in")
    public void userIsLoggedIn() {
        myAccountPage.verifyPresenceInTheAccount("Dmytro Terentyev");
    }

    // Choose T-shirts category in the main menu
    @When("Click on the T-Shirts page")
    public void clickOnTheTShirtsPage() {
        tShirtsPage = myAccountPage.clickOnTShirts();
        log("Entered t-shirts category");
    }

    // Enter the product page
    @And("Click on the needed product '([^\\\"]*)'")
    public void clickOnTheNeededProduct(String expectedTitle) {
        productPage = tShirtsPage.clickOnProduct(expectedTitle);
        log("Opened product");
    }

    // Check whether we on the right page comparing breadcrumbs
    @Then("Breadcrumbs should be '([^\\\"]*)'")
    public void verifyCorrectnessOfTheBreadCrumbs(String expectedBreadCrumbs) {
        productPage.verifyBreadCrumbs(expectedBreadCrumbs);
        log("Bread crumbs are verified");
    }

    // Add product to cart and proceed to checkout page
    @When("Add product to the cart and proceed to checkout")
    public void addProductToTheCartAndProceedToCheckout() {
        checkoutPage = productPage.addToCartAndProceedToCheckout();
        log("Added to cart");
    }

    // Verify whether the total price is changed depending on the amount of items in the cart
    @Then("Increase number of products in the cart and see total price is changed")
    public void increaseNumberOfProductsInTheCartAndSeeTotalPriceIsChanged() {
        checkoutPage.verifyTotalPriceDependingOnTheAmountOfProductInTheCart(3);
    }

    // Remove all items from the cart
    @When("Remove product from the cart")
    public void removeProductFromTheCart() {
        checkoutPage.removeFromCart();
    }

    // Verify that cart is empty
    @Then("Check the presence of the Cart is empty message")
    public void checkThePresenceOfTheCartIsEmptyMessage() {
        checkoutPage.verifyCartIsEmpty();
        log("Item successfully deleted");
    }

    // Close site
    @And("Close browser")
    public void closeBrowser() {
        closeSite();
        log("Site is closed");
    }
}
