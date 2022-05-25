package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.UIActions;

import java.util.List;
import java.util.stream.Collectors;


public class RegisterationPage {

    protected By radioButtonGender = By.id("id_gender2");
    protected By first_name = By.id("customer_firstname");
    protected By last_name = By.id("customer_lastname");
    protected By password = By.id("passwd");
    protected By dayDateOfBirth = By.id("days");
    protected By monthDateOfBirth = By.id("months");
    protected By yearDateOfBirth = By.id("years");
    protected By address = By.id("address1");
    protected By city = By.id("city");
    protected By state = By.id("id_state");
    protected By postalCode = By.id("postcode");
    protected By country = By.id("id_country");
    protected By mobileNumber = By.id("phone_mobile");
    protected By register = By.id("submitAccount");
    UIActions action ;
    String className;

    public RegisterationPage(String className) {
        this.className = className;
        action = new UIActions(className);

    }

    public void selectGender() {
       action.waitForPageLoad(radioButtonGender, 60);
       action.clickOnElement(radioButtonGender);
    }

    public void enterFirstName(String firstName) {
        action.enterTextInTextField(firstName,first_name);
    }

    public void enterLastName(String lastName) {
        action.enterTextInTextField(lastName,last_name);
    }

    public void enterPassword(String passwd) {
        action.enterTextInTextField(passwd,password);
    }


    public void selectDayFromDropdown(String option) {
        action.selectFromDropdownList(option,dayDateOfBirth);
    }


    public void selectMonthFromDropdown(String option) {
        action.selectFromDropdownList(option,monthDateOfBirth);
    }

    public void selectYearFromDropdown(String option) {
        action.selectFromDropdownList(option,yearDateOfBirth);
    }

    public void enterAddress(String adress) {
        action.enterTextInTextField(adress,address);
    }
    public void enterCity(String cityy) {
        action.enterTextInTextField(cityy,city);
    }

    public void selectStateFromDropdown(String option) {
        action.selectFromDropdownList(option,state);
    }
    public void enterPostalCode(String code) {
        action.enterTextInTextField(code,postalCode);
    }

    public void selectCountryFromDropdown(String option) {
        action.selectFromDropdownList(option,country);
    }
    public void enterMobileNumber(String mobile) {
        action.enterTextInTextField(mobile,mobileNumber);
    }
    public MyAccountPage clickRegister(){
        action.clickOnElement(register);
        return new MyAccountPage(className);
    }

    public List<String> getSelectedDropdownOptions(By by) {
        List<WebElement> selectedElements = new Select(action.findWebElement(by)).getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}