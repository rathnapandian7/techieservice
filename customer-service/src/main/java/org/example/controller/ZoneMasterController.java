package org.example.controller;

import org.example.dto.Response;
import org.example.dto.ZoneDto;
import org.example.service.ZoneMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/zone")
public class ZoneMasterController {

    @Autowired
    ZoneMasterService zoneMasterService;

    @PostMapping("/createZone")
    public Response createZone(@RequestBody ZoneDto zoneDto) {
        return zoneMasterService.saveZone(zoneDto);

    }

    @GetMapping("/getZone")
    public Response getZone() {
        return zoneMasterService.getZone();

    }

    @GetMapping("/getZoneById")
    public Response getZoneById(@RequestParam Long zoneId) {
        return zoneMasterService.getZoneById(zoneId, Constants.ZONE);

    }

    @GetMapping("/getUserByZoneId")
    public Response getUserByZoneId(@RequestParam Long zoneId) {
        return zoneMasterService.getZoneById(zoneId, Constants.USER);

    }

}
