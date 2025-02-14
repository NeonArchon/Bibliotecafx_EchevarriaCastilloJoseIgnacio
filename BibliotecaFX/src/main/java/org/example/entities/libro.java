package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class libro implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @Column(nullable = false)
    private String titulo;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column
    private String editorial;

    @Column(name = "anyo_publicacion")
    private int anioPublicacion;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private autor autor;

    @Column
    private boolean prestado;

    //constructor vacio
    public libro() {
    }

    //constructoer relleno


    public libro(Long ididLibro, String titulo, String isbn, String editorial, int anioPublicacion, autor autor, boolean prestado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
        this.prestado = prestado;
    }

    //getters y setters
    public Long getId() {
        return idLibro;
    }

    public void setId(Long id) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public autor getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
