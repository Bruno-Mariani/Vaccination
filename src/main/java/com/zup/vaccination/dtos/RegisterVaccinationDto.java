package com.zup.vaccination.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVaccinationDto {

    @NotNull
    private String name;

    @NotNull
    private LocalDate vaccinationDate;

    @NotBlank
    @Email
    private String userEmail;

}
