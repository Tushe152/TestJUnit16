package units;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
  private static WebDriver driver;
  private static void initChromeDriver(){
    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
  }
  public static WebDriver getChromeDriver(){
    initChromeDriver();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return driver;
  }
}
