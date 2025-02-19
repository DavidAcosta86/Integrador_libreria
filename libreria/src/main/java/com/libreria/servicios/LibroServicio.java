package com.libreria.servicios;

import com.libreria.entidades.Libro;
import com.libreria.entidades.Autor;
import com.libreria.entidades.Editorial;
import com.libreria.persistencia.LibroDAO;
import java.util.List;

public class LibroServicio {

    private LibroDAO libroDao = new LibroDAO();

    // Crear un libro
    public void crearLibro(Long isbn, String titulo, Integer anio, Integer ejemplares, Autor autor, Editorial editorial)
            throws Exception {
        try {
            if (isbn != null && !titulo.isEmpty() && anio != null && ejemplares != null && autor != null
                    && editorial != null) {
                Libro libro = new Libro(isbn, titulo, anio, ejemplares, true, autor, editorial);
                libroDao.guardarLibro(libro);
                System.out.println("Libro creado exitosamente!");
            } else {
                throw new Exception("Los campos del libro no pueden estar vacíos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Modificar un libro
    public void modificarLibro(Long isbn, String nuevoTitulo, Integer nuevoAnio, Integer nuevosEjemplares) {
        Libro libro = libroDao.buscarLibroPorIsbn(isbn);
        if (libro != null) {
            libro.setTitulo(nuevoTitulo);
            libro.setAnio(nuevoAnio);
            libro.setEjemplares(nuevosEjemplares);
            libroDao.actualizarLibro(libro);
            System.out.println("Libro actualizado con éxito.");
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    // Eliminar un libro (marcar como no disponible)
    public void eliminarLibroLogico(Long isbn) {
        Libro libro = libroDao.buscarLibroPorIsbn(isbn);
        if (libro != null) {
            libro.setAlta(false);
            libroDao.actualizarLibro(libro);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    // Listar todos los libros
    public void listarLibros() {
        List<Libro> libros = libroDao.listarLibros();
        if (libros != null) {
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
        }
    }

    // Buscar un libro por ISBN
    public Libro buscarLibroPorIsbn(Long isbn) {
        return libroDao.buscarLibroPorIsbn(isbn);
    }

    // Buscar libros por título
    public List<Libro> buscarLibroPorTitulo(String titulo) {
        return libroDao.buscarLibroPorTitulo(titulo);
    }

    // Buscar libros por autor
    public List<Libro> buscarLibroPorAutor(Autor autor) {
        return libroDao.buscarLibroPorAutor(autor);
    }

    // Buscar libros por editorial
    public List<Libro> buscarLibroPorEditorial(Editorial editorial) {
        return libroDao.buscarLibroPorEditorial(editorial);
    }
}