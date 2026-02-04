package com.syncapi.sync_api.DTO;

import java.sql.Timestamp;

public class ItemResponseDTO {
    private Long id;
    private Long idUser;
    private String titulo;
    private String description;
    private int puntuacion;
    private boolean favoritos;
    private String imagen_doc;
    private String imagen_per;
    private String categoria;
    private Timestamp onCreated;
    private Timestamp onUpdate;

    public ItemResponseDTO(Long id, Long idUser, String titulo, String description, int puntuacion, boolean favoritos,
            String imagen_doc, String imagen_per, String categoria, Timestamp onCreated, Timestamp onUpdate) {
        this.id = id;
        this.idUser = idUser;
        this.titulo = titulo;
        this.description = description;
        this.puntuacion = puntuacion;
        this.favoritos = favoritos;
        this.imagen_doc = imagen_doc;
        this.imagen_per = imagen_per;
        this.categoria = categoria;
        this.onCreated = onCreated;
        this.onUpdate = onUpdate;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    public Timestamp getOnCreated() {
        return onCreated;
    }
    public void setOnCreated(Timestamp onCreated) {
        this.onCreated = onCreated;
    }
    public Timestamp getOnUpdate() {
        return onUpdate;
    }
    public void setOnUpdate(Timestamp onUpdate) {
        this.onUpdate = onUpdate;
    }
}
