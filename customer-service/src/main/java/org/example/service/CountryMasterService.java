package org.example.service;

import org.example.dto.CountryDto;
import org.example.dto.Response;
import org.example.globalException.CountryNotFoundException;
import org.example.globalException.CountryAlreadyExisitsException;
import org.example.model.CountryMaster;
import org.example.repository.CountryMasterRepository;
import org.example.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryMasterService {

    @Autowired
    CountryMasterRepository countryMasterRepository;
    @Autowired
    ModelMapper mapper;

    public Response saveCountryMaster(final CountryDto countryDto) {
        Optional<CountryMaster> countryMaster = countryMasterRepository.findByCountryName(countryDto.getCountryName());
        if (countryMaster.isPresent()) {
            throw new CountryAlreadyExisitsException();
        }
        countryMasterRepository.save(mapper.map(countryDto, CountryMaster.class));
        return new Response(HttpStatus.OK.value(), Constants.COUNTRY_CREATED_SUCCESSFULLY);

    }

    public Response getCountryById(final Long countryId, String type) {
        Optional<CountryMaster> countryMaster = countryMasterRepository.findById(countryId);
        if (!countryMaster.isPresent()) {
            throw new CountryNotFoundException();
        }
        if (!type.equals(Constants.USER)) {
            countryMaster.get().setUserDetails(null);
        }
        return new Response(HttpStatus.OK.value(), countryMaster.get());
    }

    public Response getCountryDetails() {
        List<CountryMaster> countryMaster = countryMasterRepository.findAll();
        if (countryMaster.isEmpty()) {
            throw new CountryNotFoundException();
        }
        return new Response(HttpStatus.OK.value(), mapper.map(countryMaster, CountryDto[].class));
    }
}
