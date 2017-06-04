import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Deft on 2017/6/3.
 */
public class test {
    private static WebDriver driver;

    @BeforeClass
    public static void openPage() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void a () throws InterruptedException {
        driver.get(Settings.DOMAIN + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        String user = System.currentTimeMillis() + "@qq.com";
        email.sendKeys(user);
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.className("swal2-input"));
        password.sendKeys("1");
        WebElement  button2 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button2.click();
        Thread.sleep(3000);
        WebElement repeatPassword = driver.findElement(By.className("swal2-input"));
        repeatPassword.sendKeys("1");
        WebElement button3 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button3.click();
        Thread.sleep(1000);
        WebElement button5 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button5.click();
        Thread.sleep(1000);
        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();
        Thread.sleep(1000);
        WebElement button4 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button4.click();
        Thread.sleep(1000);
        WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
        login.click();
        Thread.sleep(3000);
        WebElement email1 = driver.findElement(By.id("input_email"));
        email1.sendKeys( user);
        Thread.sleep(3000);
        WebElement password1 = driver.findElement(By.id("input_password"));
        password1.sendKeys("1");
        Thread.sleep(8000);
        WebElement loginButton = driver.findElement(By.id("loginIn"));
        loginButton.click();
        Thread.sleep(8000);
        Assert.assertEquals("登入成功！",  driver.findElement(By.id("swal2-content")).getText());
    }

    @After
    public void closePage() throws InterruptedException {
        driver.quit();
    }
}
