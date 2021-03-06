package com.niedz.ankiety.repository;

import com.niedz.ankiety.model.Pytanie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Pytania extends JpaRepository<Pytanie, Integer> {

    Iterable<Pytanie> findAllByIdAnkiety(Integer id_ankiety);
    Optional<Pytanie> findById(Integer Id);
}
