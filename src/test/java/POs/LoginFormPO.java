package POs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPO {
    private WebDriver driver;
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By button = By.tagName("button");
    private By invalid = By.id("invalid");

    public LoginFormPO(WebDriver driver) {
        this.driver = driver;
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    public void with(String username, String pwd) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(pwd);
        driver.findElement(button).click();
    }

    public boolean invalidBoxisPresent() {
        return driver.findElement(invalid).isDisplayed();
    }
}
