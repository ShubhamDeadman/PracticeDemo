package Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BgStepDefinition {
	@Given("^User is in the Login Page$")
	public void user_is_in_the_Login_Page() throws Throwable {
		System.out.println("User is in the login page");
	}

	@When("^User enters valid credentials and performs Login$")
	public void user_enters_valid_credentials_and_performs_Login() throws Throwable {
		System.out.println("user enters credential and performs login");
	}

	@Then("^User must be navigated to the Home Page$")
	public void user_must_be_navigated_to_the_Home_Page() throws Throwable {
		System.out.println("Logged in successfully !!");
	}

	@Given("^User must be in the search page$")
	public void user_must_be_in_the_search_page() throws Throwable {
		System.out.println("in Search page");
	}

	@When("^User searches for a product by category$")
	public void user_searches_for_a_product_by_category() throws Throwable {
		System.out.println("Search the product ");
	}

	@Then("^Product decsription is displayed$")
	public void product_decsription_is_displayed() throws Throwable {
		System.out.println("user in product description page");
	}

	@Given("^Search the product to purchase$")
	public void search_the_product_to_purchase() throws Throwable {
		System.out.println("search the product to buy");
	}

	@When("^select the product and add it to the cart\\.$")
	public void select_the_product_and_add_it_to_the_cart() throws Throwable {
		System.out.println(" add it to cart");
	}

}