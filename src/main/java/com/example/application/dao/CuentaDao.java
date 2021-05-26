package com.example.application.dao;

import com.example.application.backend.model.Cuenta;


import java.util.List;
import java.util.Optional;

public interface CuentaDao {
    Optional<Cuenta> findCuentaByNumerocuenta(Long numerocuenta);

    List<Cuenta> findAll(Integer paginacion, Integer limite);

    List<Cuenta> findAccountsByUsuario(Long idUsuario);
}
