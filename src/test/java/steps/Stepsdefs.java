package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Stepsdefs  {


    WebDriver driver=null;

    @Given("^Login page is opened$")
    public void login_page_is_opened() throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();

        driver.navigate().to( new PropertyReader().getUrl("MyWebSiteUrl"));

    }
    @Then("^Enter valid  username(.+)$")
    public void enter_valid_username(String arg1) throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"edit-name\"]")).sendKeys(arg1.trim());
    }

    @Then("^Enter valid  password(.+)$")
    public void enter_valid_password(String arg1) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"edit-pass\"]")).sendKeys(arg1);
    }

    @Then("^Click login button$")
    public void click_login_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
    }

    @Then("^Button LogOut should be displayed$")
    public void button_LogOut_should_be_displayed() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"toolbar-item-user\"]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"toolbar-item-user-tray\"]/nav/ul/li[3]")).isDisplayed()
                ,true,"LogOut button is not displayed");
    }


    @Then("^Enter invalid  password (.+)$")
    public void enter_invalid_password_password(String arg1) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"edit-pass\"]")).sendKeys(arg1);
    }

    @Then("^Enter invalid  username (.+)$")
    public void enter_invalid_username_adminira(String arg1) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"edit-name\"]")).sendKeys(arg1.trim());
    }


    @Then("^Error message should be displayed$")
    public void error_message_should_be_displayed() throws Throwable {
        WebElement AlertElement= driver.findElement(
                By.xpath("//*[@id=\"page\"]/div[1]/aside/div/div[2]/div/div/div"));

        Assert.assertTrue(AlertElement.getText().contains("Unrecognized username or password. Forgot your password?"));
//        Assert.assertEquals(AlertElement.getText().replace("Error message","").trim(),"Unrecognized username or password. Forgot your password?");
    }

    @After
    public void afterEachScenario() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
        driver.quit();
    }




    @Then("^Click on button manage$")
    public void click_on_button_manage() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"toolbar-item-administration\"]")).click();
    }

    @Then("^Click on button people$")
    public void click_on_button_people() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"toolbar-link-entity-user-collection\"]")).click();
    }

    @Then("^Page people is opened$")
    public void page_people_is_opened() throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"block-seven-local-actions\"]/ul/li/a")).isDisplayed());
    }

    @Then("^Click on button add user$")
    public void click_on_button_add_user() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"block-seven-local-actions\"]/ul/li/a")).click();
    }

    @When("^Form for add new user is opened$")
    public void form_for_add_new_user_is_opened() throws Throwable {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"block-seven-page-title\"]/h1")).isDisplayed());
    }

    @Then("^Enter email address of user$")
    public void enter_email_address_of_user() throws Throwable {
        String newRandomEmail =
                RandomStringUtils.randomAlphabetic(5).toLowerCase()+"@gmail.com";
        driver.findElement(By.xpath("//*[@id=\"edit-mail\"]")).sendKeys(newRandomEmail);
    }

    @Then("^Enter username for new user$")
    public void enter_username_for_new_user() throws Throwable {
        String newRandomUsername =
                RandomStringUtils.randomAlphabetic(5).toLowerCase();
        driver.findElement(By.xpath("//*[@id=\"edit-name\"]")).sendKeys(newRandomUsername);
    }

    @Then("^Enter password for new user$")
    public void enter_password_for_new_user() throws Throwable {
        String newRandomPassword=
                RandomStringUtils.randomAlphabetic(5).toLowerCase()
                        +RandomStringUtils.randomNumeric(5);
        driver.findElement(By.xpath("//*[@id=\"edit-pass-pass1\"]")).sendKeys(newRandomPassword);
        driver.findElement(By.xpath("//*[@id=\"edit-pass-pass2\"]")).sendKeys(newRandomPassword);
    }

    @Then("^Click on button create new user$")
    public void click_on_button_create_new_user() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"edit-submit\"]")).click();
    }

    @Then("^Message that new user is add is displayed$")
    public void messageThatNewUserIsAddIsDisplayed() {
        Assert.assertTrue( driver.findElement(By.xpath("/html/body/div[2]/div/main/div[2]/div[2]/div[1]")).isDisplayed());
    }

//    @Given("^Youtube is opened$")
//    public void youtube_is_opened() throws Throwable {
//        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
//        driver=new ChromeDriver();
//        driver.navigate().to("https://www.youtube.com");
//    }
//
//    @Then("^Input search word$")
//    public void input_search_word() throws Throwable {
//        driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("Cats");
//    }
//
//    @Then("^Click search button$")
//    public void click_search_button() throws Throwable {
//        driver.findElement(By.xpath("//*[@id=\"search-icon-legacy\"]")).click();
//
//
//    }
//
//    @Then("^Opened first video$")
//    public void opened_first_video() throws Throwable {
//
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id=\"contents\"]/ytd-video-renderer[1]")));
//
//        driver.findElement(By.xpath("//*[@id=\"contents\"]/ytd-video-renderer[4]")).click();
//    }
//
//    @Then("^Video must be start$")
//    public void video_must_be_start() throws Throwable {
//
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"player\"]")));
//        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"player\"]")).isDisplayed()
//                ,true);
//
//    }
}
