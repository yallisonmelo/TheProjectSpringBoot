package br.com.yfsm.theprojectspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private Boolean active;
    private String postalCode;
}
