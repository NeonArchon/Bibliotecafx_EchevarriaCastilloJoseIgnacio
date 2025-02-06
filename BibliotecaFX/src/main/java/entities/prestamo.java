package entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class prestamo implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private libro libro;

    @ManyToOne
    @JoinColumn(name = "socio_id", nullable = false)
    private socio socio;

    //constructor vacio
    public prestamo() {
    }

    //constructor relleno
    public prestamo(Long id, LocalDate fechaPrestamo, LocalDate fechaDevolucion, entities.libro libro, entities.socio socio) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.socio = socio;
    }

    //getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public entities.libro getLibro() {
        return libro;
    }

    public void setLibro(entities.libro libro) {
        this.libro = libro;
    }

    public entities.socio getSocio() {
        return socio;
    }

    public void setSocio(entities.socio socio) {
        this.socio = socio;
    }
}
