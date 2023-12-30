package org.example.globalException;

import org.example.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Object> handleRoleException(RoleNotFoundException roleNotFoundException, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.ROLE_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RoleAlreadyExisitsException.class)
    public ResponseEntity<Object> handleRoleExistsException(RoleAlreadyExisitsException roleAlreadyExisitsException, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.ROLE_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(UserExisitsException.class)
    public ResponseEntity<Object> handleUserException(UserExisitsException roleNotFoundException, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.USER_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(CustomerExisitsException.class)
    public ResponseEntity<Object> handleCustomerException(CustomerExisitsException customerExisitsException, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.CUSTOMER_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);

    }

    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<Object> handleCustomerNotFound() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.CUSTOMER_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFound() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.USER_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<Object> handleInternalException(Exception exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.INTERNAL_ERROR + exception);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UtilityNotFoundException.class)
    public ResponseEntity<Object> handleUtilyException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.UTLITY_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UtilityExisitsException.class)
    public ResponseEntity<Object> handleUtilyExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.UTILITY_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SiteNotFoundException.class)
    public ResponseEntity<Object> handleSiteNotFoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.SITE_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SiteAlreadyExisitsException.class)
    public ResponseEntity<Object> handleSiteExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.SITE_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ZoneNotFoundException.class)
    public ResponseEntity<Object> handleZoneNotfoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.ZONE_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ZoneAlreadyExisits.class)
    public ResponseEntity<Object> handleZoneExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.ZONE_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PinAlreadyExisitsException.class)
    public ResponseEntity<Object> handlePinExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.PIN_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(PinNotFoundException.class)
    public ResponseEntity<Object> handlePinNotFoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.PIN_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<Object> handleCountryNotFoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.COUNTRY_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CountryAlreadyExisitsException.class)
    public ResponseEntity<Object> handleCountryExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.COUNTRY_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(LocalNotFoundException.class)
    public ResponseEntity<Object> handleLocalNotFoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.LOCAL_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LocalAlreadyExisitsException.class)
    public ResponseEntity<Object> handleLocalExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.LOCAL_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StateNotFoundException.class)
    public ResponseEntity<Object> handleStateNotFoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.STATE_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StateAlreadyExisitsException.class)
    public ResponseEntity<Object> handleStateExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.STATE_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<Object> handleCityNotFoundException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.CITY_NOT_FOUND);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityAlreadyExisitsException.class)
    public ResponseEntity<Object> handleCityExisitsException() {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(Constants.CITY_ALREADY_EXISTS);
        response.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
