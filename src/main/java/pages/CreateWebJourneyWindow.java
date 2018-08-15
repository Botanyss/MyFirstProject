package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateWebJourneyWindow {

	WebDriver driver;    //переменная класса

	public CreateWebJourneyWindow (WebDriver driver) {      //конструктор класса
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='journey-name']") 														public WebElement inputWebJourneyNameCreateJourneyWindow;

	@FindBy(xpath="//input[@id='journey-name']") 														public WebElement insertJourneyNameWebJourneyCreationWindow;

	@FindBy(xpath="//span[@for='folder']//span")            	                                        public WebElement createdFolderButtonWebJourneyCreationWindow;

	@FindBy(xpath="//input[contains(@class,'italic-placeholder')]")     	                            public WebElement insertFolderNameFieldWebJourneyCreationWindow;

	@FindBy(xpath="//input[@name='newDomain']")                         	                            public WebElement insertDomainNameFieldWebJourneyCreationWindow;

	@FindBy(xpath="//button[@class='ng-scope btn btn-outline-primary']")	                            public WebElement continueButtonWebJourneyCreationWindow;


	@FindBy(xpath="//button[@class='ng-scope btn btn-outline-primary']//span[text()='Continue']")   	public WebElement continueButtonWebJourneyJourneyRules;

	@FindBy(xpath="//button[@class='ng-scope btn btn-primary']")        	                            public WebElement saveJourneyButtonActionTab;

	public void feelAllMandatoryFieldsCreateNewWebJourney (String insertName, String insertFolderName,
														   String insertDomainName ) throws InterruptedException {

		insertJourneyNameWebJourneyCreationWindow.sendKeys(insertName);
		createdFolderButtonWebJourneyCreationWindow.click();
		//надо проверить что форма переключилась

		insertFolderNameFieldWebJourneyCreationWindow.sendKeys(insertFolderName);
//		Thread.sleep(1500);
		insertDomainNameFieldWebJourneyCreationWindow.sendKeys(insertDomainName);
//		Thread.sleep(1500);
		continueButtonWebJourneyCreationWindow.click();

		continueButtonWebJourneyJourneyRules.click();

		saveJourneyButtonActionTab.click();



	}

    public void pageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement content = driver.findElement(By.xpath("//div[@class='modal-content']"));
        wait.until(ExpectedConditions.visibilityOf(content));
	}
}
