package TestPackage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Homepage;

public class TaskyBasicScenarios {

   private SHAFT.GUI.WebDriver driver;
   private SHAFT.TestData.JSON testData;
   private String taskName;


    @BeforeClass
   public void init(){
       driver = new SHAFT.GUI.WebDriver();
       testData = new SHAFT.TestData.JSON("tasks.json");
       taskName = testData.getTestData("taskName");

   }


    @Test
    public void fullFLow(){
       new Homepage(driver)
               .clickOnAddTaskButton()
               .addNewTask(taskName)
               .assertThatTaskIsAddedSuccessfully(taskName)
               .markTaskAsCompleted()
               .assertThatTaskIsChecked()
               .deleteTask()
               .assertThatTaskIsDeletedSuccessfully()
               .navigateToSettingsPage()
               .switchOffTwintyFourClock()
               .assertThatClockIsChanged();
    }

    @AfterClass
    public void flush(){
        driver.quit();
    }

}
