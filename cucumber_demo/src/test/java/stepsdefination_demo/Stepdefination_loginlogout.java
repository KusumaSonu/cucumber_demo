package stepsdefination_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefination_loginlogout {
	public static WebDriver driver = null;

	@Given("^I will launch the browser$")
	public void I_will_launch_the_browser() {

		try {
			driver = new ChromeDriver();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@And("^I will navigate to the given url$")
	public void I_will_navigate_to_the_given_url() {
		try {
			driver.navigate().to("https://www.saucedemo.com/");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Then("^I will validate the url$")
	public void I_will_validate_the_url() {
		try {

			if (driver.getTitle().equals("Swag Labs")) {
				System.out.println("URL navigated successfully");
			} else {
				System.out.println("URL is not navigated successfully");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@And("^I will enter the user name in the username field$")
	public void I_will_enter_the_user_name_in_the_username_field() {
		try {

			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@And("^I will enter the password in the password field$")
	public void I_will_enter_the_password_in_the_password_field() {
		try {
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@When("^I will click on the login button$")
	public void I_will_click_on_the_login_button() {
		try {

			driver.findElement(By.id("login-button")).click();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@And("^I will validate the login page$")
	public void I_will_validate_the_login_page() 
	{
		try {
			String str = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).getText();
			System.out.println(str);
			
			//Assert.assertEquals(str, "Sauce Labs Onesie","Login is successful");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@When ("^I will click on three lines options$")
	public void I_will_click_on_three_lines_options()
	{
		try {
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
					
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@And ("^I will click on the logout option$")
	public void I_will_click_on_the_logout_option()
	{
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Then ("^I will validate logout is successful or not$")
	public void I_will_validate_logout_is_successful_or_not()
	{
		try {
			
			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login_credentials\"]/text()[1]")), "", "logout is successful");
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
