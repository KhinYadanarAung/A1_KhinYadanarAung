package com.example.a1_khinyadanaraung;

public class Items {

    private String name, price,imgIndex,size;

    public Items(String value, String value1,String value2, String value4){
        imgIndex = value;
        name = value1;
        price = value2;
        size = value4;
    }

    public String getImgIndex() {
        return imgIndex;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }
}
