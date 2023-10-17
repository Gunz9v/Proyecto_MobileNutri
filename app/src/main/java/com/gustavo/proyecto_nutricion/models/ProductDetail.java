package com.gustavo.proyecto_nutricion.models;

public class ProductDetail {

    String name;
    String detail1;
    String detail2;
    String detail3;
    String detail4;

    String videoURL;

    public ProductDetail(String name, String detail1, String detail2, String detail3, String detail4, String videoURL) {
        this.name = name;
        this.detail1 = detail1;
        this.detail2 = detail2;
        this.detail3 = detail3;
        this.detail4 = detail4;
        this.videoURL = videoURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail1() {
        return detail1;
    }

    public void setDetail1(String detail1) {
        this.detail1 = detail1;
    }

    public String getDetail2() {
        return detail2;
    }

    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }

    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }

    public String getDetail4() {
        return detail4;
    }

    public void setDetail4(String detail4) {
        this.detail4 = detail4;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
