package org.example.service;


import org.example.dto.LocalDto;
import org.example.dto.Response;
import org.example.dto.StateDto;
import org.example.globalException.LocalAlreadyExisitsException;
import org.example.globalException.LocalNotFoundException;
import org.example.globalException.StateAlreadyExisitsException;
import org.example.globalException.StateNotFoundException;
import org.example.model.LocalMaster;
import org.example.model.StateMaster;
import org.example.repository.StateMasterRespository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateMasterServcie {
    @Autowired
    StateMasterRespository stateMasterRespository;

    @Autowired
    ModelMapper mapper;


    public Response saveStateMaster(final StateDto stateDto) {
        Optional<StateMaster> stateMaster = stateMasterRespository.findByStateName(stateDto.getStateName());
        if (stateMaster.isPresent()) {
            throw new StateAlreadyExisitsException();
        }
        stateMasterRespository.save(mapper.map(stateDto, StateMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.STATE_CREATED_SUCCESSFULLY);

    }

    public Response getStateById(final Long pinId, String type) {
        Optional<StateMaster> stateMaster = stateMasterRespository.findById(pinId);
        if (!stateMaster.isPresent()) {
            throw new StateNotFoundException();
        }
        if (!type.equals(Constants.USER)) {
            stateMaster.get().setLocalMaster(null);
        }
        return new Response(HttpStatus.OK.value(), stateMaster.get());
    }

    public Response getStateDetails() {
        List<StateMaster> stateMaster = stateMasterRespository.findAll();
        if (stateMaster.isEmpty()) {
            throw new LocalNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(stateMaster, StateMaster[].class));
    }
}
