
package com.portfoio.ma.Dto;

import javax.validation.constraints.NotBlank;


public class dtoBanner {

    public static String getnombre() {
        return null;
 }
     @NotBlank
    private String img;

    public dtoBanner() {
    }

    public dtoBanner(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
     
}
