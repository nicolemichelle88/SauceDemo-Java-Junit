package com.yourcompany.Tests;

import com.yourcompany.Pages.*;
import org.junit.Test;
import org.openqa.selenium.InvalidElementStateException;
import java.util.concurrent.TimeUnit;


import static org.junit.Assert.*;

public class LoginTest extends TestBase {

    public LoginTest(String os,
                          String version, String browser, String deviceName, String deviceOrientation) {
            super(os, version, browser, deviceName, deviceOrientation);
    }

    /**
     * Runs a simple test verifying link can be followed.
     * @throws InvalidElementStateException
     */
    @Test
    public void LoginTest() throws InvalidElementStateException {
        SauceDemoPage page = SauceDemoPage.visitPage(driver);
        page.inputUsername("standard_user");
        page.inputPassword("secret_sauce");

        page.clickSubmit();

        page.openMenu();

        page.followLink();

        assertTrue(page.isOnPage());
    }
}
