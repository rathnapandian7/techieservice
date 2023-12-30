package org.example.controller;



import org.example.dto.CityDto;
import org.example.dto.Response;
import org.example.dto.StateDto;
import org.example.model.CityMaster;
import org.example.service.CityMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityMasterController {

    @Autowired
    CityMasterService cityMasterService;


    @PostMapping("/createCity")
    public Response createCity(@RequestBody CityDto cityDto) {
        return cityMasterService.saveCityMaster(cityDto);

    }

    @GetMapping("/getCity")
    public Response getCity() {
        return cityMasterService.getCityDetails();
    }

    @GetMapping("/getCityById")
    public Response getCityById(@RequestParam Long cityId) {
        return cityMasterService.getCityById(cityId, Constants.CITY);
    }

    @GetMapping("/getLocalByCityId")
    public Response getLocalByCityId(@RequestParam Long cityId) {
        return cityMasterService.getCityById(cityId, Constants.USER);
    }
}
