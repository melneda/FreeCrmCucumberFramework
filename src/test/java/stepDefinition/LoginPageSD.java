package stepDefinition;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtil;
public class LoginPageSD {
    WebDriver driver;
    ElementUtil elementUtil;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        elementUtil = new ElementUtil(driver);
    }
    @Given("^user is already on Home Page$")
    public void goToURL(){
        driver.get("https://freecrm.com/index.html");
    }
    @When("^title of home page is Free CRM$")
    public void verifyTitle(){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.titleContains("large or small"));
        String title = elementUtil.doGetPageTitle();
        System.out.println("The title of the webpage" + title);
        Assert.assertEquals("Free CRM software can boost your sales by 30%", title);
    }
    @And("^user clicks on login button$")
    public void clickLoginBtn(){
        //elementUtil.doClick(By.xpath("//a//span[text()='Log In']"));
        elementUtil.doClick(By.linkText("Log In"));
    }
    @And("^user enters \"(.*)\" and \"(.*)\"$")
    public void userEnterUsernamePassword(String username, String password){
        elementUtil.doSendKeys(By.name("email"), username);
        elementUtil.doSendKeys(By.name("password"), password);
        elementUtil.doClick(By.className("submit"));
    }
    @Then("^user verify invalid login message on login page$")
    public void verifyInvalidLogin(){
        elementUtil.waitForElementVisible(By.xpath("//div//p[text()='Invalid login']"));
        String errorMessage = elementUtil.doGetText(By.xpath("//div//p[text()='Invalid login']"));
        System.out.println("Invalid login message :: " + errorMessage);
        Assert.assertEquals(errorMessage, "Invalid login");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}