package br.com.yfsm.theprojectspringboot.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "user")
public class User {

    @Id
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private Boolean active = true;
    @NotBlank
    private Date dateInsert;
    private Date dateUpdate;
}
