package io.cucumber.skeleton.edituser;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EditUserSteps {

    // ------------ Driver Setup ------------
    WebDriver driver;
    @Before
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    // ------------ Test params ------------
    @Given("user is going to log in")
    public void userIsLoged() {
        driver.get("https://www.neobyte.es/inicio-sesion?back=my-account");
    }

    @And("user logs with username and password")
    public void userLogsWithUsernameAndPassword() {
        driver.findElement(By.name("email")).sendKeys("1460919@uab.cat");
        driver.findElement(By.name("password")).sendKeys("Prueba.1");
    }

    @And("user logs in")
    public void userClicksOnLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();
        Thread.sleep(2);
    }

    @And("user is on edit profile page")
    public void userIsOnEditProfilePage() {
        driver.get("https://www.neobyte.es/datos-personales");
        String title = driver.getTitle();

        assertThat(title).contains("Datos personales");
    }

    @When("user changes (.*), (.*), (.*), (.*) and (.*)$")
    public void userEntersData(String firstname, String lastname, String email, String birthdate, String password) {

        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstname);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastname);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);

        driver.findElement(By.name("birthday")).clear();
        driver.findElement(By.name("birthday")).sendKeys(birthdate);

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("user decides he is a Sr.")
    public void userIsSr() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[1]/span/input")).sendKeys(Keys.SPACE);
    }

    @And("user decides she is a Sra.")
    public void userIsSra() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[1]/div[1]/label[2]/span/input")).sendKeys(Keys.SPACE);
    }

    @And("user clicks on save")
    public void userClicksOnSave() throws InterruptedException {
        driver.findElement(By.cssSelector("#ff_customer_privacy")).sendKeys(Keys.SPACE);
        driver.findElement(By.cssSelector("#ff_psgdpr")).sendKeys(Keys.SPACE);
        driver.findElement(By.className("btn-primary")).sendKeys(Keys.SPACE);
        Thread.sleep(2);
    }

    @Then("user is navigated to the edit page updated")
    public void userIsNavigatedToTheEditPageUpdated() {
        String confirmation = driver.findElement(By.className("alert")).toString();
        assertThat(confirmation).contains("alert");
    }

    @Then("user still same page wihtout changes and alerts")
    public void userStillPagewithoutChanges() {
        String confirmation = driver.findElement(By.className("alert-danger")).toString();
        assertThat(confirmation).contains("alert-danger");
    }

    @Then("user still same page because danger notification")
    public void userStillPageNotValidFormat() {
        String confirmation = driver.findElement(By.className("alert-danger")).toString();
        assertThat(confirmation).contains("alert-danger");
    }
}

