package com.example.application.dao;



import com.example.application.backend.model.Categoria;

import java.util.List;

public interface CategoriaDAO {
    List<Categoria> findAllByNombre(String nombre, Integer paginacion, Integer limite);
    List<Categoria> findAll(Integer paginacion, Integer limite);
}
