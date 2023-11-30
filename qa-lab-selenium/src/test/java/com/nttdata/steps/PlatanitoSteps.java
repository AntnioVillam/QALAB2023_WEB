package com.nttdata.steps;


import com.nttdata.page.PlatanitoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PlatanitoSteps {
    private WebDriver driver;

    //constructor
    public PlatanitoSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(PlatanitoPage.userInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlatanitoPage.loginButton));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(PlatanitoPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(PlatanitoPage.loginButton).click();
    }

    public void seleccionarMenuCategorias() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlatanitoPage.menuOfertas));

        WebElement menuOfertas = driver.findElement(PlatanitoPage.menuOfertas);
        menuOfertas.click();

        try {
            Thread.sleep( 300);
        }catch (Exception e){

        }

    }
    public String getTitle(){
        return this.driver.findElement(PlatanitoPage.cuentaTitle).getText();
    }

    public void seleccionaProducto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement agregarOfertas = driver.findElement(PlatanitoPage.agregarOfertas);
        agregarOfertas.click();

    }

    public void seleccionaProductodelalista() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement agregarOfertasLista = driver.findElement(PlatanitoPage.agregarOfertasLista);
        agregarOfertasLista.click();
    }

    public void añadiralCarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement agregarCarrito = driver.findElement(PlatanitoPage.agregarCarrito);
        agregarCarrito.click();
    }

    public void carritodeCompras() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement carritodeCompras = driver.findElement(PlatanitoPage.carritodeCompras);
        carritodeCompras.click();
    }

    public void vercarrito() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement vercarrito = driver.findElement(PlatanitoPage.vercarrito);
        vercarrito.click();

    }
}
