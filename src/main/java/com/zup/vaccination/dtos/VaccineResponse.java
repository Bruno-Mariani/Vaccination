package com.zup.vaccination.dtos;

import com.zup.vaccination.models.Vaccine;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public class VaccineResponse {

    private Long id;

    private String name;

    private LocalDate vaccinationDate;

    private UserResponse user;

    public static VaccineResponse from(Vaccine vaccine) {
        return new VaccineResponse(
                vaccine.getId(),
                vaccine.getName(),
                vaccine.getVaccinationDate(),
                UserResponse.from(vaccine.getUser())
        );

    }
}
