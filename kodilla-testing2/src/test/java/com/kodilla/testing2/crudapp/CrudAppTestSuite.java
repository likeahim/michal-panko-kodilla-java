package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://likeahim.github.io";
    private WebDriver driver;
    private Random generator;
    private WebDriverWait wait;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        final String XPATH_TASK_NAME = "/html/body/main/section[1]/form/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "/html/body/main/section[1]/form/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "/html/body/main/section[1]/form/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(), '" + taskName + "')]")));

        sendTestTaskToTrello(taskName);
        deleteCrudAppTestTask(taskName);
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[1]")));

        driver.findElements(By.xpath("//form[@class='datatable__row']")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class='datatable__field-value']"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard = theForm.findElement(By.xpath(".//button[contains(@class, 'card-creation')]"));
                    buttonCreateCard.click();

                    wait.until(ExpectedConditions.alertIsPresent());
                    Alert alert = driver.switchTo().alert();
                    alert.accept();
                });
    }

    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[1]")));

        driver.findElements(By.xpath("//form[@class='datatable__row']")).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class='datatable__field-value']"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton = theForm.findElement(By.xpath("/html/body/main/section[2]/div/form/div/fieldset[1]/button[4]"));
                    wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
                    deleteButton.click();
                });
    }
}
