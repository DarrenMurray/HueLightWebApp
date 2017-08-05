package WebApp.services;

import com.philips.lighting.hue.sdk.PHBridgeSearchManager;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHLightState;
import WebApp.models.Bridge;
import org.springframework.stereotype.Service;

@Service
public class BridgeService {

    //================================================================================
    // Public methods
    //================================================================================
    public String getLocalBridgeAddress()
    {
        //Hardcoded Bridge Address
        return "192.168.0.225";
    }

    //Todo: Implement bridge discovery
    public PHBridge findBridge()
    {
        PHBridge bridge = phHueSDK.getSelectedBridge();
        return bridge;
    }

    public void findBridges()
    {
        phHueSDK = PHHueSDK.getInstance();
        PHBridgeSearchManager sm = (PHBridgeSearchManager) phHueSDK.getSDKService(PHHueSDK.SEARCH_BRIDGE);
        sm.search(true, true);
    }

    public String turnOffAllLights()
    {
        PHLightState lightState = new PHLightState();
        lightState.setOn(false);
        findBridge().setLightStateForDefaultGroup(lightState);
        return "success";
    }

    //================================================================================
    // Public variables
    //================================================================================
    private String localBridgeAddress;
    private PHHueSDK phHueSDK;

}

