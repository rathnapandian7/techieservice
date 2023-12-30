package org.example.service;


import org.example.dto.Response;
import org.example.dto.SiteDto;
import org.example.globalException.SiteAlreadyExisitsException;
import org.example.globalException.SiteNotFoundException;
import org.example.model.SiteMaster;
import org.example.repository.SiteMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class SiteMasterService {

    @Autowired
    SiteMasterRepository siteMasterRepository;
    @Autowired
    ModelMapper mapper;

    public Response createSiteMaster(final SiteDto siteDto) {
        Optional<SiteMaster> siteMaster = siteMasterRepository.findBySiteName(siteDto.getSiteName());
        if (siteMaster.isPresent()) {
            throw new SiteAlreadyExisitsException();
        }
        try {
            siteMasterRepository.save(mapper.map(siteDto, SiteMaster.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Response(HttpStatus.OK.value(), Constants.SITE_ALREADY_EXISTS);


    }

    public Response getSite() {
        List<SiteMaster> siteMasterList = siteMasterRepository.findAll();
        return new Response(HttpStatus.OK.value(), mapper.map(siteMasterList, SiteMaster[].class));
    }

    public Response getSiteById(final Long siteId, String type) {
        Optional<SiteMaster> siteMaster = siteMasterRepository.findById(siteId);
        if (!siteMaster.isPresent()) {
            throw new SiteNotFoundException();
        }
        if (type.equals(Constants.SITE)) {
            siteMaster.get().setUserDetails(null);
        }
        return new Response(HttpStatus.OK.value(), siteMasterRepository.findById(siteId).get());
    }

}
