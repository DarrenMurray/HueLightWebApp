package WebApp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Device {

    //================================================================================
    // Public methods
    //================================================================================
    @JsonProperty("devicetype")
    public String getType() {
        return deviceType;
    }

    @JsonProperty("devicetype")
    public void setType(String type) {
        this.deviceType = type;
    }

    //================================================================================
    // Private variables
    //================================================================================
    private String deviceType;
}
