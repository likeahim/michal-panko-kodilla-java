package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    public static final String FACEBOOK = "https://www.facebook.com/";
    public static final String ACCEPT_COOKIES_BUTTON = "//div[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 " +
                                                       "xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l " +
                                                       "x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']";
    public static final String CREATE_ACCOUNT_BUTTON = "//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']";
    public static final String BIRTHDAY_DAY = "//select[@name='birthday_day']";
    public static final String BIRTHDAY_MONTH = "//select[@name='birthday_month']";
    public static final String BIRTHDAY_YEAR = "//select[@name='birthday_year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(FACEBOOK);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath(ACCEPT_COOKIES_BUTTON)).click();
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BIRTHDAY_DAY)));
        WebElement day = driver.findElement(By.xpath(BIRTHDAY_DAY));
        Select comboFieldDay = new Select(day);
        comboFieldDay.selectByValue("21");

        WebElement month = driver.findElement(By.xpath(BIRTHDAY_MONTH));
        Select comboFieldMonth = new Select(month);
        comboFieldMonth.selectByVisibleText("lip");

        WebElement year = driver.findElement(By.xpath(BIRTHDAY_YEAR));
        Select comboFieldYear = new Select(year);
        comboFieldYear.selectByValue("1988");
    }
}
