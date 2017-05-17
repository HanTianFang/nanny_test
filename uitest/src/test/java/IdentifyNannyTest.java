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
public class IdentifyNannyTest {
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
        Thread.sleep(6000);
        WebElement menuButton = driver.findElement(By.id("mm-menu-toggle"));
        menuButton.click();
        Thread.sleep(6000);
        WebElement nannyButton = driver.findElement(By.cssSelector(".md.md-favorite"));
        nannyButton.click();
        Thread.sleep(6000);
        WebElement toIdentifyButton = driver.findElement(By.id("identNanny"));
        toIdentifyButton.click();
    }

    @Test
    public void identifySuccess() throws InterruptedException {
        Thread.sleep(3000);
        WebElement city = driver.findElement(By.id("city2"));
        city.click();
        WebElement isLive = driver.findElement(By.id("isLive1"));
        isLive.click();
        WebElement skill1 = driver.findElement(By.id("yzc"));
        skill1.click();
        Thread.sleep(1000);
        WebElement yzcDescribe = driver.findElement(By.id("yzcDescribe"));
        yzcDescribe.sendKeys("我们仙女族都爱做饭");
        WebElement skill1Button = driver.findElement(By.id("yzcsubmit"));
        skill1Button.click();
        Thread.sleep(3000);
//        WebElement skill2 = driver.findElement(By.id("yec"));
//        skill2.click();
//        Thread.sleep(1000);
//        WebElement skill2Button = driver.findElement(By.id("yzcsubmit"));
//        skill2Button.click();
        WebElement workCondition = driver.findElement(By.id("workCondition"));
        Select selection1 = new Select(workCondition);
        selection1.selectByIndex(1);
        WebElement nannyEducation = driver.findElement(By.id("nannyEducation"));
        Select selection2 = new Select(nannyEducation);
        selection2.selectByIndex(1);
        WebElement nannySalary = driver.findElement(By.id("nannySalary"));
        nannySalary.sendKeys("1000");
        WebElement nannyRestTime = driver.findElement(By.id("nannyRestTime"));
        nannyRestTime.sendKeys("10");
        WebElement nation = driver.findElement(By.id("nation"));
        nation.sendKeys("仙女族");
        WebElement faith = driver.findElement(By.id("faith"));
        Select selection3 = new Select(faith);
        selection3.selectByIndex(1);
        WebElement maritalStatus = driver.findElement(By.id("maritalStatus"));
        Select selection4 = new Select(maritalStatus);
        selection4.selectByIndex(1);
        WebElement isChildLocal = driver.findElement(By.id("isChildLocal"));
        Select selection5 = new Select(isChildLocal);
        selection5.selectByIndex(1);
        WebElement isParentLocal = driver.findElement(By.id("isParentLocal"));
        Select selection6 = new Select(isParentLocal);
        selection6.selectByIndex(1);
        WebElement introduce = driver.findElement(By.id("introduce"));
        introduce.sendKeys("仙女就是我哈哈哈哈哈");
        WebElement remark = driver.findElement(By.id("remark"));
        remark.sendKeys("我就住在仙女屋来玩啊哈哈哈");
        WebElement identifyButton = driver.findElement(By.id("nannysubmit"));
        identifyButton.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        Assert.assertEquals("成功",  driver.switchTo().alert().getText());
    }
    @After
    public void closePage(){
        //driver.quit();
    }
}
