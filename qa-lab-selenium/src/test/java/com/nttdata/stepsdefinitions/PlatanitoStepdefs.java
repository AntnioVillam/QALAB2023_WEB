package com.nttdata.stepsdefinitions;


import com.nttdata.steps.PlatanitoSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlatanitoStepdefs {

    private WebDriver driver;
    private Scenario scenario;

    private PlatanitoSteps objPlatanitos;

    private PlatanitoSteps platanitoSteps(WebDriver driver){
        return new PlatanitoSteps(driver);
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
    @Before(order = 0)
    public void setUp(){
        //setUp
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        //crear el driver
        driver = new ChromeDriver();
        //max
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Dado("que me encuentro en la página de login de Platanitos")
    public void queMeEncuentroEnLaPáginaDeLoginDePlatanitos() {
        driver.get("https://platanitos.com/iniciar-sesion");
        screenShot();
    }
    @Cuando("inicio sesión con las credenciales correo electronico: {string} y contraseña: {string}")
    public void inicioSesiónConLasCredencialesCorreoElectronicoYContraseña(String user, String password) {
        PlatanitoSteps loginSteps = new PlatanitoSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }
    @Entonces("se valida que se muestre el titulo de {string}")
    public void seValidaQueSeMuestreElTituloDe(String expectedTitle) {
        String title =  platanitoSteps(driver).getTitle();
        Assertions.assertEquals(expectedTitle, title);
        screenShot();
    }
    @Y("hago clic en la categoria Ofertas")
    public void hagoClicEnLaCategoriaOfertas() {

        objPlatanitos = new PlatanitoSteps(driver);
        objPlatanitos.seleccionarMenuCategorias();
        screenShot();
    }
    @Y("hago clic a un producto que se muestra en Oferta")
    public void hagoClicAUnProductoQueSeMuestraEnOferta() {
        objPlatanitos.seleccionaProducto();
        screenShot();
        objPlatanitos.seleccionaProductodelalista();
        screenShot();
    }

    @Y("añado el producto al carrito")
    public void añadoElProductoAlCarrito() {
        objPlatanitos.añadiralCarrito();
        screenShot();

    }

    @Y("hago clic en el carrito")
    public void hagoClicEnElCarrito() {
        objPlatanitos.carritodeCompras();
        screenShot();
    }

    @Entonces("se verifica que el producto se haya agregado correctamente al carrito")
    public void seVerificaQueElProductoSeHayaAgregadoCorrectamenteAlCarrito() {
        objPlatanitos.vercarrito();
        screenShot();
    }



}
