package com.niedz.ankiety.repository;

import com.niedz.ankiety.model.Rola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Role extends JpaRepository<Role, Integer> {
    Rola findByRola(String rola);
}
