package com.library.step_definitions.Muhammet;

import com.library.step_definitions.Muhammet.base.TestBase;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class US3_GenreBook extends TestBase {

    @When("I execute a query to find the most popular book genre")
    public void i_execute_a_query_to_find_the_most_popular_book_genre() {
        DB_Util.runQuery("SELECT book_categories.name, COUNT(*) AS countofbookcategories\n" +
                "FROM book_borrow\n" +
                "INNER JOIN books\n" +
                "ON book_borrow.book_id = books.id\n" +
                "INNER JOIN book_categories\n" +
                "ON books.book_category_id = book_categories.id\n" +
                "GROUP BY book_categories.name\n" +
                "ORDER BY 2 DESC");
    }
    @Then("verify that “Classic\" is the most popular book genre")
    public void verify_that_classic_is_the_most_popular_book_genre() {
        Assert.assertEquals(DB_Util.getFirstRowFirstColumn(), "Classic");
    }

}
