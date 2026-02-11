package stepDefinition;

import java.time.Duration;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPage;

	@Given("user is on login page")
	public void user_is_on_login_page() throws InterruptedException {
		loginPage=new LoginPage(DriverFactory.getDriver());
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		String pageTitle=loginPage.getLoginPageTitle();
		System.out.println("pageTitle");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
		String pageTitle=loginPage.getLoginPageTitle();
		System.out.println("pageTitle");
		Assert.assertTrue(pageTitle.contains(title));
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) throws InterruptedException {
		
	   loginPage.enterUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(5000);
		loginPage.clickSubmit();
		
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
		String success= loginPage.getTitleAfterLogin();
		Assert.assertEquals(success, "Dashboard");
	}



}
