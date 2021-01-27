package com.niedz.ankiety.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Uzytkownik {
    @javax.persistence.Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name= "id_uzytkownika")
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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(joinColumns = @JoinColumn(name = "id_uzytkownika"), inverseJoinColumns = @JoinColumn(name = "id_roli"))
    private Set<Rola> rola;

    private Boolean isActive;

    // gettery
    public Integer getId() { return Id; }

    public String getLogin() { return login; }

    public String getPassword() { return password; }

    public String getMail() { return mail; }

    public Boolean getActive() { return isActive; }

    public Set<Rola> getRola() { return rola; }

    //settery
    public void setLogin(String login) { this.login = login; }

    public void setPassword(String password) { this.password = password; }

    public void setMail(String mail) { this.mail = mail; }

    public void setActive(Boolean active) { this.isActive = active; }

    public void setRola(Set<Rola> rola) { this.rola = rola; }

}
