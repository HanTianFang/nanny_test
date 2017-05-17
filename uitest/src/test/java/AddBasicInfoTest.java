import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


/**
 * Created by Deft on 2017/5/8.
 */
public class AddBasicInfoTest {
    private static final String BASE_URL = "http://localhost:8080/nanny/";
    private static WebDriver driver;

    @BeforeClass
    public static void openPage(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void login() throws InterruptedException{
        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("input_email"));
        email.sendKeys(new String[] { "3@qq.com" });
        WebElement password = driver.findElement(By.id("input_password"));
        password.sendKeys("3");
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement commitButton = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        commitButton.click();
        Thread.sleep(3000);
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.click();
    }
    @Test
    public void loginSuccess() throws InterruptedException {
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("聪明蛋");
        WebElement IDnumber = driver.findElement(By.id("IDnumber"));
        IDnumber.sendKeys("123112221111111111");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("12111111111");
        WebElement appellation = driver.findElement(By.id("appellation"));
        Select selection = new Select(appellation);
        selection.selectByIndex(1);
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("仙女星");
        WebElement residence = driver.findElement(By.id("residence"));
        residence.sendKeys("仙女屋");
        WebElement loginButton = driver.findElement(By.id("basicsubmit"));
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("成功",  driver.switchTo().alert().getText());
    }
    @After
    public void closePage(){
        //driver.quit();
    }
}
