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
import org.testng.Assert;

import java.util.Map;

public class US5_UI_DB_Info extends TestBase {

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        LoginPage loginPage = new LoginPage();
        // Given I am in the homepage of library app
        loginPage.login();
    }
    @Given("I navigate to {string} page")
    public void i_navigate_to_page(String module) {
        CommonAreaPage commonAreaPage = new CommonAreaPage();
        commonAreaPage.navigateModule(module);
    }
    @When("I open book {string}")
    public void i_open_book(String bookName) {
        BookPage bookPage = new BookPage();
        bookPage.search.sendKeys(bookName);
        BrowserUtils.waitFor(3);
//    And I execute query to get the book information from books table
        DB_Util.runQuery("SELECT name, author, year\n" +
                "FROM books\n" +
                "WHERE name = 'Chordeiles minor'");
    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        BookPage bookPage = new BookPage();

        // DB Data
        String ecpectedBookName = DB_Util.getCellValue(1, 1);
        String ecpectedAuthorName = DB_Util.getCellValue(1, 2);
        String ecpectedYear = DB_Util.getCellValue(1, 3);

        // UI Data

        String actualYear = bookPage.year.getText();
        String actualAuthorName = bookPage.authorName.getText();
        String actualBookName = bookPage.bookName.getText();

        // Verify
        Assert.assertEquals(ecpectedBookName, actualBookName);
        Assert.assertEquals(ecpectedAuthorName, actualAuthorName);
        Assert.assertEquals(ecpectedYear, actualYear);
    }

}
