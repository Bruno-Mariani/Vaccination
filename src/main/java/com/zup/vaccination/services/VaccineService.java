package com.zup.vaccination.services;

import com.zup.vaccination.dtos.RegisterVaccinationDto;
import com.zup.vaccination.exceptions.UserNotFoundException;
import com.zup.vaccination.models.User;
import com.zup.vaccination.models.Vaccine;
import com.zup.vaccination.repositories.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;
    @Autowired
    private UserService userService;

    public Vaccine registerVaccination(RegisterVaccinationDto vaccinationDto) throws UserNotFoundException {

        Optional<User> userFound = userService.findByEmail(vaccinationDto.getUserEmail());

        if (!userFound.isPresent()) {
            throw new UserNotFoundException();
        }

        Vaccine vaccine = new Vaccine(
                null,
                vaccinationDto.getName(),
                vaccinationDto.getVaccinationDate(),
                userFound.get()
        );

        return this.vaccineRepository.save(vaccine);
    }
}