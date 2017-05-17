import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

    /**
     * Created by Deft on 2017/5/9.
     */
    public class IdentifyEmployerTest {
        private static final String BASE_URL = "http://localhost:8080/nanny/";
        private static WebDriver driver;

        @BeforeClass
        public static void openPage(){
            System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Before
        public void login() throws InterruptedException{
            driver.get(BASE_URL + "/ToFindNanny.jsp");
            WebElement login = driver.findElement(By.cssSelector(".glyphicon.glyphicon-log-in.theme-login"));
            login.click();
            Thread.sleep(3000);
            WebElement email = driver.findElement(By.id("input_email"));
            email.sendKeys(new String[] { "2@qq.com" });
            WebElement password = driver.findElement(By.id("input_password"));
            password.sendKeys("2");
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
            WebElement nannyButton = driver.findElement(By.cssSelector(".md.md-settings"));
            nannyButton.click();

        }

        @Test
        public void identifySuccess() throws InterruptedException {
            Thread.sleep(3000);
            WebElement workPlace = driver.findElement(By.id("workPlace"));
            workPlace.sendKeys("仙女族");
            WebElement isNeedLive = driver.findElement(By.id("isNeedLive1"));
            isNeedLive.click();
            WebElement experience = driver.findElement(By.id("experience"));
            Select selection1 = new Select(experience);
            selection1.selectByIndex(1);
            WebElement employerEducation = driver.findElement(By.id("employerEducation"));
            Select selection2 = new Select(employerEducation);
            selection2.selectByIndex(1);
            WebElement employerSalary = driver.findElement(By.id("employerSalary"));
            employerSalary.sendKeys("1000");
            WebElement employerRestTime = driver.findElement(By.id("employerRestTime"));
            employerRestTime.sendKeys("10");
            WebElement babyyear = driver.findElement(By.id("babyyear"));
            babyyear.sendKeys("2000");
            WebElement babymonth = driver.findElement(By.id("babymonth"));
            babymonth.sendKeys("10");
            WebElement babydate = driver.findElement(By.id("babydate"));
            babydate.sendKeys("10");
            WebElement babyBirthWeight = driver.findElement(By.id("babyBirthWeight"));
            babyBirthWeight.sendKeys("8");
            WebElement motherAge = driver.findElement(By.id("motherAge"));
            motherAge.sendKeys("30");
            WebElement motherWeight = driver.findElement(By.id("motherWeight"));
            motherWeight.sendKeys("60");
            WebElement motherHeight = driver.findElement(By.id("motherHeight"));
            motherHeight.sendKeys("165");
            WebElement deliveryTimes = driver.findElement(By.id("deliveryTimes"));
            deliveryTimes.sendKeys("1");
            WebElement deliveryMode = driver.findElement(By.id("deliveryMode"));
            Select selection3 = new Select(deliveryMode);
            selection3.selectByIndex(1);

            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
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

