package org.example.DAO;

import org.example.entities.socio;
import java.util.List;

public interface itfSocio {

    void agregarSocio(socio socio);
    void modificarSocio(socio socio);
    void eliminarSocio(Long idSocio);
    socio socioPorNombre(String nombre);
    socio socioPorTelefono(String telefono);
    List<socio> listarSocios();

}
