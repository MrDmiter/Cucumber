package pages;

import base.AbstractTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.YamlParser;

public class SignInPage extends AbstractPage {

    // Web Elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    private WebElement signInBtn;

    /**
     * Constructor
     *
     * @param testClass
     */
    public SignInPage(AbstractTest testClass) {
        super(testClass);
    }

    /**
     * Sign in to the account
     *
     * @return
     */
    public MyAccountPage signIn(String username, String password) {
        // Enter email
        testClass.waitElementToBeClickable(emailTextField);
        emailTextField.sendKeys(username);
        // Enter password
        testClass.waitElementToBeClickable(passTextField);
        passTextField.sendKeys(password);
        // Click on the sign in button
        testClass.waitElementToBeClickable(signInBtn);
        signInBtn.click();
        return new MyAccountPage(testClass);
    }
}
