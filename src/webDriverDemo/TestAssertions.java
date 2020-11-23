package webDriverDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Random;

public class TestAssertions {
	private static WebDriver driver;

   @Before
   public void before() {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\gabri\\Downloads\\geckodriver-v0.28.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      //Launch website
	      driver.navigate().to("https://www.calculator.net/percent-calculator.html");
   }
   
	@Test
   public void PorcentageValuesIncorrect() {	
		   

	      

	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("A");
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("10");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font")).getText();
	      
	      assertEquals(result,"Please provide two numeric values in any fields below.");

   }
	@Test
	   public void PorcentageValuesCorrect() {	
		   

	   
	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("50");
	      
	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("10");
	      
	      // Click Calculate Button
	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();

	      
	      // Get the Result Text based on its xpath
	      String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
	      
	      
	      assertEquals(result,"5");
	      
		}
	@Test
	public void DiferenciaPorcentage() {
		  double V1;
		  double V2;
		  double resultado;
	      double parecidos; 

		  for(int i=0;i<20;i++) {
		      driver.findElement(By.xpath(".//*[@id=\"content\"]/table[5]/tbody/tr[1]/td[2]/input")).clear();
		      driver.findElement(By.xpath(".//*[@id=\"content\"]/table[5]/tbody/tr[2]/td[2]/input")).clear();

			 Random rand = new Random();
			 V1 = (int)(Math.random() * (20 - 1 + 1) + 1);
			 

			 V2 = (int)(Math.random() * (20 - 1 + 1) + 1);
			 


		      // Enter value 10 in the first number of the percent Calculator
		      driver.findElement(By.xpath(".//*[@id=\"content\"]/table[5]/tbody/tr[1]/td[2]/input")).sendKeys(String.valueOf(V1));
		      
		      // Enter value 50 in the second number of the percent Calculator
		      driver.findElement(By.xpath(".//*[@id=\"content\"]/table[5]/tbody/tr[2]/td[2]/input")).sendKeys(String.valueOf(V2));
				 resultado = (Math.abs(V1 - V2) / ((V1 + V2)/2)) * 100;
			      System.out.println(V1 + " " + V2);

		      // Click Calculate Button
		      driver.findElement(By.xpath(".//*[@id = 'content']/table[5]/tbody/tr[3]/td/input[2]")).click();

		      
		      // Get the Result Text based on its xpath
		      String result = driver.findElement(By.xpath(".//*[@id=\"content\"]/p[2]/font/b")).getText();
		      String[] resulta = result.split("%");
		      parecidos = Math.abs(Double.parseDouble(resulta[0])- resultado);
		      System.out.println("resultado :" +result + " " + resultado);
		      assertTrue(parecidos < 0.01);

		  }
		  

	      
	      
	}
   @After
   public void After() {
	      driver.close();
   }
}