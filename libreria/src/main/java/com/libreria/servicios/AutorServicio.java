package com.libreria.servicios;

import com.libreria.entidades.Autor;
import com.libreria.persistencia.AutorDAO;
import java.util.List;

public class AutorServicio {

    private AutorDAO autorDao = new AutorDAO();

    public void crearAutor(String nombre) throws Exception {

        try {
            if (nombre != "") {
                Autor autor = new Autor(nombre);
                autorDao.guardarAutor(autor);
                System.out.println("Autor creado exitosamente!");
            } else {
                throw new Exception("El nombre de Autor no puede estar vacio");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void modificarAutor(Long id, String nuevoNombre) {
        Autor autor = autorDao.buscarAutorPorId(id);
        if (autor != null) {
            autor.setNombre(nuevoNombre);
            autor.setAlta(true);
            autorDao.actualizarAutor(autor);
            System.out.println("Autor actualizado con éxito.");
        } else {
            System.out.println("No se encontró el autor.");
        }
    }

    public void eliminarAutorLogico(Long id) {
        Autor autor = autorDao.buscarAutorPorId(id);
        if (autor != null) {
            autor.setAlta(false);
            autorDao.actualizarAutor(autor);
            System.out.println("Autor eliminado con éxito.");
        } else {
            System.out.println("No se encontró el autor.");
        }
    }

    public void listarAutores() {
        List<Autor> autores = autorDao.listarAutores();
        if (autores != null) {
            for (Autor autor : autores) {
                System.out.println(autor.toString());

            }

        }

    }

}
