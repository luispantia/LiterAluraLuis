package com.Luis.catalogolibros.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private Integer birthYear;
    private Integer deathYear;

    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
    private List<Libros> libros;

    public Autores(){}

    public Autores(DatosAutores datosAutores) {
        this.nombre = datosAutores.nombre();
        this.birthYear = datosAutores.birthYear();
        this.deathYear = datosAutores.deathYear();
    }

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

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public Autores getPrimerAutor(DatosLibros datosLibros) {
        DatosAutores datosAutores = datosLibros.autoresList().get(0);
        return new Autores(datosAutores);
    }


    @Override
    public String toString() {
        return "\n╭──────────❖ Datos Autor ❖──────────╮" +
                "\n│ Nombre: " + nombre +
                "\n│ Año de nacimiento: " + birthYear +
                "\n│ Año de muerte: " + deathYear +
                "\n╰────────────────────────────────────╯\n" ;
    }


}
