package com.example.template.repositories;

import com.example.template.model.Copia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopiaRepository extends JpaRepository<Copia,Long> {
}
