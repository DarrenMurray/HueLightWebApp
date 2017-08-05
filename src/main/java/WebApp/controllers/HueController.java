package WebApp.controllers;
/**
 * Created by dmurray on 05/08/2017.
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import WebApp.services.BridgeService;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class HueController {

    //================================================================================
    // Public methods
    //================================================================================
    @RequestMapping(value = "api/LightsOff", method=POST)
    @ResponseBody
    public String turnOffLights() {

        return  m_bridgeService.turnOffAllLights();
    }

    @RequestMapping(value = "api/LightsOn", method=POST)
    @ResponseBody
    public String turnOnLights() {

        return  m_bridgeService.turnOnAllLights();
    }

    //================================================================================
    // Private variables
    //================================================================================
    @Autowired
    private BridgeService m_bridgeService;
}
