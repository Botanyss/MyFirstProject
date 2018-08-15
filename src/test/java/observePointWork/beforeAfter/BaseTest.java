package observePointWork.beforeAfter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CreateWebJourneyWindow;
import pages.LoginPage;
import pages.MyCards;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;     //переменные класса резервируют имя
    public LoginPage loginPage;
    public CreateWebJourneyWindow createWebJourneyWindow;
    public MyCards myCards;

    @BeforeMethod
    public void setUp() {
       // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver();             //инициализируем обьект и передаем его в переменнуб класса по имени драйвера
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();



        driver.get("https://staging.observepoint.com/login");
        loginPage = new LoginPage(driver);        //создаем обьект класса и передаем в него драйвер
        myCards = new MyCards(driver);
        createWebJourneyWindow = new CreateWebJourneyWindow(driver);

        loginPage.login("a.pohribnyi", "lolikololik");
        loginPage.successLogin();
    }


    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
