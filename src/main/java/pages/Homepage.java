package pages;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.Objects;

public class Homepage {

    private SHAFT.GUI.WebDriver driver;
    public Homepage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
        System.out.println(SHAFT.Properties.platform.targetPlatform());
        if (Objects.equals(SHAFT.Properties.platform.targetPlatform(), "ANDROID")){
            intiateAndroidIds();
        }else{
            intiateIOSidIds();
        }
    }

    private By addTaskButton;
    private By firstTask;
    private By taskCheckbox;
    private By deleteTaskButton;
    private By noTasksLabel;
    private By settingsIcon;

    public AddTaskPage clickOnAddTaskButton(){
        driver.element().click(addTaskButton);
        return new AddTaskPage(driver);
    }

    public Homepage markTaskAsCompleted(){
        driver.element().click(taskCheckbox);
        return this;
    }

    public Homepage deleteTask(){
        driver.element().click(firstTask);
        driver.element().click(deleteTaskButton);
        return this;
    }

    public SettingsPage navigateToSettingsPage(){
        driver.element().click(settingsIcon);
        return new SettingsPage(driver);
    }


    public Homepage assertThatTaskIsAddedSuccessfully(String taskName){
        driver.assertThat().element(firstTask).exists();
        return this;
    }

    public Homepage assertThatTaskIsDeletedSuccessfully(){
        driver.assertThat().element(noTasksLabel).exists();
        return this;
    }

    public Homepage assertThatTaskIsChecked(){
        driver.assertThat().element(taskCheckbox).isChecked();
        return this;
    }



    private void intiateAndroidIds(){
        addTaskButton= By.xpath("//androidx.compose.ui.platform.k1/android.view.View/android.view.View/android.view.View[3]/android.widget.Button");
        firstTask = By.xpath("//androidx.compose.ui.platform.k1/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View");
        taskCheckbox = By.className("android.widget.CheckBox");
        deleteTaskButton = By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button");
        noTasksLabel = By.xpath("//android.widget.TextView[@text=\"No Tasks\"]");
        settingsIcon = By.xpath("//androidx.compose.ui.platform.k1/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    }

    private void intiateIOSidIds(){

    }



}
