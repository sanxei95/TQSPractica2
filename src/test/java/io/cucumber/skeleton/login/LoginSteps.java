package io.cucumber.skeleton.login;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {
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

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.neobyte.es/inicio-sesion?back=my-account");
        String tittle = driver.getTitle();

        assertThat(tittle).contains("Iniciar sesión");
    }

    @When("^user enters (.*) and (.*)$")
    public void userEntersUsernameAndPassword(String username, String password) {

        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @And("user clicks on login")
    public void userClicksOnLogin() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"submit-login\"]")).click();
        Thread.sleep(2);
    }


    @Then("user is navigated to the home page")
    public void userIsNavigatedToTheHomePage() {

        driver.findElement(By.xpath("//*[@id=\"identity-link\"]")).click();

        assertThat(driver.getCurrentUrl()).contains("datos-personales");
    }

    @Then("user doesn't log")
    public void userDoesnTLog() {
        System.out.println("Inside Step - user doesn't log");

        String error = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/ul/li")).getText();

        assertThat(error).contains("Error");
    }

}
