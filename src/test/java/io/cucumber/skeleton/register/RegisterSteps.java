package io.cucumber.skeleton.register;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterSteps {

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

    @Given("user is on the register site")
    public void userIsOnTheRegisterSite() {

        System.out.println("Inside Step - browser is open");
        driver.get("https://www.neobyte.es/inicio-sesion?create_account=1");

        WebElement we = driver.findElement(By.xpath("/html/body/main/section/div[2]/div/section/header/h1/span"));

        assertThat(we.getText()).contains("Crear");
    }


    @When("^user writes the form with (.*) and (.*) and (.*) and (.*) and (.*)$")
    public void userWritesTheFormWithNameAndLastnameAndEmailAndPassword(String name, String lastname, String email, String password, String date) {
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("birthday")).sendKeys(date);
    }

    @And("accepts client privacy")
    public void acceptsClientPrivacy() throws InterruptedException {
        driver.findElement(By.cssSelector("#ff_customer_privacy")).sendKeys(Keys.SPACE);
        driver.findElement(By.cssSelector("#ff_psgdpr")).sendKeys(Keys.SPACE);

        Thread.sleep(2000);
    }


    @And("clicks on register")
    public void clicksOnRegister() {
        driver.findElement(By.xpath("/html/body/main/section/div[2]/div/section/section/section/form/footer/button")).click();
    }

    @Then("gets an email already exists error message")
    public void getsAnEmailAlreadyExistsErrorMessage() {
        WebElement we = driver.findElement(By.xpath("/html/body/main/section/div[2]/div/section/section/section/form/section/div[4]/div[1]/div/ul/li"));

        assertThat(we.getText()).contains("La dirección de correo");

    }

    @Then("gets a format error message")
    public void getsAFormatErrorMessage() {
        WebElement we = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[2]/div[1]/div/ul/li"));

        assertThat(we.getText()).contains("Formato");

    }

    @Then("gets a date format error message")
    public void getsADateFormatErrorMessage() {

        WebElement we = driver.findElement(By.xpath("//*[@id=\"customer-form\"]/section/div[6]/div[1]/div/ul/li"));

        assertThat(we.getText()).contains("31/05/1970");
    }


}
