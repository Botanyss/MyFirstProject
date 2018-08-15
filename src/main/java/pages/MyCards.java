package pages;


import com.sun.xml.internal.bind.v2.TODO;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class MyCards {

	WebDriver driver;


	public MyCards(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//div[@class='modal-content']//button[@type='button']")
	public WebElement webJourneyCreationSuccessModalCancelButton;


//	@FindBy (xpath="//div[@class='modal-content']")			     			                        public WebElement webJourneyCreationSuccessModalWindow;

	@FindBy (xpath="//div[contains(@class, 'options-wrap')]//span[text()='Web Audits']")
	public WebElement webAuditsFilterText;

    @FindBy(xpath="//button[@id='dropdownMenuMore']")
	public WebElement createNewButtonMyCards;

	@FindBy (id = "search")
	public WebElement searchField;

	@FindBy(xpath = "//div[@aria-labelledby='dropdownMenuMore']")
	public WebElement moreMenu;

	public void clickOnCreateNewButton() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(createNewButtonMyCards));
			createNewButtonMyCards.click();
		    wait.until(ExpectedConditions.visibilityOf(moreMenu));


	}

    public void selectWebJourneyCard() throws InterruptedException {


		WebElement webJourneyCard = driver.findElement(By.xpath("//div[@aria-labelledby='dropdownMenuMore']//span[contains(@class,'icon-web-journey')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", webJourneyCard);
	}

    public void closeSuccessModalWindow() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement webJourneyCreationSuccessModalWindow = driver.findElement(By.xpath(""));
//
//        wait.until(ExpectedConditions.visibilityOf(webJourneyCreationSuccessModalWindow));

        WebElement successHeader = driver.findElement(By.xpath("//div[@class='modal-content']//h1"));
        Assert.assertEquals("Success!", successHeader.getText());   // ToDO work with asserts testNgVsJunit;
        wait.until(ExpectedConditions.elementToBeClickable(webJourneyCreationSuccessModalCancelButton));

        webJourneyCreationSuccessModalCancelButton.click();
        //wait.until(ExpectedConditions.stalenessOf(webJourneyCreationSuccessModalWindow));                     //Ожидание удаления этого элемента

	}

    public boolean isCardVisible(String webJourneyName){

	    try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + webJourneyName + "']")));
			return true;
	    }
	    catch(TimeoutException e){
	    	return false;
		}

	}


	public void searchFromMyCards(String nameOfTheCard){
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(searchField));
		searchField.sendKeys(nameOfTheCard);

	}


}
