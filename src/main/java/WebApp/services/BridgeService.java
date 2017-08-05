package WebApp.services;

import WebApp.controllers.Hue;
import WebApp.models.LightStates;
import com.philips.lighting.model.PHLightState;
import org.springframework.stereotype.Service;

@Service
public class BridgeService {

    //================================================================================
    // Public methods
    //================================================================================
    public String turnOffAllLights()
    {
        hue.getBridge().setLightStateForDefaultGroup(LightStates.OFF.getState());
        return "success";
    }

    public String turnOnAllLights()
    {
        hue.getBridge().setLightStateForDefaultGroup(LightStates.ON.getState());
        return "success";
    }

    //================================================================================
    // Private variables
    //================================================================================
    private String localBridgeAddress;
    private Hue hue = Hue.getInstance();

}

