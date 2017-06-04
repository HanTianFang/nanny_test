import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/**
 * Created by Deft on 2017/6/2.
 */
public class AddInfoTest {
    private static WebDriver driver;
    @Before
    public void openPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        registerSuccess();
    }

    public void registerSuccess() throws InterruptedException {

        driver.get(Settings.DOMAIN + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys(System.currentTimeMillis() + "@qq.com");
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
        WebElement button = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button.click();
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.click();
    }
    @Test
    public void addInfoSuccess() throws InterruptedException {
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("聪明蛋");
        WebElement IDnumber = driver.findElement(By.id("IDnumber"));
        IDnumber.sendKeys("123112221111111111");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("13111111111");
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
        //Assert.assertEquals("成功",  driver.switchTo().alert().getText());
    }

    @After
    public void closePage(){
        driver.quit();
    }
}
