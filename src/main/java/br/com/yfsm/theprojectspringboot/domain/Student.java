package br.com.yfsm.theprojectspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private String cpf;
    private Integer age;
    private Boolean active;
    private String postalCode;
    @OneToMany(fetch = FetchType.EAGER)
    private Address adress;
}
