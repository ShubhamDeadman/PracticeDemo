package Cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrintClass {
	String str;
	
	@When("^user enters hello world$")
    public void initialse() throws Throwable {
			str="hello World";
	}

	@Then("^console displays the same$")
	public void display() throws Throwable {
		System.out.println(str);
	}
	
}
