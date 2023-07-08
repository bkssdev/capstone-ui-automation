package com.bkss.capstone.crud.page;

import com.bkss.capstone.crud.domain.Client;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientPage {
    private final By clientName = By.id("name");
    private final By clientEmail = By.id("email");
    private final By goToAddClientLink = By.linkText("Add Client");
    private final By createClient = By.xpath("//button[normalize-space()='Save']");
    private final By editClient = By.xpath("//button[normalize-space()='Save']");
    private final By deleteClient = By.xpath("//button[normalize-space()='Delete']");

    private WebDriver driver;

    public ClientPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddClientButton() {
        driver.findElement(goToAddClientLink).click();
    }

    public String addClient(Client client) throws InterruptedException {
        clickAddClientButton();
        driver.findElement(clientName).sendKeys(client.getName());
        driver.findElement(clientEmail).sendKeys(client.getEmail());
        driver.findElement(createClient).click();
        synchronized (driver) {
            driver.wait(1000);
        }
        By newlyCreatedClient = By.xpath(".//*[@id='clientsTable']//td[contains(.,'" + client.getName() + "')]");
        return driver.findElement(newlyCreatedClient).getText();
    }

    public String editClient(Client client) throws InterruptedException {
      // TODO Implement the edit client logic
        return null;
    }

    public int deleteClient() throws InterruptedException {
        // TODO Implement the delete client logic
        return 0;
    }

    public int currentRowCount() {
        return driver.findElements(By.xpath("//table[@id='clientsTable']/tbody/tr")).size();
    }
}
