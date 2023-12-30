package org.example.service;

import org.example.dto.LocalDto;
import org.example.dto.Response;
import org.example.globalException.LocalAlreadyExisitsException;
import org.example.globalException.LocalNotFoundException;
import org.example.model.LocalMaster;
import org.example.repository.LocalMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalMasterService {


    @Autowired
    LocalMasterRepository localMasterRepository;
    @Autowired
    ModelMapper mapper;


    public Response saveLocalMaster(final LocalDto localDto) {
        Optional<LocalMaster> pinMaster = localMasterRepository.findByLocalName(localDto.getLocalName());
        if (pinMaster.isPresent()) {
            throw new LocalAlreadyExisitsException();
        }
        localMasterRepository.save(mapper.map(localDto, LocalMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.LOCAL_CREATED_SUCCESSFULLY);

    }

    public Response getLocalById(final Long pinId, String type) {
        Optional<LocalMaster> localMaster = localMasterRepository.findById(pinId);
        if (!localMaster.isPresent()) {
            throw new LocalNotFoundException();
        }
        if (!type.equals(Constants.USER)) {
            localMaster.get().setUserDetails(null);
            localMaster.get().setCityMaster(null);
        }
        return new Response(HttpStatus.OK.value(), localMaster.get());
    }

    public Response getLocalDetails() {
        List<LocalMaster> localMaster = localMasterRepository.findAll();
        if (localMaster.isEmpty()) {
            throw new LocalNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(localMaster, LocalDto[].class));
    }
}
