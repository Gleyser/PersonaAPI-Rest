package com.gleyser.personaapi.dto.request;

import com.gleyser.personaapi.entity.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    @Size(min = 2, max = 100)
    @NotEmpty
    private String firstName;

    @Size(min = 2, max = 100)
    @NotEmpty
    private String lastName;

    @CPF
    @NotEmpty
    private String cpf;

    @NotNull
    private String birthDate;

    @NotEmpty
    @Valid
    private List<Phone> phones;


}
