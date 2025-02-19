package com.libreria.persistencia;

import java.util.List;

import com.libreria.entidades.Autor;
import com.libreria.entidades.Editorial;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EditorialDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");

    public void crearEditorial(Editorial editorial) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void modificarEditorial(Editorial editorial) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void eliminarEditorial(Editorial editorial) {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction();
            em.remove(editorial);
            em.getTransaction().commit();
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            em.close();
        }

    }

    public List<Editorial> listarEditoriales() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT e FROM Editorial e", Editorial.class).getResultList();
        } catch (Exception e) {
            return null;
            // TODO: handle exception
        } finally {
            em.close();
        }

    }

    public Editorial buscarEditorial(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            return em.find(Editorial.class, id);
        } catch (Exception e) {
            // TODO: handle exception
            return null;
        } finally {
            em.close();
        }

    }
}
