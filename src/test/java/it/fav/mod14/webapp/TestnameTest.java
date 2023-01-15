package it.fav.mod14.webapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class TestnameTest {
	private WebDriver driver;
	JavascriptExecutor js;

	@BeforeAll
	public static void setupProps() {
		System.setProperty("webdriver.gecko.driver", "/home/rossi/Apps/geckodriver/geckodriver");
	}
	
	@BeforeEach
	public void setUp() {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testname() {
		driver.get("http://localhost:8080/");
		driver.manage().window().setSize(new Dimension(1125, 883));
		driver.findElement(By.name("name")).click();
		driver.findElement(By.name("name")).sendKeys("Davide");
		driver.findElement(By.cssSelector("html")).click();
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		assertEquals(driver.findElement(By.xpath("//body/span")).getText(), "Hello Davide");
	}
}
