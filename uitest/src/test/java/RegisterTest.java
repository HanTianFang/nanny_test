import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;


import java.util.concurrent.TimeUnit;

/**
 * Created by Deft on 2017/5/3.
 */
public class RegisterTest {
    private static final String BASE_URL = "http://localhost:8080/nanny/";
    private static WebDriver driver;

    @BeforeClass
    public static void openPage(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void registerSuccess() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("1@qq.com");
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

        Assert.assertEquals("您注册成功!",  driver.findElement(By.id("swal2-content")).getText());

    }

    @Test
    public void registerFail1() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("1");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(10000);
        Assert.assertEquals("Invalid email address",  driver.findElement(By.className("swal2-validationerror")).getText());

    }

    @Test
    public void registerFail2() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("2@qq.com");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(10000);
        Assert.assertEquals("用户已存在",  driver.findElement(By.className("swal2-validationerror")).getText());

    }

    @Test
    public void registerFail3() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(10000);
        Assert.assertEquals("Invalid email address",  driver.findElement(By.className("swal2-validationerror")).getText());

    }

    @Test
    public void registerFail4() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("1@qq.com");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.className("swal2-input"));
        password.sendKeys("2222222222");
        WebElement  button2 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button2.click();
        Thread.sleep(10000);
        Assert.assertEquals("重复输入您的密码",  driver.findElement(By.id("swal2-title")).getText());

    }

    @Test
    public void registerFail5() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("1@qq.com");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.className("swal2-input"));
        password.sendKeys("22222222222");
        WebElement  button2 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button2.click();
        Thread.sleep(10000);
        Assert.assertEquals("重复输入您的密码",  driver.findElement(By.id("swal2-title")).getText());

    }

    @Test
    public void registerFail6() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("1@qq.com");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.className("swal2-input"));
        password.sendKeys("");
        WebElement  button2 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button2.click();
        Thread.sleep(10000);
        Assert.assertEquals("输入不能为空",  driver.findElement(By.className("swal2-validationerror")).getText());

    }

    @Test
    public void registerFail7() throws InterruptedException {

        driver.get(BASE_URL + "/ToFindNanny.jsp");
        WebElement register = driver.findElement(By.cssSelector(".glyphicon.glyphicon-user"));
        register.click();
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.className("swal2-input"));
        email.sendKeys("1@qq.com");
        WebElement button1 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button1.click();
        Thread.sleep(3000);
        WebElement password = driver.findElement(By.className("swal2-input"));
        password.sendKeys("1");
        WebElement  button2 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button2.click();
        Thread.sleep(3000);
        WebElement repeatPassword = driver.findElement(By.className("swal2-input"));
        repeatPassword.sendKeys("2");
        WebElement button3 = driver.findElement(By.cssSelector(".swal2-confirm.swal2-styled"));
        button3.click();

        Thread.sleep(10000);
        Assert.assertEquals("两次输入不一样",  driver.findElement(By.className("swal2-validationerror")).getText());

    }

    @After
    public void closePage(){
        //driver.quit();
    }
}
