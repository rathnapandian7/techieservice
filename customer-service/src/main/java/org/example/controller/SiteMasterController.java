package org.example.controller;

import org.example.dto.Response;
import org.example.dto.SiteDto;
import org.example.model.SiteMaster;
import org.example.service.SiteMasterService;
import org.example.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/site")
public class SiteMasterController {
    @Autowired
    SiteMasterService siteMasterService;

    @PostMapping("/createSite")
    public Response createSiteMaster(@RequestBody final SiteDto siteDto) {
        return siteMasterService.createSiteMaster(siteDto);
    }

    @GetMapping("/getSite")
    public Response getSite() {
        return siteMasterService.getSite();
    }

    @GetMapping("/getSiteById")
    public Response getSiteById(@RequestParam final Long siteId) {
        return siteMasterService.getSiteById(siteId, Constants.SITE);
    }

    @GetMapping("/getUserBySiteId")
    public Response getUserBySiteId(@RequestParam final Long siteId) {
        return siteMasterService.getSiteById(siteId, Constants.USER);
    }
}
