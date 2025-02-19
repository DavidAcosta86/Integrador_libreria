package com.libreria.persistencia;

import com.libreria.entidades.Libro;
import com.libreria.entidades.Autor;
import com.libreria.entidades.Editorial;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class LibroDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("libreria");

    // Guardar un libro
    public void guardarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Actualizar un libro
    public void actualizarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Eliminar un libro
    public void eliminarLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(libro) ? libro : em.merge(libro));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // Buscar un libro por ISBN
    public Libro buscarLibroPorIsbn(Long isbn) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Libro.class, isbn);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // Buscar un libro por título
    public List<Libro> buscarLibroPorTitulo(String titulo) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo", Libro.class)
                    .setParameter("titulo", "%" + titulo + "%")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // Buscar libros por nombre de autor
    public List<Libro> buscarLibroPorAutor(Autor autor) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.autor = :autor", Libro.class)
                    .setParameter("autor", autor)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // Buscar libros por nombre de editorial
    public List<Libro> buscarLibroPorEditorial(Editorial editorial) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.editorial = :editorial", Libro.class)
                    .setParameter("editorial", editorial)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    // Listar todos los libros
    public List<Libro> listarLibros() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
}