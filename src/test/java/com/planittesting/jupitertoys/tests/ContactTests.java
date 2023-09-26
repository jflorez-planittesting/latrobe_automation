package com.planittesting.jupitertoys.tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.planittesting.jupitertoys.model.pages.ContactPage;
import com.planittesting.jupitertoys.model.pages.HomePage;

public class ContactTests extends BaseTest {
    
    // This annotation indicates to JUnit that this test will receive testdata as a parameter.
    @ParameterizedTest  
    // Every Parameterised test requires a data source. 
    // The simplest datasource is a ValueSource where a array of primitive types or strings and be sent to the test
    // Each element in the array becomes a new test as it is passed as a parameter to the test method
    // In this example the test will run twice, the first time it will pass the secon the assertion will fail
    @ValueSource(strings = {"Must be a valid email.", "Incorrect expected text"})
    public void validateEmailErrorParameterized(String expectedEmailErrorText) {
        var homePage = new HomePage(driver);
        homePage.clickContactMenu();
        var contactPage = new ContactPage(driver);
        contactPage.setEmail("jkjhasbdkjahs");
        var actualEmailErrorText = contactPage.getEmailError();
        assertEquals(expectedEmailErrorText, actualEmailErrorText);
    }

    // This is a simple first test without parameterized test data
    @Test
    public void validateEmailError() {
        var homePage = new HomePage(driver);
        homePage.clickContactMenu();
        var contactPage = new ContactPage(driver);
        contactPage.setEmail("jkjhasbdkjahs");
        var actualEmailErrorText = contactPage.getEmailError();
        assertEquals("Must be a valid email.", actualEmailErrorText);
    }
}
