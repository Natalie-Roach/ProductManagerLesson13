package ru.netology.domain.Product;

public class Smartphone extends Product {

    //поля
    private String maker;

    //конструктор
    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.maker = maker;
    }

    //getter
    public String getMaker() {
        return maker;
    }

    //setter
    public void setMaker(String maker) {
        this.maker = maker;
    }

}
