import org.junit.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Deft on 2017/4/15.
 */
public class LoginTest {
    private static final String BASE_URL = "http://192.168.31.159:8080/nanny/";
    private static WebDriver driver;

    @BeforeClass
    public static void openPage() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
        DesiredCapabilities ieDesiredcap = DesiredCapabilities.chrome();
//        ieDesiredcap.setBrowserName("firefox");
//        ieDesiredcap.setVersion("52");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), ieDesiredcap);
//       driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void loginSuccess() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("input_email"));
        email.sendKeys(new String[] { "2@qq.com" });
        WebElement password = driver.findElement(By.id("input_password"));
        password.getSize();
        password.sendKeys("2");
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(1000);

        Assert.assertEquals("欢迎登入!",  driver.findElement(By.id("swal2-content")).getText());

    }
    @Test
    public void loginFail1() throws InterruptedException {
        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("input_email"));
        email.sendKeys(new String[] { "2@qq.com" });
        WebElement password = driver.findElement(By.id("input_password"));
        password.getSize();
        password.sendKeys("1");
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("有错!",  driver.findElement(By.id("swal2-title")).getText());
    }

    @Test
    public void loginFail2() throws InterruptedException {
        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("input_email"));
        email.sendKeys(new String[] { "2@qq.com" });
        WebElement password = driver.findElement(By.id("input_password"));
        password.getSize();
        password.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("有错!",  driver.findElement(By.id("swal2-title")).getText());
    }

    @Test
    public void loginFail3() throws InterruptedException {
        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("input_email"));
        email.sendKeys(new String[] { "" });
        WebElement password = driver.findElement(By.id("input_password"));
        password.getSize();
        password.sendKeys("2");
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("有错!",  driver.findElement(By.id("swal2-title")).getText());
    }

    @Test
    public void loginFail4() throws InterruptedException {
        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        WebElement email = driver.findElement(By.id("input_email"));
        email.sendKeys(new String[] { "" });
        WebElement password = driver.findElement(By.id("input_password"));
        password.getSize();
        password.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(1000);
        Assert.assertEquals("有错!",  driver.findElement(By.id("swal2-title")).getText());
    }


    @After
    public void closePage(){
        //driver.quit();
    }
}
