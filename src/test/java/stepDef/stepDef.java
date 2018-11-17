package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDef {

	@Given("^test Given$")
	public void test_Given() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
System.out.println("Inside Given");
}

	@When("^test When$")
	public void test_When() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside When");
	}

	@Then("^test Then$")
	public void test_Then() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Then");
	}

	@Then("^test Then Fail$")
	public void test_Then_Fail() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		System.out.println("Fail assert");
}


}
