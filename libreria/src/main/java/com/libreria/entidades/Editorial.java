package com.libreria.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Long id;

    @Column(name = "nombre_editorial", nullable = false)
    private String nombre;

    public Editorial() {
    }

    @Column(columnDefinition = "BOOLEAN DEFAULT true")
    private boolean alta = true;

    public Long getId() {
        return id;
    }

    public Editorial(String nombre) {

        this.nombre = nombre;
        this.alta = true;
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

    public boolean isAlta() {
        return alta;
    }

    public void setAlta(boolean alta) {
        this.alta = alta;
    }

    @Override
    public String toString() {
        return "Editorial [id=" + id + ", nombre=" + nombre + ", alta=" + alta + "]";
    }
}
