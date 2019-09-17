package br.com.yfsm.theprojectspringboot.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Boolean active;
    @CreatedDate
    private Date dateInsert = new Date();
    @LastModifiedDate
    private Date dateUpdate;


    public User(@NotBlank String name, @NotBlank String email, @NotBlank String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.setActive(true);
    }
}
