package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;



public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public ItemPage getOneRandomItemPage(){
        By oneRandomItem = By.xpath("(//a[@class='a-link-normal s-no-outline'])["+4+"]");
        WebElement item = new WebDriverWait(driver,MEDIUM_WAIT).until(ExpectedConditions.visibilityOfElementLocated(oneRandomItem));
        item.click();
        return new ItemPage(driver);

    }

}
