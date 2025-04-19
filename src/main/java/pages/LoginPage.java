package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    // Localizadores de los elementos
    By userField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By titleProducts = By.className("title");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Método para ingresar credenciales
    public void ingresarCredenciales(String user, String pass) {
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
    }

    // Método para hacer clic en el botón de login
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Método para obtener el texto del título de la página
    public String obtenerTituloPagina() {
        return driver.findElement(titleProducts).getText();
    }

    // Método para verificar si el título de la página está visible
    public boolean estaTituloVisible() {
        WebElement title = driver.findElement(titleProducts);
        return title.isDisplayed();
    }
}


