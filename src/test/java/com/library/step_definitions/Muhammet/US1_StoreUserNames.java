package com.library.step_definitions.Muhammet;

import com.library.step_definitions.Muhammet.base.TestBase;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class US1_StoreUserNames extends TestBase {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("Database Connection is done inside Hooks");;
    }
    List<String > actualIDs;
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        DB_Util.runQuery("SELECT id FROM users");
        actualIDs = DB_Util.getColumnDataAsList(1);

    }

    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        String query = "SELECT DISTINCT id\n" +
                "FROM users";
        DB_Util.runQuery(query);
        List<String> expectedIDs = DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(expectedIDs, actualIDs);
        //expected from user
        //Then verify all users has unique ID
    }

    List<String> actualColumnName;
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("SELECT * FROM users");
        actualColumnName = DB_Util.getAllColumnNamesAsList();
    }

    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedColumns){

        assertEquals(expectedColumns, actualColumnName);

    }

}
