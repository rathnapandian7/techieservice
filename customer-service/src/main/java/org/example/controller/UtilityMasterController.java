package org.example.controller;


import org.example.dto.Response;
import org.example.dto.UtilityDto;
import org.example.service.UtilityMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/utility")
public class UtilityMasterController {

    @Autowired
    UtilityMasterService utilityMasterService;

    @PostMapping("/createUtility")
    public Response createUtilityMaster(@RequestBody final UtilityDto utilityDto) throws SQLException {
        return utilityMasterService.saveUtility(utilityDto);
    }

    @GetMapping("/getUtility")
    public Response getUtility() {
        return utilityMasterService.getUtility();
    }


    @GetMapping("/getUtilityById")
    public Response getUtilityById(@RequestParam final Long utilityId) {
        return utilityMasterService.getUtilityById(utilityId, Constants.UTILITY);
    }

    @GetMapping("/getUserByUtilityId")
    public Response getUserByUtilityId(@RequestParam final Long utilityId) {
        return utilityMasterService.getUtilityById(utilityId, Constants.USER);
    }
}
