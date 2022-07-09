package pages;

import fileReaders.jsonFile.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utilities.UIActions;

import java.io.IOException;

public class MyAccountPage {

    UIActions action ;
    String className;
    JsonReader reader = new JsonReader();
    String loc = null;


    public MyAccountPage(String className) {
        this.className = className;
        action = new UIActions(className);

    }

    public WomenPage clickOnWomen() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(2);
        By women = By.linkText(loc);
        action.clickOnElement(women);
        return new WomenPage(className);
        }

    public void clickOnSignOut() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(3);
        By signOut = By.linkText(loc);
        action.clickOnElement(signOut);
    }
}
