package org.example.controller;

import org.example.dto.PinDto;
import org.example.dto.Response;
import org.example.service.PinMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pin")
public class PinMasterController {

    @Autowired
    PinMasterService pinMasterService;

    @PostMapping("/createPin")
    public Response createPin(@RequestBody final PinDto pinDto) {
        return pinMasterService.savePinMaster(pinDto);
    }

    @GetMapping("/getPin")
    public Response getPin() {
        return pinMasterService.getPinDetails();
    }

    @GetMapping("/getPinById")
    public Response getPinById(@RequestParam Long pinId) {
        return pinMasterService.getPinById(pinId, Constants.PIN);
    }

    @GetMapping("/getUserByPinId")
    public Response getPin(@RequestParam Long pinId) {
       return pinMasterService.getPinById(pinId, Constants.USER);
    }

}
