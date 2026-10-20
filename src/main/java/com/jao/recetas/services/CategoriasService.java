package com.jao.recetas.services;

import com.jao.recetas.dto.CategoriaPage;
import com.jao.recetas.dto.CategoriaRequest;
import com.jao.recetas.dto.CategoriaResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface CategoriasService {
    Optional<CategoriaResponse> findCategoriaById(Integer id);
    Optional<CategoriaResponse> findOneByNombre(String nombre);
    List<CategoriaResponse> findAllOrderByNombreAsc();
    List<CategoriaResponse> findByNombreContainingIgnoreCaseOrderByNombreAsc( String infix);
    CategoriaPage findAllCategoriasPage(int pageNumber, int pageSize, String sortField, String sortDir);
    CategoriaResponse createCategoria(CategoriaRequest request);
    CategoriaResponse updateCategoria(Integer id, CategoriaRequest request);
    boolean deleteCategoria(Integer id);

}
