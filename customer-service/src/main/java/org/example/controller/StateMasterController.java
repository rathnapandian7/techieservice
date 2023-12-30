package org.example.controller;


import org.example.dto.LocalDto;
import org.example.dto.Response;
import org.example.dto.SiteDto;
import org.example.dto.StateDto;
import org.example.model.StateMaster;
import org.example.service.StateMasterServcie;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/state")
public class StateMasterController {

    @Autowired
    StateMasterServcie stateMasterServcie;


    @PostMapping("/createState")
    public Response createLoacalMaster(@RequestBody StateDto stateDto) {
        return stateMasterServcie.saveStateMaster(stateDto);

    }

    @GetMapping("/getState")
    public Response getLocal() {
        return stateMasterServcie.getStateDetails();
    }

    @GetMapping("/getStateById")
    public Response getLocalById(@RequestParam Long stateId) {
        return stateMasterServcie.getStateById(stateId, Constants.STATE);
    }

    @GetMapping("/getLocalByStateId")
    public Response getUserByLocalId(@RequestParam Long localId) {
        return stateMasterServcie.getStateById(localId, Constants.USER);
    }

}
