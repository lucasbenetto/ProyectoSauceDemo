
package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import utils.BaseTest;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        driver = BaseTest.getDriver(); // Asegurás que el driver ya está listo
        loginPage = new LoginPage(driver);
    }

    @Given("el usuario está en la página de login de SauceDemo")
    public void el_usuario_esta_en_la_pagina_de_login_de_SauceDemo() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("ingresa el usuario {string} y la contraseña {string}")
    public void ingresa_usuario_y_contraseña(String username, String password) {
        loginPage.ingresarCredenciales(username, password);
    }

    @And("hace clic en el botón de login")
    public void hace_clic_en_el_boton_de_login() {
        loginPage.clickLogin();
    }

    @Then("debería ver la página de productos")
    public void deberia_ver_la_pagina_de_productos() {
        Assert.assertTrue("El título no está visible", loginPage.estaTituloVisible());
        Assert.assertEquals("Products", loginPage.obtenerTituloPagina());
    }
}
