package com.niedz.ankiety.repository;

import com.niedz.ankiety.model.Rola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Role extends JpaRepository<Rola, Integer> {
    Rola findByRola(String rola);
}
