package io.cucumber.skeleton.shoppingcart;

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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartSteps {
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

    @Given("user is on products page")
    public void userIsOnProductsPage() {
        driver.get("https://www.neobyte.es/procesadores-107");

        assertThat(driver.getCurrentUrl()).contains("procesadores");
    }

    @And("user accept cookies")
    public void userAcceptCookies() {
        driver.findElement(By.id("iqitcookielaw-accept")).click();
    }

    @And("clicks on first product")
    public void clicksOnFirstProduct() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.className("add-to-cart")).click();
    }

    @And("verify product in the shopping cart")
    public void verifyProductInTheShoppingCart() throws InterruptedException {
        Thread.sleep(2000);
        assertThat(driver.findElement(By.className("mb-2")).getText()).isEqualTo("Finalizar compra");

    }

    @And("user is on the shopping cart page")
    public void userIsOnTheShoppingCartPage() throws InterruptedException {
        Thread.sleep(2000);

        driver.get("https://www.neobyte.es/carrito?action=show");
        assertThat(driver.getCurrentUrl()).contains("carrito");
    }

    @And("user wants to buy two units of the product")
    public void userWantsTwoUnits() {
            driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/ul/li[2]/div/div[2]/div/div[2]/div/span[3]/button[1]")).click();
    }

    @When("user press delete button")
    public void userPressDeleteButton()  {
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/ul/li[2]/div/div[2]/div/div[4]/div/a/i")).click();
    }

    @Then("product is no longer in shopping cart")
    public void productIsNoLongerInShoppingCart() throws InterruptedException {
        Thread.sleep(2000);

        assertThat(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/div")).getText()).isEqualTo("No hay más artículos en su carrito");
    }

    @When("user press end buy")
    public void userPressEndBuy() {
        driver.findElement(By.className("mb-2")).click();
    }

    @Then("user is redirected to payment process")
    public void userIsRedirectedToPaymentProcess() {
        assertThat(driver.getCurrentUrl()).contains("pedido");
    }

    @Then("user has many units")
    public void userHasManyUnits() {
        assertThat(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/div/div/ul/li[2]/div/div[2]/div/div[2]/div/input")).getAttribute("value")).contains("2");
    }
}
