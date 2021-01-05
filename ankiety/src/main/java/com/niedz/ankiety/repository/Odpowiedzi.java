package com.niedz.ankiety.repository;

import com.niedz.ankiety.model.Odpowiedz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Odpowiedzi extends JpaRepository<Odpowiedz, Integer> {
    Iterable<Odpowiedz> findAllById_pytania(Integer pytanie);
    Optional<Odpowiedz> findById(Integer Id);
}
