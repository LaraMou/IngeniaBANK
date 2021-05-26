package com.example.application.backend.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categoria extends AbstractEntity{


    @Column(name = "nombre" , nullable = false, unique = true)

    private String nombre;



    @OneToMany(mappedBy = "categoria")
    private List<Movimiento> movimientos = new ArrayList<>();

    public Categoria() {
    }


    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }


}
