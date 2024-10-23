package pages;

import com.shaft.driver.SHAFT;
import org.apache.log4j.Hierarchy;
import org.openqa.selenium.By;

import java.util.Objects;

public class AddTaskPage {

    private SHAFT.GUI.WebDriver driver;
    public AddTaskPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
        if (Objects.equals(SHAFT.Properties.platform.targetPlatform(), "ANDROID")){
            intiateAndroidIds();
        }else{
            intiateIOSidIds();
        }
    }

    private By taskNameInput;
    private By addTaskButton;
    private By deleteTaskButton;




    public Homepage addNewTask(String taskName){
        driver.element().type(taskNameInput, taskName);
        driver.element().click(addTaskButton);
        return new Homepage(driver);
    }

    private void intiateAndroidIds(){
        taskNameInput = By.xpath("//android.widget.EditText");
        addTaskButton = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.Button");
    }

    private void intiateIOSidIds(){

    }


}
