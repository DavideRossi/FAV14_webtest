package it.fav.mod14.webapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
class TestnameTest {
	@BeforeAll
	public static void setupProps() {
		System.setProperty("webdriver.gecko.driver", "/home/rossi/Apps/geckodriver/geckodriver");
	}

	@Test
	public void testname(FirefoxDriver driver) {
		driver.get("http://localhost:8080/");
		driver.manage().window().setSize(new Dimension(1125, 883));
		driver.findElement(By.name("name")).click();
		driver.findElement(By.name("name")).sendKeys("Davide");
		driver.findElement(By.cssSelector("html")).click();
		driver.findElement(By.cssSelector("input:nth-child(3)")).click();
		String text = driver.findElement(By.xpath("//body/span")).getText();
		assertEquals(text, "Hello Davide");
	}
}
