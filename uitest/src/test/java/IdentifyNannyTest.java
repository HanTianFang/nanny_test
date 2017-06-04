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
        WebElement nannyButton = driver.findElement(By.cssSelector(".md.md-favorite"));
        nannyButton.click();
        Thread.sleep(6000);
        WebElement toIdentifyButton = driver.findElement(By.id("identNanny"));
        toIdentifyButton.click();
    }
    @Test
    public void identifySuccess1() throws InterruptedException {
        Thread.sleep(3000);
        WebElement city = driver.findElement(By.id("city2"));
        city.click();
        WebElement isLive = driver.findElement(By.id("isLive1"));
        isLive.click();
        Thread.sleep(3000);
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
        Assert.assertEquals("成功",  driver.switchTo().alert().getText());
    }

    @Test
    public void identifySuccess2() throws InterruptedException {
        Thread.sleep(3000);
        WebElement city = driver.findElement(By.id("city2"));
        city.click();
        WebElement isLive = driver.findElement(By.id("isLive1"));
        isLive.click();
        Thread.sleep(3000);
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
        WebElement skill1 = driver.findElement(By.id("jnpx"));
        skill1.click();
        Thread.sleep(1000);
        WebElement yzcDescribe = driver.findElement(By.id("jnpxDescribe"));
        yzcDescribe.sendKeys("我们仙女族都爱做饭");
        WebElement skill1Button = driver.findElement(By.id("jnpxsubmit"));
        skill1Button.click();
    }

    @Test
    public void identifyFail1() throws InterruptedException {
        WebElement nannySalary = driver.findElement(By.id("nannySalary"));
        nannySalary.sendKeys("-1");
        Thread.sleep(1000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=regexp][data-fv-for=nannySalary]")));
        Assert.assertEquals("期望工资必须为非负数",  a.getText());
    }

    @Test
    public void identifyFail2() throws InterruptedException {
        WebElement identifyButton = driver.findElement(By.id("nannysubmit"));
        identifyButton.click();
        Thread.sleep(1000);
        String expected = "工作情况不能为空\n" +
                "学历不能为空\n" +
                "期望工资不能为空\n" +
                "期望休息天数不能为空\n" +
                "民族不能为空\n" +
                "信仰不能为空\n" +
                "婚姻状况不能为空\n" +
                "孩子是否在本地不能为空\n" +
                "父母是否在本地不能为空\n" +
                "自我介绍不能为空\n" +
                "备注不能为空";
        Assert.assertEquals(expected,  driver.switchTo().alert().getText());
    }

    @Test
    public void identifyFail3() throws InterruptedException {
        WebElement nannyRestTime = driver.findElement(By.id("nannyRestTime"));
        nannyRestTime.sendKeys("32");
        Thread.sleep(1000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=regexp][data-fv-for=nannyRestTime]")));
        Assert.assertEquals("期望休息天数必须为0-31的整数",  a.getText());
    }
    @Test
    public void identifyFail4() throws InterruptedException {
        WebElement nation = driver.findElement(By.id("nation"));
        nation.sendKeys("dd");
        Thread.sleep(1000);
        WebElement a = driver.findElement(By.cssSelector(("[data-fv-validator=regexp][data-fv-for=nation]")));
        Assert.assertEquals("民族填写错误",  a.getText());
    }

    @After
    public void closePage(){
        driver.quit();
    }
}
