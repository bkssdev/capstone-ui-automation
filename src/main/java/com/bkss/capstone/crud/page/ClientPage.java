package com.bkss.capstone.crud.page;

import com.bkss.capstone.crud.domain.Client;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientPage {
    private By clientName = By.id("name");
    private By clientEmail = By.id("email");
    private By goToAddClientLink = By.linkText("Add Client");
    private By createClient = By.name("addClient");
    private By newlyCreatedClient = By.xpath(".//*[@id='myTable']//td[contains(.,'Ola Tomoloju')]");
    private WebDriver driver;
    public ClientPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddClientButton(){
        driver.findElement(goToAddClientLink).click();
    }

    public String addClient(Client client){
        clickAddClientButton();
        //driver.findElement(clientName).sendKeys(client.getName());
        //driver.findElement(clientEmail).sendKeys(client.getEmail());
        driver.findElement(clientName).sendKeys("Ola Tomoloju");
        driver.findElement(clientEmail).sendKeys("ola@gmail.com");
        driver.findElement(createClient).click();
        return driver.findElement(newlyCreatedClient).getText();
    }

    public String editClient(Client client, String email){
        return null;
    }

    public String deleteClient(Client client, String email){
        return null;
    }
}
