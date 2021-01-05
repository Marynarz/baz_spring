package com.niedz.ankiety.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Uzytkownik {
    @javax.persistence.Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer Id;

    @NotEmpty(message = "Podaj nazwe uzytkownika")
    @Length(min = 5, message = "Minimum 5 znakow")
    private String login;

    @NotEmpty(message = "Podaj adres meil")
    @Email(message = "Podaj prawdziwy mail")
    private String mail;

    @NotEmpty(message = "Podaj haslo")
    @Length(min = 5, message = "Min 5 znakow")
    private String password;

    private Boolean isActive;

    public Integer get_id() { return Id; }

    public String get_login() { return login; }

}
