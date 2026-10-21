package com.jao.recetas.services;

import com.jao.recetas.dto.CategoriaPage;
import com.jao.recetas.dto.CategoriaRequest;
import com.jao.recetas.dto.CategoriaResponse;
import com.jao.recetas.model.Categoria;
import com.jao.recetas.repository.CategoriasRepository;
import com.jao.recetas.util.exception.InvalidOperationException;
import com.jao.recetas.util.exception.ResourceNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriasServiceImpl implements CategoriasService{

    private final CategoriasRepository categoriasRepository;
    @Override
    public Optional<CategoriaResponse> findCategoriaById(Integer id) {
        return this.categoriasRepository.findCategoriaById(id);
    }

    @Override
    public Optional<CategoriaResponse> findOneByNombre(String nombre) {
        return this.categoriasRepository.findOneByNombre(nombre);
    }



    @Override
    public List<CategoriaResponse> findAllOrderByNombreAsc() {
        Sort sort = Sort.by("nombre").ascending();
        return this.categoriasRepository.findAllOrderByNombreAsc(sort);
    }

    @Override
    public List<CategoriaResponse> findByNombreContainingIgnoreCaseOrderByNombreAsc(String infix) {
        Sort.Order order = Sort.Order.by("nombre")
                .with(Sort.Direction.ASC)
                .ignoreCase();
        Sort sort = Sort.by(order);
        return this.categoriasRepository.findByNombreContainingIgnoreCaseOrderByNombreAsc(infix,sort);
    }

    @Override
    public CategoriaPage findAllCategoriasPage(int pageNumber, int pageSize, String sortField, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase("asc") ?
                Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<CategoriaResponse> pagina = this.categoriasRepository.findAllCategoriasPage(pageable);
        return new CategoriaPage(pagina.getContent(), pageNumber, pageSize, pagina.getTotalPages(), pagina.getTotalElements(),pagina.isLast());
    }

    @Override
    public CategoriaResponse createCategoria(CategoriaRequest request) {
        Optional<CategoriaResponse> categoriaDB = this.findOneByNombre(request.getNombre());
        if (categoriaDB.isPresent()) {
            return categoriaDB.get();
        }

        Categoria categoria = new Categoria(request);
        Categoria categoriaNueva = this.categoriasRepository.save(categoria);

        return new CategoriaResponse(categoriaNueva);
    }

    @Override
    public CategoriaResponse updateCategoria(Integer id, CategoriaRequest request) {
        Optional<CategoriaResponse> categoriaDB = this.findCategoriaById(id);
        if (categoriaDB.isEmpty()) {
            throw new ResourceNotFoundException("No se puede efectuar la modificación, la categoria no existe");
        }

        Optional<CategoriaResponse> otraCategoria = this.categoriasRepository.findOneByNombre(request.getNombre());
        if (otraCategoria.isPresent() && !categoriaDB.get().getId().equals(otraCategoria.get().getId())) {
            throw new InvalidOperationException("No se puede modificar la categoría porque existe otra con el mismo nombre");
        }

        Categoria categoria = new Categoria(id, request.getNombre());
        Categoria categoriaModificada = this.categoriasRepository.save(categoria);

        return new CategoriaResponse(categoriaModificada);
    }

    @Override
    public boolean deleteCategoria(Integer id) {
        return false;
    }
}
