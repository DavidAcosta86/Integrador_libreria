package com.libreria.persistencia;

import java.util.List;

import com.libreria.entidades.Autor;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;

import jakarta.persistence.Persistence;

public class AutorDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");

    public void guardarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void actualizarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void eliminarAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Autor buscarAutorPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Autor.class, id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }

    }

    public List<Autor> listarAutores() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            em.close();
        }
    }
}
