package pages;

import fileReaders.jsonFile.JsonReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import utilities.UIActions;

import java.io.IOException;

public class WomenPage{

    UIActions action;
    String className;
    JsonReader reader = new JsonReader();
    String loc = null;


    public WomenPage(String className) {
        action = new UIActions(className);
        this.className = className;
    }

    public void clickProfile() throws IOException, ParseException {
        loc = reader.jsonReaderLocator(4);
        By profile = By.xpath(loc);
        action.clickOnElement(profile);
    }

}
