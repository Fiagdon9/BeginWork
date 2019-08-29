package com.example.beginwork;

class Car {
    private int imageSrc;
    private String type;
    private String time;

    public Car(int imageSrc, String type, String time){
      this.imageSrc = imageSrc;
      this.type =  type;
      this.time = time;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
