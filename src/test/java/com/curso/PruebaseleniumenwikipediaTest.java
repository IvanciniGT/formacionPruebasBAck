package com.curso;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class PruebaseleniumenwikipediaTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities cp=new DesiredCapabilities();
    cp.setBrowserName("chrome");
 driver = new RemoteWebDriver(new URL("http://34.245.68.60:4444/wd/hub"), cp);
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void pruebaseleniumenwikipedia() {
    driver.get("https://www.wikipedia.org/");
    assertEquals("Wikipedia", driver.getTitle());
  }
}
