package Cucumber;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataTableStepdefinition {
	@Given("^User must be registered$")
	public void user_must_be_registered() throws Throwable {
		System.out.println("User must be registered");
		System.out.println("-----------------");
	}

	@When("^User performs login using$")
	public void user_performs_login_using(DataTable dt) throws Throwable {
		List<Map<String, String>> list = dt.asMaps(String.class, String.class);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("username") + " " + (list.get(i).get("password")));
		}
	}

	@Then("^user lands up in home page$")
	public void user_lands_up_in_home_page() throws Throwable {
		System.out.println("--------------------------");
		System.out.println("User in home page");
	}

}

