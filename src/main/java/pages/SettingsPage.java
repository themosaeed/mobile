package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import java.util.Objects;

public class SettingsPage {



    private SHAFT.GUI.WebDriver driver;
    public SettingsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
        System.out.println(SHAFT.Properties.platform.targetPlatform());
        if (Objects.equals(SHAFT.Properties.platform.targetPlatform(), "ANDROID")){
            intiateAndroidIds();
        }else{
            intiateIOSidIds();
        }
    }

    private By useTwentyFourClockSelect;

    public SettingsPage switchOffTwintyFourClock(){
        driver.element().click(useTwentyFourClockSelect);
        return this;
    }

    public SettingsPage assertThatClockIsChanged(){
        driver.assertThat().element(useTwentyFourClockSelect).attribute("checked").isFalse();
        return this;
    }



    private void intiateAndroidIds() {
        useTwentyFourClockSelect = By.xpath("//android.widget.ScrollView/android.view.View[5]/android.view.View");
    }
    private void intiateIOSidIds(){

    }


}
