package com.library.step_definitions.Muhammet;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.step_definitions.Muhammet.base.TestBase;
import com.library.utility.BrowserUtils;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class US2_AmountBooks extends TestBase {

    LoginPage loginPage ;
    DashBoardPage dashBoardPage;
    String actualBorrowBooksNumber;

    @Given("I am in the homepage of the library app")
    public void i_am_in_the_homepage_of_the_library_app() {
        // Given I am in the homepage of library app
        loginPage = new LoginPage();
        loginPage.login();
    }

    @When("I take borrowed books number")
    public void i_take_borrowed_books_number() {
        dashBoardPage=new DashBoardPage();
        BrowserUtils.waitFor(3);
        //actual
        actualBorrowBooksNumber = dashBoardPage.borrowedBooksNumber.getText();

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        // When I take borrowed books number from DB  (expected)
        DB_Util.runQuery("SELECT COUNT(*)\n" +
                "FROM book_borrow\n" +
                "WHERE is_returned = 0");
        String expectedBorrowBooksNumber = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(actualBorrowBooksNumber, expectedBorrowBooksNumber);

    }



}
