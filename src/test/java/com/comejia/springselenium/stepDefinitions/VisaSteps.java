package com.comejia.springselenium.stepDefinitions;

import com.comejia.springselenium.kelvin.annotation.LazyAutowired;
import com.comejia.springselenium.pages.visa.VisaRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@SpringBootTest
public class VisaSteps {

    @LazyAutowired
    private VisaRegistrationPage registrationPage;

    @Given("I am on VISA registration form")
    public void launchSite() {
        this.registrationPage.goTo();
        assertTrue(this.registrationPage.isAt());
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        this.registrationPage.setCountryFromAndTo(from, to);
    }

    @And("I enter my dob as {string}")
    public void enterDob(String dob) {
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln) {
        this.registrationPage.setNames(fn, ln);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        this.registrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComment(String comment) {
        this.registrationPage.setComments(comment);
    }

    @And("I submit the form")
    public void submit() {
        this.registrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void iShouldSeeGetTheConfirmationNumber() {
        //boolean isEmpty = StringUtils.isEmpty(this.registrationPage.getConfirmationNumber().isEmpty());
        assertFalse(this.registrationPage.getConfirmationNumber().isEmpty());
    }
}