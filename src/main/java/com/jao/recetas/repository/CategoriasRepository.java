package com.jao.recetas.repository;

import com.jao.recetas.dto.CategoriaResponse;
import com.jao.recetas.model.Categoria;
import com.jao.recetas.model.Recetas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository <Categoria, Integer> {

        @Query("""
            SELECT new com.jao.recetas.dto.CategoriaResponse(c.id, c.nombre, c.procedencia, c.tipoAlimento)
                FROM Categoria c
                WHERE c.id = :id
            """
        )
        Optional<CategoriaResponse> findCategoriaById(@Param("id") Integer id);

        @Query("""
                SELECT new com.jao.recetas.dto.CategoriaResponse(c.id, c.nombre, c.procedencia, c.tipoAlimento)
                    FROM Categoria c
                    WHERE c.nombre = :nombre
                """
        )
        Optional<CategoriaResponse> findOneByNombre(@Param("nombre") String nombre);

        @Query("""
                SELECT new com.jao.recetas.dto.CategoriaResponse(c.id, c.nombre, c.procedencia, c.tipoAlimento)
                    FROM Categoria c
                """
        )
        List<CategoriaResponse> findAllOrderByNombreAsc(Sort sort);

        @Query("""
                SELECT new com.jao.recetas.dto.CategoriaResponse(c.id, c.nombre, c.procedencia, c.tipoAlimento)
                    FROM Categoria c
                    WHERE UPPER(c.nombre) LIKE UPPER(CONCAT('%', :infix, '%'))
                    
                """
        )
        List<CategoriaResponse> findByNombreContainingIgnoreCaseOrderByNombreAsc(@Param("infix") String infix,Sort sort);


        @Query("""
                SELECT new com.jao.recetas.dto.CategoriaResponse(c.id, c.nombre, c.procedencia, c.tipoAlimento)
                    FROM Categoria c
                """
        )
        Page<CategoriaResponse> findAllCategoriasPage(Pageable pageable);
}