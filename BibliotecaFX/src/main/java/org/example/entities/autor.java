package org.example.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class autor implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String nacionalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<libro> libros;

    //constructor vacio
    public autor() {
    }

    //constrcuttor relleno
    public autor(int idAutor, String nombre, String nacionalidad, List<libro> libros) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.libros = libros;
    }

    //getters y setters

    public int getId() {
        return idAutor;
    }

    public void setId(Long id) {
        this.idAutor = idAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<libro> getLibros() {
        return libros;
    }

    public void setLibros(List<libro> libros) {
        this.libros = libros;
    }
}
