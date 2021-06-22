package com.zup.vaccination.controllers;

import com.zup.vaccination.dtos.RegisterVaccinationDto;
import com.zup.vaccination.dtos.VaccineResponse;
import com.zup.vaccination.exceptions.UserNotFoundException;
import com.zup.vaccination.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/vaccines")
public class VaccineController {
    @Autowired
    private VaccineService vaccineService;

    @PostMapping()
    public ResponseEntity<VaccineResponse> register(@RequestBody @Valid RegisterVaccinationDto vaccinationDto) throws UserNotFoundException {
        return new ResponseEntity<>(
                VaccineResponse.from(this.vaccineService.registerVaccination(vaccinationDto)),
                HttpStatus.CREATED
        );
    }
}

