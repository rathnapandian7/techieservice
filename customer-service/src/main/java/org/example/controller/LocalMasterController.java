package org.example.controller;


import org.example.dto.LocalDto;
import org.example.dto.Response;
import org.example.service.LocalMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/local")
public class LocalMasterController {

    @Autowired
    LocalMasterService localMasterService;

    @PostMapping("/createLocal")
    public Response createLoacalMaster(@RequestBody LocalDto localDto) {
        return localMasterService.saveLocalMaster(localDto);

    }

    @GetMapping("/getLocal")
    public Response getLocal() {
        return localMasterService.getLocalDetails();
    }

    @GetMapping("/getLocalById")
    public Response getLocalById(@RequestParam Long localId) {
        return localMasterService.getLocalById(localId, Constants.LOCAL);
    }

    @GetMapping("/getUserByLocalId")
    public Response getUserByLocalId(@RequestParam Long localId) {
        return localMasterService.getLocalById(localId, Constants.LOCAL);
    }

}
