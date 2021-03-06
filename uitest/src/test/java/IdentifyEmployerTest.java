import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

    /**
     * Created by Deft on 2017/5/9.
     */
    public class IdentifyEmployerTest {
        private static WebDriver driver;

        @Before
        public void openPage() throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            registerSuccess();
            addInfoSuccess();
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
            Thread.sleep(1000);
            WebElement userEmail = driver.findElement(By.id("userEmail"));
            userEmail.click();
        }

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
            WebElement menuButton = driver.findElement(By.id("mm-menu-toggle"));
            menuButton.click();
            Thread.sleep(6000);
            WebElement employerButton = driver.findElement(By.cssSelector(".md.md-settings"));
            employerButton.click();
            Thread.sleep(6000);
            WebElement toIdentifyButton = driver.findElement(By.id("identEmployer"));
            toIdentifyButton.click();
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

        @Test
        public void identifyFail1() throws InterruptedException {
            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            System.out.println(driver.switchTo().alert().getText());
            String expected = "工作经验不能为空\n" +
                    "学历不能为空\n" +
                    "可支付工资不能为空\n" +
                    "月嫂每月可休息天数不能为空\n" +
                    "婴儿出生年不能为空\n" +
                    "婴儿出生月不能为空\n" +
                    "婴儿出生日不能为空\n" +
                    "婴儿出生体重不能为空\n" +
                    "母亲年龄不能为空\n" +
                    "母亲体重不能为空\n" +
                    "备注不能为空\n" +
                    "备注不能为空\n" +
                    "备注不能为空";
            Assert.assertEquals(expected,  driver.switchTo().alert().getText());
        }

        @Test
        public void identifyFail2() throws InterruptedException {
            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            Assert.assertEquals("成功",  driver.switchTo().alert().getText());
        }

        @Test
        public void identifyFail3() throws InterruptedException {
            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            Assert.assertEquals("成功",  driver.switchTo().alert().getText());
        }

        @Test
        public void identifyFail4() throws InterruptedException {
            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            Assert.assertEquals("成功",  driver.switchTo().alert().getText());
        }

        @Test
        public void identifyFail5() throws InterruptedException {
            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            Assert.assertEquals("成功",  driver.switchTo().alert().getText());
        }

        @Test
        public void identifyFail6() throws InterruptedException {
            WebElement identifyButton = driver.findElement(By.id("employersubmit"));
            identifyButton.click();
            Thread.sleep(1000);
            Assert.assertEquals("成功",  driver.switchTo().alert().getText());
        }
        @After
        public void closePage(){
            driver.quit();
        }
    }

