package com.jao.recetas.repository;

import com.jao.recetas.model.Navegacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NavegacionRepository extends JpaRepository<Navegacion, Integer> {
}
