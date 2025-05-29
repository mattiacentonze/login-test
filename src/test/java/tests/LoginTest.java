package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import POs.LoginFormPO;
import POs.LoginSuccessPO;

/**
 * Unit test for simple App.
 */
public class LoginTest extends DriverLifeCycle {

    private LoginFormPO login;
    private LoginSuccessPO loginSuccess;

    @Test
    public void testLoginOk() {
        login = new LoginFormPO(driver);
        login.with("user", "user");
        System.out.println(driver.getCurrentUrl());
        // we go to the login-success page
        loginSuccess = new LoginSuccessPO(driver);
        assertTrue(loginSuccess.successBoxIsPresent());
    }

    @Test
    public void testLoginNotOk() {
        login = new LoginFormPO(driver);
        login.with("user", "error");
        System.out.println(driver.getCurrentUrl());
        // we remain in the login page
        assertTrue(login.invalidBoxisPresent());
    }

    @Test
    public void testLoginWithEmptyFields() {
        login = new LoginFormPO(driver);
        login.with("", "");
        System.out.println(driver.getCurrentUrl());
        // we remain in the login page
        assertTrue(login.invalidBoxisPresent());
    }

    @Test
    public void testLoginWithOnlyUsername() {
        login = new LoginFormPO(driver);
        login.with("user", "");
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(login.invalidBoxisPresent(),
                "Expected invalid login warning when only username is entered");
    }

    @Test
    public void testLoginWithOnlyPassword() {
        login = new LoginFormPO(driver);
        login.with("", "user");
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(login.invalidBoxisPresent(),
                "Expected invalid login warning when only password is entered");
    }

    @Test
    public void testLoginWithLongCredentials() {
        login = new LoginFormPO(driver);
        String longUsername = "user".repeat(50);
        String longPassword = "pass".repeat(50);
        login.with(longUsername, longPassword);
        System.out.println(driver.getCurrentUrl());
        Assertions.assertTrue(login.invalidBoxisPresent(),
                "Expected invalid login warning with overly long credentials");
    }
}
