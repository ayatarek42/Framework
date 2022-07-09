package pages;

import fileReaders.jsonFile.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import fileReaders.propertiesFile.ReadProperty;
import utilities.UIActions;

import java.io.IOException;


public class HomePage {
    UIActions action;
    String className;
    JsonReader  reader = new JsonReader();
    String loc = null;


    public HomePage(String className) {
        this.className = className;
        action = new UIActions(className);
    }

    public void navigateToHome(){
        String homepageURL = ReadProperty.URLData.getProperty("URL");
        action.navigateTo(homepageURL);
    }

    public SignIn clickOnSignIn() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(0);
        By signIn = new By.ByCssSelector(loc);
        action.clickOnElement(signIn);
        return new SignIn(className);
    }


    public Dresses clickOnDresses() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(1);
        By dressesBtn = By.xpath(loc);
        action.clickOnElement(dressesBtn);
        return new Dresses();
    }
}
