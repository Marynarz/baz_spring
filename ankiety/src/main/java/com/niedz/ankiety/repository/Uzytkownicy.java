package com.niedz.ankiety.repository;

import com.niedz.ankiety.model.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Uzytkownicy extends JpaRepository<Uzytkownik, Integer> {
    Uzytkownik findByLogin(String login);
    Optional<Uzytkownik> findById(Integer Id);
}
