package com.bkss.capstone.crud;

import com.bkss.capstone.crud.domain.Client;
import com.bkss.capstone.crud.page.ClientPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ClientTest {
    private WebDriver driver;
    private ClientPage clientPage;
    private static final String URL = "http://localhost:3000";

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
        driver.findElement(By.linkText("Click Me!")).click();
        clientPage = new ClientPage(driver);
    }

    @Test
    public void viewClientListTest() throws InterruptedException {
        Assert.assertTrue(clientPage.currentRowCount() > 0);
    }

    @Test
    public void createClientTest() throws InterruptedException {
        Client newClient = new Client("Fname Lname", "fname@gmail.com");
        Assert.assertEquals(clientPage.addClient(newClient), newClient.getName());
    }

    @Test
    public void editClientTest() throws InterruptedException {
        Client editedClient = new Client("Edited Lname", "edited@gmail.com");
        Assert.assertEquals(clientPage.editClient(editedClient), editedClient.getName());
    }

    @Test
    public void deleteClientTest() throws InterruptedException {
        int currentRowsCount = clientPage.currentRowCount();
        Assert.assertEquals(clientPage.deleteClient(), currentRowsCount - 1);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
