package com.example.application.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario extends AbstractEntity{




    @Column(nullable = false,unique = true)
    private String nif;
    //Datos personales

    @NotNull
    @Column(nullable = false)
    private String nombre;

    @NotNull
    @Column(name="primerapellido", nullable = false)
    private String primerapellido;

    @Column(name="segundoapellido")
    private String segundoapellido;


    @Column(name="fecha_nacimiento")
    private LocalDate fechanacimiento;

    //Datos contacto
    @NotNull

    @Column(name="telefono", nullable = false)
    private Long telefono;

    @Email
    @NotNull
    @Size(min = 5, max = 254)
    @Column(name="email",length = 254, unique = true,nullable = false)
    private String email;
    //Datos domicilio
    @NotNull
    @Column(name="ciudad")
    private String ciudad;
    @NotNull
    @Column(name="direccion")
    private String direccion;
    @NotNull
    @Column(name="codigo_postal")
    private Long codigopostal;
    @NotNull
    @Column(name="pais_origen")
    private String pais;
    //Otros datos


    @Column(name="interviniente")
    private Interviniente interviniente;

    @Column(name="ocupacion")
    private String ocupacion;


    @Column(name="genero")
    private String genero;


    /**
     * Auditory Attributes
     */

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    private Instant lastModifiedDate = Instant.now();


    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REFRESH})

    @JoinTable(
            name = "usuario_cuenta",
            joinColumns = {@JoinColumn(name="usuario_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="cuenta_id", referencedColumnName = "numerocuenta")}
    )
    @JsonIgnoreProperties("usuarios")
    private List<Cuenta> cuentas = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(String nif, String nombre, String primerapellido, String segundoapellido, LocalDate fechanacimiento, Long telefono, String email, Interviniente interviniente) {
        this.nif = nif;
        this.nombre = nombre;
        this.primerapellido = primerapellido;
        this.segundoapellido = segundoapellido;
        this.fechanacimiento = fechanacimiento;
        this.telefono = telefono;
        this.email = email;
        this.interviniente = interviniente;
    }


    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Interviniente getInterviniente() {
        return interviniente;
    }

    public void setInterviniente(Interviniente interviniente) {
        this.interviniente = interviniente;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(Long codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primerapellido='" + primerapellido + '\'' +
                ", segundoapellido='" + segundoapellido + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", interviniente=" + interviniente +
                '}';
    }
}
