package io.cucumber.skeleton.search;

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


public class SearchSteps {
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

    @Given("user is on the main page")
    public void userIsOnTheMainPage() {

        driver.get("https://www.neobyte.es/");

        driver.manage().window().fullscreen();
        String tittle = driver.getTitle();

        assertThat(tittle).contains("Tienda de informática y gaming online - Neobyte");
    }

    @When("^user (.*) in search field$")
    public void userInputInSearchField(String input) {
        driver.findElement(By.name("s")).sendKeys(input);
    }

    @And("user clicks on search button")
    public void userClicksOnSearchButton() {
        driver.findElement(By.xpath("//*[@id=\"search_widget\"]/form/div[1]/button")).click();
    }

    @Then("user is navigated to the search result page")
    public void userIsNavigatedToTheSearchResultPage() {
        assertThat(driver.getCurrentUrl()).contains("buscador");
    }

    @And("user press ENTER")
    public void userPressENTER() {
        driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
    }
}
