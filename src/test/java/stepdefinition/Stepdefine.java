package stepdefinition;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefine 
{
	WebDriver driver;
	
	@Given("user is on home page")
	public void user_is_on_home_page() 
	{
	    
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user searh product in search bar")
	public void user_searh_product_in_search_bar() throws InterruptedException
	{
	  driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("iphone");
	  driver.findElement(By.xpath("//button[@type='submit']//*[name()='svg']")).click();
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//div[@title='4★ & above']//div[@class='_24_Dny']")).click();
	 Thread.sleep(4000);
	  driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 (Blue, 128 GB)']")).click();
	 Thread.sleep(4000);
	  String handle=driver.getWindowHandle();
	  System.out.println(handle);
	}

	@And("select the products click on add to cart")
	public void select_the_products_click_on_add_to_cart() 
	{
		Set<String> handels=driver.getWindowHandles();
		
		for(String handle: handels)
		{
			if(!handle.equals(handels))
			{
				driver.switchTo().window(handle);
			}
		}
				
	   driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
	}

	@Then("user should see product in cart")
	public void user_should_see_product_in_cart() 
	{
	   String txt=driver.findElement(By.xpath("//span[normalize-space()='Place Order']")).getText();
	   String Act_txt=txt;
	   System.out.println(Act_txt);
	  
	}

	@And("validates the product")
	public void validates_the_product() 
	{
		try {
	  String text=driver.findElement(By.xpath("//a[normalize-space()='Apple iPhone 15 (Blue, 128 GB)']")).getText();
	  String Act_str="Apple iPhone 15 (Blue, 128 GB)";
	 String  Exp_str=text;
	 Assert.assertEquals(Act_str, Exp_str);
		}catch(Exception e)
		{
			
			System.out.println("data not found in cart");
		}

	}

}
