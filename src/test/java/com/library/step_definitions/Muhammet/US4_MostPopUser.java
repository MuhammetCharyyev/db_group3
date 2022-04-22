package com.library.step_definitions.Muhammet;

import com.library.step_definitions.Muhammet.base.TestBase;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class US4_MostPopUser extends TestBase {

    String actual;
    @When("I execute a query to find the most popular user")
    public void i_execute_a_query_to_find_the_most_popular_user() {
        DB_Util.runQuery("SELECT u.full_name, COUNT(*) AS countofreadbooks\n" +
                "FROM users u\n" +
                "INNER JOIN book_borrow bb ON u.id = bb.user_id\n" +
                "GROUP BY full_name\n" +
                "ORDER BY 2 DESC"); //desc order for the second column 'countofreadbooks'
        actual = DB_Util.getCellValue(1, 1);
        //or ->DB_Util.getFirstRowFirstColumn();
    }
    @Then("verify \"Test Student 1” is the user who reads the most")
    public void verify_test_student_number_is_the_user_who_reads_the_most(String expected) {
        Assert.assertEquals(expected, actual);
    }

}
