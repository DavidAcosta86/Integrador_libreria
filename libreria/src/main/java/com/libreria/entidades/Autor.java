package com.libreria.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long id;

    @Column(name = "nombre_autor", nullable = false, length = 150)
    private String nombre;

    @Column(name = "alta", columnDefinition = "BOOLEAN DEFAULT true")
    private boolean alta = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Autor() {
    }

    public Autor(Long id, String nombre, boolean alta) {
        this.id = id;
        this.nombre = nombre;
        this.alta = alta;
    }

    public boolean isAlta() {
        return alta;
    }

    public Autor(String nombre) {

        this.nombre = nombre;
        this.alta = true;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Autor [id=" + id + ", nombre=" + nombre + ", alta=" + alta + "]";
    }

}
