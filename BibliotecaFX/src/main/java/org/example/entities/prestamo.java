package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class prestamo implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private libro libro;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private org.example.entities.socio socio;

    //constructor vacio
    public prestamo() {
    }

    //constructor relleno
    public prestamo(Long idPrestamo, LocalDate fechaPrestamo, LocalDate fechaDevolucion, org.example.entities.libro libro, org.example.entities.socio socio) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.socio = socio;
    }

    //getters y setters
    public Long getId() {
        return idPrestamo;
    }

    public void setId(Long id) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public org.example.entities.libro getLibro() {
        return libro;
    }

    public void setLibro(org.example.entities.libro libro) {
        this.libro = libro;
    }

    public org.example.entities.socio getSocio() {
        return socio;
    }

    public void setSocio(org.example.entities.socio socio) {
        this.socio = socio;
    }
}
