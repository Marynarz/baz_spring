package com.niedz.ankiety.repository;

import com.niedz.ankiety.model.Ankietka;
import com.niedz.ankiety.model.Odpowiedz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Ankiety extends JpaRepository<Ankietka, Integer> {

    Iterable<Ankietka> findAllByTworca(Integer tworca);
    Optional<Ankietka> findById(Integer Id);
}
