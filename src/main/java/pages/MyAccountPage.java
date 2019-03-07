package pages;

import base.AbstractTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

    //Web element
    @FindBy(xpath = "//a[@class='account']")
    private WebElement userName;

    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccountPage(AbstractTest testClass) {
        super(testClass);
    }

    public void verifyPresenceInTheAccount(String accountName) {
        testClass.waitElementToBeVisible(userName);
        Assert.assertEquals("Wrong account", accountName, userName.getText());
    }

}
