package org.example.service;

import org.example.dto.CustomerDto;
import org.example.dto.Response;
import org.example.dto.UtilityDto;
import org.example.globalException.InternalException;
import org.example.globalException.UtilityExisitsException;
import org.example.globalException.UtilityNotFoundException;
import org.example.model.CustomerDetails;
import org.example.model.UtilityMaster;
import org.example.repository.UtilityMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UtilityMasterService {

    @Autowired
    public ModelMapper mapper;
    @Autowired
    public UtilityMasterRepository utilityMasterRepository;

    public Response saveUtility(final UtilityDto utilityRequestDto) throws SQLException {
        Optional<UtilityMaster> utilityMaster = utilityMasterRepository.findByUtilityName(utilityRequestDto.getUtilityName());
        if (utilityMaster.isPresent()) {
            throw new UtilityExisitsException();
        }
        try {
            utilityMasterRepository.save(mapper.map(utilityRequestDto, UtilityMaster.class));
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return new Response(HttpStatus.OK.value(), Constants.UTILITY_CREATED_SCCUESSFULLY);
    }

    public Response getUtilityById(final Long id, String type) {
        Optional<UtilityMaster> utilityMaster = utilityMasterRepository.findById(id);
        if (!utilityMaster.isPresent()) {
            throw new UtilityNotFoundException();
        }
        if (!Constants.USER.equals(type)) {
            utilityMaster.get().setUserDetail(null);
        }
        return new Response(HttpStatus.OK.value(), mapper.map(utilityMaster.get(), UtilityDto.class));

    }

    public Response getUtility() {
        List<UtilityMaster> utilityMaster = utilityMasterRepository.findAll();
        if (utilityMaster.isEmpty()) {
            throw new UtilityNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), Arrays.asList(mapper.map(utilityMaster, UtilityDto[].class)));

    }

}
