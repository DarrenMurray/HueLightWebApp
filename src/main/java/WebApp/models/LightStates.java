package WebApp.models;

import com.philips.lighting.model.PHLightState;

public enum LightStates {
    ON,
    OFF,
    WHITE,
    BLUE;

   public PHLightState getState() {
        PHLightState state = new PHLightState();
        switch (this) {
            case ON:
                state.setOn(true);
                return state;
            case OFF:
                state.setOn(false);
                return state;
            case WHITE:
                state.setHue(41370);
                return state;
            case BLUE:
                state.setHue(47010);
                return state;
            default:
                throw new AssertionError("Unknown state " + this);
        }
    }
}
