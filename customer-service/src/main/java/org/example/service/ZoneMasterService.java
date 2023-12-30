package org.example.service;

import org.example.dto.Response;
import org.example.dto.ZoneDto;
import org.example.globalException.ZoneAlreadyExisits;
import org.example.globalException.ZoneNotFoundException;
import org.example.model.ZoneMaster;
import org.example.repository.ZoneMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZoneMasterService {

    @Autowired
    ZoneMasterRepository zoneMasterRepository;

    @Autowired
    ModelMapper mapper;

    public Response saveZone(ZoneDto zoneDto) {
        Optional<ZoneMaster> zoneMaster = zoneMasterRepository.findByZoneName(zoneDto.getZoneName());
        if (zoneMaster.isPresent()) {
            throw new ZoneAlreadyExisits();
        }
        zoneMasterRepository.save(mapper.map(zoneDto, ZoneMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.ZONE_CREATED_SCCUESSFULLY);
    }

    public Response getZoneById(Long id, String type) {
        Optional<ZoneMaster> zoneMaster = zoneMasterRepository.findById(id);
        if (!zoneMaster.isPresent()) {
            throw new ZoneNotFoundException();
        }
        if (!type.equals(Constants.USER)) {
           // zoneMaster.get().setUserDetails(null);
        }
        return new Response(HttpStatus.OK.value(), mapper.map(zoneMaster.get(), ZoneDto.class));
    }

    public Response getZone() {
        return new Response(HttpStatus.OK.value(), mapper.map(zoneMasterRepository.findAll(), ZoneDto[].class));
    }

}
