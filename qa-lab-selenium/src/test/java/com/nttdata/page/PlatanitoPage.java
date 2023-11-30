package com.nttdata.page;

import org.openqa.selenium.By;

public class PlatanitoPage {
    public static By userInput = By.id("email");
    public static By passInput = By.id("password");
    public static By loginButton = By.id("btn_submit");

    public static By cuentaTitle = By.xpath("//h1[contains(text(),'Cuenta')]");
    public static By menuOfertas = By.xpath("//a[@class=\"cursor-pointer item-menu\"]");
    public static By agregarOfertas = By.xpath("//body/div[@id=\"body-Ofertas\"][1]");
    public static By agregarOfertasLista = By.xpath("//body/div[@id=\"body-productos\"]/div[4]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/section[1]/img[1]");
    public static By agregarCarrito = By.xpath("//button[@id='btn_add_cart_full']");

    public static By carritodeCompras = By.xpath("//a[@id='IconCar']");

    public static By vercarrito = By.xpath("//a[@id='IconCar']");

}
