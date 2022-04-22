package com.library.step_definitions.Muhammet;


import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {
    //for ui
    @Before
    public void uiSetup() {
Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));
Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //for ui
    @After
    public void uiTearDown(Scenario scenario) {

        // check if scenario failed or not
        if(scenario.isFailed()){
            //this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            // scenario.attach(screenshot,"image/png","what ever we want");
            scenario.attach(screenshot,"image/png","Image for failed step");
        }
        Driver.closeDriver();
    }

  //for DB
    @Before
    public void dbSetup() {
        String url = ConfigurationReader.getProperty("library2.db.url");
        String username = ConfigurationReader.getProperty("library2.db.username");
        String password = ConfigurationReader.getProperty("library2.db.password");
        DB_Util.createConnection(url, username, password);
    }

    //for DB
    @After
    public void dbTearDown() {
        DB_Util.destroy();
    }
}
