package com.example.laboratorio5.Dto;

public class TareaDto {
    private String desc;
    private String titulo;
    private String fecha;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public TareaDto(String titulo, String fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }
}
