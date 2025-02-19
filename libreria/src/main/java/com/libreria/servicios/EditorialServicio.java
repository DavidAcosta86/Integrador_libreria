package com.libreria.servicios;

import com.libreria.persistencia.EditorialDAO;

import java.util.List;

import com.libreria.entidades.Editorial;

public class EditorialServicio {

    private EditorialDAO ediDAO = new EditorialDAO();

    public void crearEditorial(String nombreEditorial) {

        if (nombreEditorial != "") {
            Editorial edit = new Editorial(nombreEditorial);
            ediDAO.crearEditorial(edit);
            System.out.println("Editorial " + nombreEditorial + " Creada exitosamente!");
        } else {
            System.out.println("El nombre de la editorial no puede ser vacio!");
        }
    }

    public void modificarEditorial(Long id, String nombreNuevoEditorial) {
        Editorial cambio = ediDAO.buscarEditorial(id);
        if (cambio == null) {
            System.out.println("No se puede modificar una Editorial inexistente");
        } else {
            cambio.setNombre(nombreNuevoEditorial);
            ediDAO.modificarEditorial(cambio);
            System.out.println("Editorial actualizada");
        }
    }

    public void borradoLogicoEditorial(Long id) {
        Editorial cambio = ediDAO.buscarEditorial(id);
        if (cambio == null) {
            System.out.println("No se puede eliminar una Editorial inexistente");
        } else {
            cambio.setAlta(false);
            ediDAO.modificarEditorial(cambio);
            System.out.println("Editorial eliminada logicamente");
        }
    }

    public void listarEditoriales() {
        List<Editorial> editoriales = ediDAO.listarEditoriales();
        if (editoriales != null) {

            for (Editorial editorial : editoriales) {
                System.out.println(editorial.toString());
            }
        }
    }

}
