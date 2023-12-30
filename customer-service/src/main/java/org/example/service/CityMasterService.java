package org.example.service;

import org.example.dto.CityDto;
import org.example.dto.Response;
import org.example.dto.StateDto;
import org.example.globalException.*;
import org.example.model.CityMaster;
import org.example.model.StateMaster;
import org.example.repository.CityMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityMasterService {

    @Autowired
    CityMasterRepository cityMasterRepository;

    @Autowired
    ModelMapper mapper;


    public Response saveCityMaster(final CityDto cityDto) {
        Optional<CityMaster> cityMaster = cityMasterRepository.findByCityName(cityDto.getCityName());
        if (cityMaster.isPresent())
            throw new CityAlreadyExisitsException();

        cityMasterRepository.save(mapper.map(cityDto, CityMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.CITY_CREATED_SUCCESSFULLY);

    }

    public Response getCityById(final Long cityId, String type) {
        Optional<CityMaster> cityMaster = cityMasterRepository.findById(cityId);
        if (!cityMaster.isPresent()) {
            throw new CityNotFoundException();
        }
        if (!type.equals(Constants.USER)) {
            cityMaster.get().setLocalMaster(null);
        }
        return new Response(HttpStatus.OK.value(), cityMaster.get());
    }

    public Response getCityDetails() {
        List<CityMaster> cityMaster = cityMasterRepository.findAll();
        if (cityMaster.isEmpty()) {
            throw new CityNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(cityMaster, CityMaster[].class));
    }
}
