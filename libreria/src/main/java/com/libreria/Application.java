package com.libreria;

import com.libreria.servicios.AutorServicio;
import com.libreria.servicios.EditorialServicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");
        EntityManager em = emf.createEntityManager();

        pruebaAutor();
        pruebaEditorial();

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
