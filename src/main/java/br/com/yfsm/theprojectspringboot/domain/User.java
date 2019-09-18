package br.com.yfsm.theprojectspringboot.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInsert;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUpdate;


    public User(@NotBlank String name, @NotBlank String email, @NotBlank String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.setActive(true);
    }

    public String setHashPassword(String password) {
       return new StringBuilder(password).reverse().toString();

    }
}
