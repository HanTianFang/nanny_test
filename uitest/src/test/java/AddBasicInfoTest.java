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
    public void loginFail1() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.id("basicsubmit"));
        loginButton.click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=notEmpty][data-fv-for=username]")));
        Thread.sleep(3000);
        Assert.assertEquals("请填写真实姓名，不能为空",  a.getText());
    }

    @Test
    public void loginFail2() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("聪明蛋");
        WebElement loginButton = driver.findElement(By.id("basicsubmit"));
        loginButton.click();
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=notEmpty][data-fv-for=IDnumber]")));
        Thread.sleep(3000);
        Assert.assertEquals("请填写身份证号，不能为空",  a.getText());
    }

    @Test
    public void loginFail3() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("聪明蛋");
        WebElement IDnumber = driver.findElement(By.id("IDnumber"));
        IDnumber.sendKeys("1231122211111111111111");
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=stringLength][data-fv-for=IDnumber]")));
        Thread.sleep(3000);
        Assert.assertEquals("超过输入长度",  a.getText());
    }

    @Test
    public void loginFail4() throws InterruptedException {
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
        city.sendKeys("ccdd");
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=regexp][data-fv-for=username]")));
        Thread.sleep(3000);
        Assert.assertEquals("请输入正确的城市",  a.getText());
    }

    @Test
    public void loginFail5() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("聪明蛋");
        WebElement IDnumber = driver.findElement(By.id("IDnumber"));
        IDnumber.sendKeys("123112221111111111");
        WebElement phone = driver.findElement(By.id("phone"));
        phone.sendKeys("1211111111111");
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=stringLength][data-fv-for=phone]")));
        Thread.sleep(3000);
        Assert.assertEquals("超过输入长度",  a.getText());
    }

    @Test
    public void loginFail6() throws InterruptedException {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("d");
        Thread.sleep(3000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=regexp][data-fv-for=username]")));
        Thread.sleep(3000);
        Assert.assertEquals("真实姓名填写错误，必须为中文",  a.getText());
    }

    @After
    public void closePage(){
        driver.quit();
    }
}
