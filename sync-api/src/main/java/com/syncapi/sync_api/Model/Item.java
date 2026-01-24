package com.syncapi.sync_api.Model;

public class Item {
    private Long id;
    private String titulo;
    private String description;
    private int puntuacion;
    private boolean favoritos;
    private String imagen_doc;
    private String imagen_per;
    private String categoria;

    //Constructor sense id ni imatges (per al csv)
    public Item(String titulo, String description, int puntuacion, boolean favoritos, String categoria) {
        this.titulo = titulo;
        this.description = description;
        this.puntuacion = puntuacion;
        this.favoritos = favoritos;
        this.categoria = categoria;
    }

    //Constructor sense id
    public Item(String titulo, String description, int puntuacion, boolean favoritos, String imagen_doc,
            String imagen_per, String categoria) {
        this.titulo = titulo;
        this.description = description;
        this.puntuacion = puntuacion;
        this.favoritos = favoritos;
        this.imagen_doc = imagen_doc;
        this.imagen_per = imagen_per;
        this.categoria = categoria;
    }

    //Constructor amb id
    public Item(Long id, String description, int intpuntuacion, boolean favoritos, String imagen_doc, String imagen_per,
            String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.description = description;
        this.puntuacion = intpuntuacion;
        this.favoritos = favoritos;
        this.imagen_doc = imagen_doc;
        this.imagen_per = imagen_per;
        this.categoria = categoria;
    }

    //Constructor sense res
    public Item() {
    }

    //Getters i Setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public boolean isFavoritos() {
        return favoritos;
    }

    public void setFavoritos(boolean favoritos) {
        this.favoritos = favoritos;
    }

    public String getImagen_doc() {
        return imagen_doc;
    }

    public void setImagen_doc(String imagen_doc) {
        this.imagen_doc = imagen_doc;
    }

    public String getImagen_per() {
        return imagen_per;
    }

    public void setImagen_per(String imagen_per) {
        this.imagen_per = imagen_per;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    
    
}
