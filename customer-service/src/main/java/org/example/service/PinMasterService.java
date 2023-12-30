package org.example.service;


import org.example.dto.PinDto;
import org.example.dto.Response;
import org.example.globalException.PinAlreadyExisitsException;
import org.example.globalException.PinNotFoundException;
import org.example.model.PinMaster;
import org.example.repository.PinMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinMasterService {
    @Autowired
    PinMasterRepository pinMasterRepository;

    @Autowired
    ModelMapper mapper;

    public Response savePinMaster(final PinDto pinDto) {
        Optional<PinMaster> pinMaster = pinMasterRepository.findByPinName(pinDto.getPinName());
        if (pinMaster.isPresent()) {
            throw new PinAlreadyExisitsException();
        }
        pinMasterRepository.save(mapper.map(pinDto, PinMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.PIN_CREATED_SUCCESSFULLY);

    }

    public Response getPinById(final Long pinId, String type) {
        Optional<PinMaster> pinMaster = pinMasterRepository.findById(pinId);
        if (!pinMaster.isPresent()) {
            throw new PinNotFoundException();
        }
        if (!type.equals(Constants.USER)) {
            pinMaster.get().setZoneMaster(null);
        }
        return new Response(HttpStatus.OK.value(), pinMaster.get());
    }

    public Response getPinDetails() {
        List<PinMaster> pinMaster = pinMasterRepository.findAll();
        if (pinMaster.isEmpty()) {
            throw new PinNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(pinMaster, PinDto[].class));
    }
}
