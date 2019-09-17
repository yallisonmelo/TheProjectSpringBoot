package br.com.yfsm.theprojectspringboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "Value not Valid")
    private String name;
    @NotBlank(message = "Value not Valid")
    private String email;
    @NotBlank(message = "Value not Valid")
    private String password;



}
