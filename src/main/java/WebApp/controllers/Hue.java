package WebApp.controllers;

/**
 * Created by dmurray on 05/08/2017.
 **/
import java.util.List;
import WebApp.hueProperties.HueProperties;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.hue.sdk.PHSDKListener;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHHueParsingError;

public class Hue {
    //================================================================================
    // Public methods
    //================================================================================
    public Hue() {
        this.phHueSDK = PHHueSDK.getInstance();
        connectToLastKnownAccessPoint();
    }

    public static Hue getInstance(){
        if(instance == null){
            instance = new Hue();
        }
        return instance;
    }

    public PHBridge getBridge()
    {
     return phHueSDK.getSelectedBridge();
    }

    private PHSDKListener listener = new PHSDKListener() {

        @Override
        public void onAccessPointsFound(List<PHAccessPoint> accessPointsList) {

        }

        @Override
        public void onAuthenticationRequired(PHAccessPoint accessPoint) {
            // Start the Pushlink Authentication.
            phHueSDK.startPushlinkAuthentication(accessPoint);
        }

        @Override
        public void onBridgeConnected(PHBridge bridge, String username) {
            phHueSDK.setSelectedBridge(bridge);
            phHueSDK.enableHeartbeat(bridge, PHHueSDK.HB_INTERVAL);
            String lastIpAddress =  bridge.getResourceCache().getBridgeConfiguration().getIpAddress();
            HueProperties.storeUsername(username);
            HueProperties.storeLastIPAddress(lastIpAddress);
            HueProperties.saveProperties();
        }

        @Override
        public void onCacheUpdated(List<Integer> arg0, PHBridge arg1) {
        }

        @Override
        public void onConnectionLost(PHAccessPoint arg0) {
        }

        @Override
        public void onConnectionResumed(PHBridge arg0) {
        }

        @Override
        public void onError(int code, final String message) {
        }

        @Override
        public void onParsingErrors(List<PHHueParsingError> parsingErrorsList) {  
            for (PHHueParsingError parsingError: parsingErrorsList) {
                System.out.println("ParsingError : " + parsingError.getMessage());
            }
        } 
    };

    /**
     * Connect to the last known access point.
     * 
     */
    public boolean connectToLastKnownAccessPoint() {
        String username = HueProperties.getUsername();
        String lastIpAddress =  HueProperties.getLastConnectedIP();     
        
        if (username==null || lastIpAddress == null) {
            return false;
        }
        PHAccessPoint accessPoint = new PHAccessPoint();
        accessPoint.setIpAddress(lastIpAddress);
        accessPoint.setUsername(username);
        phHueSDK.connect(accessPoint);
        return true;
    }

    //================================================================================
    // Private variables
    //================================================================================
    private PHHueSDK phHueSDK;
    private static final int MAX_HUE=65535;
    private static Hue instance;
}
