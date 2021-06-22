package com.zup.vaccination.dtos;

import com.zup.vaccination.models.Vaccine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    private LocalDate dayOfBirth;

    @NotNull
    private List<Vaccine> vaccines;

}
