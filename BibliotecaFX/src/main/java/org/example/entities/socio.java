package org.example.entities;

import jakarta.persistence.*;
import org.example.entities.prestamo;

import java.io.Serializable;
import java.util.List;
@Entity
public class socio implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSocio;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String direccion;

    @Column
    private int telefono;

    @OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<prestamo> prestamos;

    //constructor vacio
    public socio() {
    }

    //constructor relleno

    public socio(Long idSocio, String nombre, String direccion, int telefono, List<prestamo> prestamos) {
        this.idSocio = idSocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.prestamos = prestamos;
    }

    //getters y setters
    public Long getId() {
        return idSocio;
    }

    public void setId(Long id) {
        this.idSocio = idSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<prestamo> prestamos) {
        this.prestamos = prestamos;
    }
}
