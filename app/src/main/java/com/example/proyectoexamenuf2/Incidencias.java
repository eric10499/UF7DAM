package com.example.proyectoexamenuf2;

public class Incidencias {

    private String urlImagen;
    private String descripcion;
    private String estado;

    public Incidencias() {
    }

    public Incidencias(String urlImagen, String descripcion, String estado) {
        this.urlImagen = urlImagen;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
