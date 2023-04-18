package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl="https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        //1. Enter “Admin” username
        WebElement userName=driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        //Enter “admin123“ password
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        //Click on ‘LOGIN’ button
        WebElement loginButon=driver.findElement(By.xpath("//button"));
        loginButon.click();
        // Verify the ‘Dashboard’ text is display
        String expectedMessage="Dashboard";
        WebElement actualTextElement=driver.findElement(By.xpath("//h6"));
        String actualMessage=actualTextElement.getText();
        Assert.assertEquals("Dashboard not displayed",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
