package pages;

import fileReaders.jsonFile.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utilities.UIActions;

import java.io.IOException;


public class RegisterationPage {

    UIActions action ;
    String className;
    JsonReader reader = new JsonReader();
    String loc = null;

    public RegisterationPage(String className) {
        this.className = className;
        action = new UIActions(className);

    }

    public void selectGender() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(10);
        By radioButtonGender = By.id(loc);
        action.waitForPageLoad(radioButtonGender, 60);
        action.clickOnElement(radioButtonGender);
    }

    public void enterFirstName(String firstName) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(11);
        By first_name = By.id(loc);
        action.enterTextInTextField(firstName,first_name);
    }

    public void enterLastName(String lastName) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(12);
        By last_name = By.id(loc);
        action.enterTextInTextField(lastName,last_name);
    }

    public void enterPassword(String passwd) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(13);
        By password = By.id(loc);
        action.enterTextInTextField(passwd,password);
    }


    public void selectDayFromDropdown(String option) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(14);
        By dayDateOfBirth = By.id(loc);
        action.selectFromDropdownList(option,dayDateOfBirth);
    }
    public void selectMonthFromDropdown(String option) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(15);
        By monthDateOfBirth = By.id(loc);
        action.selectFromDropdownList(option,monthDateOfBirth);
    }

    public void selectYearFromDropdown(String option) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(16);
        By yearDateOfBirth = By.id(loc);
        action.selectFromDropdownList(option,yearDateOfBirth);
    }

    public void enterAddress(String adress) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(17);
        By address = By.id(loc);
        action.enterTextInTextField(adress,address);
    }

    public void enterCity(String cityy) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(18);
        By city = By.id(loc);
        action.enterTextInTextField(cityy,city);
    }

    public void selectStateFromDropdown(String option) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(19);
        By state = By.id(loc);
        action.selectFromDropdownList(option,state);
    }

    public void enterPostalCode(String code) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(20);
        By postalCode = By.id(loc);
        action.enterTextInTextField(code,postalCode);
    }


    public void enterMobileNumber(String mobile) throws IOException, ParseException {
        loc = reader.jsonReaderLocator(21);
        By mobileNumber = By.id(loc);
        action.enterTextInTextField(mobile,mobileNumber);
    }
    public MyAccountPage clickRegister() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(22);
        By register = By.id(loc);
        action.clickOnElement(register);
        return new MyAccountPage(className);
    }

}