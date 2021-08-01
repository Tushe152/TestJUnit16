package Tests;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import units.Log;
import units.Driver;
import org.apache.log4j.Logger;




@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAddress {
    private WebDriver driver = Driver.getChromeDriver();
@BeforeAll
    public void startUp() {
    Log.info("--Open page testaddressbook.com--");
    driver.get("http://a.testaddressbook.com/");
    Log.info("--Check if the page title is correct--");
    String pageTitle = driver.getTitle();
    Assertions.assertEquals("Address Book",pageTitle,"--Title or URL is incorrect!!!--");
    Log.info("--Log In--");
    driver.findElement(By.id("sign-in")).click();
    driver.findElement(By.name("session[email]")).sendKeys("Testmail@gmail.com");
    driver.findElement(By.name("session[password]")).sendKeys("TestPassword");
    driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
}
@BeforeEach
    public void beforeEachCounter(){
    int i=1;
    Log.info("----Test #"+ i+" ----");
    i++;
}
@Test
@Order(1)
@DisplayName("Add Address Test")
public void addAddressTest() {
    driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[2]")).click();
    driver.findElement(By.xpath("/html/body/div/a")).click();
    Log.info("Enter the fields");
    driver.findElement(By.name("address[first_name]")).sendKeys("Max");
    driver.findElement(By.name("address[last_name]")).sendKeys("Zax");
    driver.findElement(By.name("address[address1]")).sendKeys("Mazurska");
    driver.findElement(By.name("address[address2]")).sendKeys("31");
    driver.findElement(By.name("address[city]")).sendKeys("Szczecin");
    driver.findElement(By.id("address_zip_code")).sendKeys("71-030");
    driver.findElement(By.id("address_country_us")).click();
    driver.findElement(By.name("address[birthday]")).sendKeys("14121995");
    driver.findElement(By.name("address[age]")).sendKeys("25");
    driver.findElement(By.name("address[website]")).sendKeys("http://a.testaddressbook.com/addresses/new");
    driver.findElement(By.name("address[phone]")).sendKeys("9369992");
    driver.findElement(By.id("address_interest_read")).click();
    driver.findElement(By.name("address[note]")).sendKeys("MyTestAdress");
    driver.findElement(By.name("commit")).click();

//    Log.info("check if Adress is added");
//    String successMessage = driver.findElement(By.xpath("/html/body/div/div1[1]")).getText();
//    Assertions.assertEquals("Address was successfully created",successMessage,"Address was not added");
}
@Test
@Order(2)
@DisplayName("Edit Address Test")
public void editAddressTest() {
    driver.findElement(By.xpath("/html/body/div/div[2]/a[1]")).click();
    driver.findElement(By.xpath("//*[@id=\"address_note\"]")).sendKeys("Edited adress");
    driver.findElement(By.name("commit")).click();

}
@Test
@Order(3)
@DisplayName("Destroy Address Test")
public void destroyAddressTest() {
    driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[2]")).click();
    driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[7]/a")).click();
    driver.switchTo().alert().accept();
}


@AfterAll
    public void browserShutDown() {
    Log.info("Log out");
    driver.findElement(By.xpath("//*[@id=\"navbar\"]/div[1]/a[3]")).click();
    Log.info("Browser shut down");
    driver.quit();
}
}
