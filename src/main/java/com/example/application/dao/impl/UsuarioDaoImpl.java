package com.example.application.dao.impl;

import com.example.application.backend.model.Usuario;
import com.example.application.backend.repository.UsuarioRepository;
import com.example.application.dao.UsuarioDao;
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
public class UsuarioDaoImpl implements UsuarioDao {
    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public Optional<Usuario> findUsuarioByNif(String nif) {
        if (nif != null) {
            CriteriaBuilder builder = manager.getCriteriaBuilder();
            CriteriaQuery<Usuario> criteria = builder.createQuery(Usuario.class);
            Root<Usuario> root = criteria.from(Usuario.class);
            criteria.select(root);
            criteria.where(builder.equal(root.get("nif"), nif));
            Usuario item = manager.createQuery(criteria).getSingleResult();
            System.out.println(item.getNif());
            manager.close();
            return Optional.of(item);

        }
        return Optional.empty();
    }

    @Override
    public List<Usuario> findAll(Integer paginacion, Integer limite) {
        return null;
    }



    @Override
    public List<Usuario> findAllByInterviniente(String interviniente, Integer paginacion, Integer limite) {
        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Usuario> criteriaQuery = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = criteriaQuery.from(Usuario.class);
        criteriaQuery.select(root);
        criteriaQuery.where(criteriaBuilder.like(root.get("interviniente"),interviniente + '%'));
        Query query = manager.createQuery(criteriaQuery);
        query.setMaxResults(limite);
        query.setFirstResult(paginacion);
        manager.close();
        return query.getResultList();
    }


}
