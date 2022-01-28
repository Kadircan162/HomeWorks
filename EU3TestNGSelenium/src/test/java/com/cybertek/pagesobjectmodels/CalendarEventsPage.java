package com.cybertek.pagesobjectmodels;

import com.cybertek.utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarEventsPage extends BasePage {

    public CalendarEventsPage() {
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//div[contains(text(), 'Options')]")
    public WebElement optionsSubtitle;

    @FindBy(css = "input[type='number'][value]")
    public WebElement pageNumber;

    @FindBy(css = "[class*='btn dropdown-toggle']")
    public WebElement perPageNumber;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement recordNumber;

    @FindBy(css = "i.fa-chevron-right.hide-text")
    public WebElement nextPageArrow;

    @FindBy(xpath = "//*[@class='grid-header']//*[@type='checkbox']")
    public WebElement checkAllBtn;

    @FindBy(css = "[data-role='select-row-cell']")
    public List<WebElement> eventList;

    @FindBy(css = "[data-column-label='Title']")
    public List<WebElement> titleList;

    @FindBy(xpath = "//label[@class='control-label']")
    public List<WebElement> labelList;

    @FindBy(xpath = "//*[@class='pagination pagination-centered']//label[2]")
    public WebElement numberOfPageSetText;


    public Map<String, String> getLabelDescriptionTable(){

        List<WebElement> descriptionList = new ArrayList<>();

        for(int i=0; i<labelList.size(); i++){
            descriptionList.add(DriverSetup.getDriver().findElement(By.xpath("(//div[@class='controls'])[" + (i+1) + "]/div")));
        }

        Map<String,String> labelDescription = new HashMap<>();

        for (int i=0; i<labelList.size(); i++) {
            labelDescription.put(labelList.get(i).getText(), descriptionList.get(i).getText());
        }

       return labelDescription;

    }



}
