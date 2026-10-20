package com.jao.recetas.services;

import com.jao.recetas.dto.CategoriaPage;
import com.jao.recetas.dto.RecetaRequest;
import com.jao.recetas.dto.RecetaResponse;
import com.jao.recetas.dto.RecetasPage;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface RecetasService {
    Optional<RecetaResponse> findRecetaById(Integer id);
    Optional<RecetaResponse> findOneByTitulo(String titulo);
    List<RecetaResponse> findAllOrderByTituloAsc();
    List<RecetaResponse> findByNombreContainingIgnoreCaseOrderByTituloAsc( String infix);
    List<RecetaResponse> findByCategoriaIdOrderByTituloAsc( Integer categoriaId);
    RecetasPage findAllRecetasPage(int pageNumber, int pageSize, String sortField, String sortDir);
    long countByCategoriaId(Integer categoriaId);
    RecetaResponse createReceta(RecetaRequest request);
    RecetaResponse updateReceta(Integer id, RecetaRequest request);
    boolean deleteReceta(Integer id);
}
