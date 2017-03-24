package qqq;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import  org.junit.Test;
import  org.junit.runner.RunWith;
import  org.junit.runners.Parameterized;

import  org.junit.runners.Parameterized.Parameters;
import  java.util.Arrays;
import  java.util.Collection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;



@RunWith(Parameterized. class )
public class www {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  private String numb;
  private String pwd;
  private String execl;

  
  @Parameters
  public   static  Collection data() throws FileNotFoundException  {
	  Object[][] array = new Object[117][3];
	  
	  //InputStreamReader isr = new InputStreamReader(System.in);
	  //BufferedReader br = new BufferedReader(isr);
	  File dataFile = new File("C:\\Users\\shengfeng\\Desktop\\¿Î¼þ\\Èí¼þ²âÊÔ\\inputgit.csv");
	
	  try{  	
		  FileReader fr = new FileReader(dataFile);
		  BufferedReader br = new BufferedReader(fr);
		  String content = null;
		  content = br.readLine();
		  int count = 0;
		  while ((content = br.readLine()) != null){
			  array[count][0] = content.split(",")[0];
				   array[count][1] = content.split(",")[0].substring(4);
				   array[count][2] = content.split(",")[2];
			  count++;
		  }
			fr.close();
			br.close();
	  
	  }catch(FileNotFoundException e){}
	  catch(IOException e){}
	  
	  return Arrays.asList(array);
 } 
  
  
  
  
  public www(String m, String n, String url){
	  this.numb = m;
	  this.pwd = n;
	  this.execl = url;
	 
  }
  
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "F:\\geckodriver\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://121.193.130.195";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWedDriver() throws Exception {
	  driver.get(baseUrl + "/");
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys(numb);
	    driver.findElement(By.id("pwd")).clear();
	    driver.findElement(By.id("pwd")).sendKeys(pwd);
	    driver.findElement(By.id("submit")).click();
	    
	    assertEquals(execl, driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]")).getText());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
