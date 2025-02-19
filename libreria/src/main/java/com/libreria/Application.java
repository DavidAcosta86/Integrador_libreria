package com.libreria;

import java.util.List;

import com.libreria.entidades.Autor;
import com.libreria.entidades.Editorial;
import com.libreria.entidades.Libro;
import com.libreria.servicios.AutorServicio;
import com.libreria.servicios.EditorialServicio;
import com.libreria.servicios.LibroServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
        EntityManager em = emf.createEntityManager();

        // pruebaAutor();
        // pruebaEditorial();

        // Crear Autor y Editorial
        AutorServicio autorServicio = new AutorServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        Autor autor = new Autor("Gabriel García Márquez");
        Editorial editorial = new Editorial("Editorial Sudamericana");

        // // Guardar Autor y Editorial primero
        try {
            autorServicio.crearAutor(autor.getNombre());

        } catch (Exception e) {
            // // TODO: handle exception
        }
        editorialServicio.crearEditorial(editorial.getNombre());
        pruebaLibro(autor, editorial);
    }

    public static void pruebaLibro(Autor autor, Editorial editorial) {
        // Crear instancias de servicio y objetos necesarios
        LibroServicio libroServicio = new LibroServicio();

        try {
            libroServicio.crearLibro(1234567890L, "Cien años de soledad", 1967, 100, autor, editorial);
            System.out.println("---------------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Listar todos los libros
        libroServicio.listarLibros();
        System.out.println("---------------------------------------------------");

        // // Modificar un libro (por ISBN)
        libroServicio.modificarLibro(1234567890L, "Cien años de soledad (Edición Especial)", 1967, 150);
        libroServicio.listarLibros();
        System.out.println("---------------------------------------------------");

        // // Buscar libro por título
        List<Libro> librosPorTitulo = libroServicio.buscarLibroPorTitulo("Cien años de soledad");
        if (librosPorTitulo != null) {
            System.out.println("coincidencia hallada");
            librosPorTitulo.forEach(libro -> System.out.println(libro));
        }
        System.out.println("---------------------------------------------------");

        // // Buscar libro por autor
        List<Libro> librosPorAutor = libroServicio.buscarLibroPorAutor(autor);
        if (librosPorAutor != null) {
            System.out.println("Coincidencia hallada, libros de: " + autor.getNombre());
            for (Libro libro : librosPorAutor) {
                System.out.println(libro);
            }
        } else {
            System.out.println("no se hallo al autor");
        }
        System.out.println("---------------------------------------------------");

        // // Buscar libro por editorial
        List<Libro> librosPorEditorial = libroServicio.buscarLibroPorEditorial(editorial);
        if (librosPorEditorial != null) {
            System.out.println("Los libros de la editorial " + editorial.getNombre() + " son:");
            for (Libro libro : librosPorEditorial) {
                System.out.println(libro.toString());
            }
        } else {
            System.out.println("no se hallaron libros de la editorial " + editorial.getNombre());
        }
        System.out.println("---------------------------------------------------");

        // // Eliminar un libro lógicamente (por ISBN)
        libroServicio.eliminarLibroLogico(1234567890L);
        libroServicio.listarLibros();
        System.out.println("---------------------------------------------------");
    }

    public static void pruebaEditorial() {
        EditorialServicio ediser = new EditorialServicio();

        ediser.crearEditorial("Atlantida");
        ediser.listarEditoriales();
        System.out.println("---------------------------------------------------");
        ediser.modificarEditorial(1L, "IVREA");
        ediser.listarEditoriales();
        System.out.println("---------------------------------------------------");
        ediser.borradoLogicoEditorial(1L);
        ediser.listarEditoriales();
        System.out.println("---------------------------------------------------");
    }

    public static void pruebaAutor() {
        AutorServicio autser = new AutorServicio();

        System.out.println("---------------------------------------------------");
        try {
            autser.crearAutor("Hemingway");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------");
        autser.listarAutores();
        System.out.println("---------------------------------------------------");

        autser.modificarAutor(1L, "Poe");

        System.out.println("---------------------------------------------------");
        autser.listarAutores();

        System.out.println("---------------------------------------------------");
        autser.eliminarAutorLogico(1L);
        autser.listarAutores();

    }
}
