package com.portfoio.ma.Dto;

import javax.validation.constraints.NotNull;

public class dtoProyectos {

   @NotNull
    private String nombreP;
   @NotNull
    private String descripcionP;
    private String img;
    private String url;

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP, String img, String url) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.img = img;
        this.url = url;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
