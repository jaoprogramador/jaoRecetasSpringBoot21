package com.jao.recetas.controller;

import com.jao.recetas.dto.CategoriaPage;
import com.jao.recetas.dto.RecetaRequest;
import com.jao.recetas.dto.RecetaResponse;
import com.jao.recetas.dto.RecetasPage;
import com.jao.recetas.model.Recetas;
import com.jao.recetas.services.RecetasService;
import com.jao.recetas.util.exception.InvalidDataException;
import com.jao.recetas.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recetas")
@RequiredArgsConstructor
public class RecetasController {

    private final RecetasService recetasService;

    @GetMapping()
    public ResponseEntity <?> getAll(){
        List<RecetaResponse> recetas= this.recetasService.findAllOrderByTituloAsc();
        if (recetas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recetas);
    }


    @GetMapping(value ="/{id}")
    public ResponseEntity <?> getRecetasById(@PathVariable Integer id){
        Optional<RecetaResponse> recetas = recetasService.findRecetaById(id);
        if (recetas.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la receta con id "+id);
        }
        return ResponseEntity.ok(recetas.get()) ;
    }

    @GetMapping("/search/{infix}")
    public ResponseEntity<?> findByTituloContaining(@PathVariable String infix) {
        List<RecetaResponse> recetas = this.recetasService.findByNombreContainingIgnoreCaseOrderByTituloAsc(infix);
        if (recetas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(recetas);
    }

    @GetMapping("/page")
    public ResponseEntity<?> findRecetasPage(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize,
            @RequestParam(name = "sortField", required = false, defaultValue = "titulo") String sortField,
            @RequestParam(name = "sortDir", required = false, defaultValue = "asc") String sortDir) {

        RecetasPage recetasPage = this.recetasService.findAllRecetasPage(pageNumber, pageSize, sortField, sortDir);
        if (recetasPage.getRecetas().isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(recetasPage);
    }

    @PostMapping()
    public ResponseEntity <?> create(@RequestBody RecetaRequest recetaRequest) {
        try {
            RecetaResponse receta = this.recetasService.createReceta(recetaRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(receta);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ha ocurrido un error inesperado");
        }

    }

    @PutMapping(value ="/{id}")
    public ResponseEntity <?> update(@PathVariable Integer id, @RequestBody RecetaRequest recetaRequest){
        try {
            RecetaResponse receta = this.recetasService.createReceta(recetaRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(receta);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ha ocurrido un error inesperado");
        }
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity <String> detete(@PathVariable Integer id){
        if(this.recetasService.deleteReceta(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la receta con id "+id);

    }

}
