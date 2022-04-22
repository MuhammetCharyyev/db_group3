package com.library.step_definitions.Muhammet;

import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.LoginPage;
import com.library.step_definitions.Muhammet.base.TestBase;
import com.library.utility.BrowserUtils;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class US6_UI_DB_BookCategories extends TestBase {

    @Given("I log in as a librarian")
    public void i_log_in_as_a_librarian() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
    @When("I navigate to the {string} page")
    public void i_navigate_to_the_page(String module) {
        new CommonAreaPage().navigateModule(module);
    }

    List<String> actualBookCategories;
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        actualBookCategories = BrowserUtils.getAllSelectOptions(new BookPage().mainCategoryElement);
        actualBookCategories.remove(0);//remove all
    }

    @When("I execute a query to get book categories")
    public void i_execute_a_query_to_get_book_categories() {
        DB_Util.runQuery ( "SELECT name\n" +
                             "FROM book_categories");

    }
    @Then("verify book categories must match the book_categories table from DB")
    public void verify_book_categories_must_match_the_book_categories_table_from_db() {
        List<String> expectedBookCategories = DB_Util.getColumnDataAsList(1);
        actualBookCategories.remove(0);//remove all
        Assert.assertEquals(expectedBookCategories, actualBookCategories);
    }


}
