package org.example.DAO;

import org.example.entities.prestamo;

import java.util.List;

public interface itfPrestamo {

    void registrarPrestamo(prestamo prestamo);
    List<prestamo> HistorialPrestamosActuales();
    List<prestamo> HistorialPrestamosSocio(Long idSocio);

}
