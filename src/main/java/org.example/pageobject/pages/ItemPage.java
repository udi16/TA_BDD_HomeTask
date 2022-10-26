package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String getItemShippmentLocation(){
        WebElement deliveryLocationLabel = new WebDriverWait(driver, SHORT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format("//span[@id='glow-ingress-line2']"))));
        return deliveryLocationLabel.getText();
    }
}