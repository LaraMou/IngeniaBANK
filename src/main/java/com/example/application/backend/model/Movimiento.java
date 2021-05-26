package com.example.application.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Movimiento extends AbstractEntity {

    @Column(name="importe" , nullable = false)
    private Double importe;

    @Column(name="fecha" , nullable = false)

    private LocalDateTime fecha;

    @Column(name="fecha_valor" , nullable = false)

    private LocalDateTime fechaValor;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="concepto")
    private String concepto;

    /**
     * Relación Categorias y movimientos n-1
     */
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
     private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numerocuenta")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Double importe, LocalDateTime fecha, LocalDateTime fechaValor, String descripcion, String concepto) {
        this.importe = importe;
        this.fecha = fecha;
        this.fechaValor = fechaValor;
        this.descripcion = descripcion;
        this.concepto = concepto;
    }



    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getFechaValor() {
        return fechaValor;
    }

    public void setFechaValor(LocalDateTime fechaValor) {
        this.fechaValor = fechaValor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
                "importe=" + importe +
                ", fecha=" + fecha +
                ", fechaValor=" + fechaValor +
                ", descripcion='" + descripcion + '\'' +
                ", concepto='" + concepto + '\'' +
                '}';
    }
}
