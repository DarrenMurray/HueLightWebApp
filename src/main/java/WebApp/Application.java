package WebApp; /**
 * Created by dmurray on 05/08/2017.
 **/

import com.philips.lighting.hue.sdk.PHHueSDK;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import WebApp.hueProperties.HueProperties;
import WebApp.controllers.Hue;

@SpringBootApplication
public class Application
{

    public static void main(String[] args)
    {
        PHHueSDK phHueSDK = PHHueSDK.create();
        // Load in HueProperties, if first time use a properties file is created.
        HueProperties.loadProperties();
        Hue controller = new Hue();
        phHueSDK.getNotificationManager().registerSDKListener(controller.getListener());
        SpringApplication.run(Application.class, args);
    }
}