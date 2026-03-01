package com.syncapi.sync_api.DTO;

import java.sql.Timestamp;

public class ItemPerfilResponseDTO {
    private Long id;
    private Long idUser;
    private String titulo;
    private String description;
    private int puntuacion;
    private String imagen_doc;
    private Timestamp onCreated;
    private Timestamp onUpdate;

    public ItemPerfilResponseDTO(Long id, Long idUser, String titulo, String description, int puntuacion,
            String imagen_doc, Timestamp onCreated, Timestamp onUpdate) {
        this.id = id;
        this.titulo = titulo;
        this.description = description;
        this.puntuacion = puntuacion;
        this.imagen_doc = imagen_doc;
        this.onCreated = onCreated;
        this.onUpdate = onUpdate;
    }
    public ItemPerfilResponseDTO() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImagen_doc() {
        return imagen_doc;
    }

    public void setImagen_doc(String imagen_doc) {
        this.imagen_doc = imagen_doc;
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

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    

}
