package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	MyCards myCards;
	
	public LoginPage (WebDriver driver) {
	    this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='username']")        	public WebElement userNameField;
	@FindBy(xpath="//input[@id='password']")        	public WebElement userPasswordField;
	@FindBy(xpath="//button[@id='loginButton']")    	public WebElement sighInButton;

    public void login(String name, String password){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(userNameField));

        userNameField.clear();
        userNameField.sendKeys(name);
        userPasswordField.clear();
        userPasswordField.sendKeys(password);
        sighInButton.click();

    }

    public void successLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        myCards = new MyCards(driver);
        wait.until(ExpectedConditions.visibilityOf(myCards.webAuditsFilterText));
    }
}

