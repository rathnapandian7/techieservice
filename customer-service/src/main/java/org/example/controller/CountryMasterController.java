package org.example.controller;

import org.example.dto.CountryDto;
import org.example.dto.Response;
import org.example.service.CountryMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/country")
public class CountryMasterController {

    @Autowired
    CountryMasterService countryMasterService;

    @PostMapping("/createCountry")
    public Response createCountry(@RequestBody CountryDto countryDto) {
        return countryMasterService.saveCountryMaster(countryDto);
    }

    @GetMapping("/getCountry")
    public Response getCountry() {
        return countryMasterService.getCountryDetails();
    }

    @GetMapping("/getCountryById")
    public Response getCountryById(@RequestParam Long countryId) {
        return countryMasterService.getCountryById(countryId, Constants.COUNTRY);
    }

    @GetMapping("/getUserByCountryId")
    public Response getUserByCountryId(@RequestParam Long countryId) {
        return countryMasterService.getCountryById(countryId, Constants.USER);
    }
}
