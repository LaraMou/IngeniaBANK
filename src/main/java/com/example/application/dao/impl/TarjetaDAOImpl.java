package com.example.application.dao.impl;

import com.example.application.backend.model.Cuenta;
import com.example.application.backend.model.Tarjeta;
import com.example.application.backend.repository.TarjetaRepository;
import com.example.application.dao.TarjetaDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class TarjetaDAOImpl implements TarjetaDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public Tarjeta createTarjeta(Tarjeta tarjeta){
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta updateTarjeta(Tarjeta tarjeta){
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public void deleteTarjeta(Long numeroTarjeta ){
        tarjetaRepository.delete(manager.find(Tarjeta.class,numeroTarjeta));}


    @Override
    public List<Tarjeta> findTarjetas() {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tarjeta> criteria = builder.createQuery(Tarjeta.class);
        Root<Tarjeta> root = criteria.from(Tarjeta.class);
        criteria.select(root);

        Query query = manager.createQuery(criteria);

        List<Tarjeta> tarjetas = query.getResultList();

        return tarjetas;
    }

    @Override
    public Optional<Tarjeta> findOneTarjeta(Long numeroTarjeta) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tarjeta> criteria = builder.createQuery(Tarjeta.class);
        Root<Tarjeta> root =     criteria.from(Tarjeta.class);

        criteria.select(root);
        criteria.where(builder.equal(root.get("numeroTarjeta"), numeroTarjeta));
        return Optional.of(manager.createQuery(criteria).getSingleResult());
    }


    @Override
    public List<Tarjeta> findTarjetasByCuenta(Long numeroCuenta) {
        Cuenta cuentabd = manager.find(Cuenta.class,numeroCuenta);
        if (cuentabd != null) {
            return cuentabd.getListaTarjetas();
        }
        else{
            return null;
        }

    }

}
