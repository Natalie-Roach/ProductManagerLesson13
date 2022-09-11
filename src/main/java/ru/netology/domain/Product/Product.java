package ru.netology.domain.Product;

public class Product {

    //поля
    protected int id;
    protected String name;
    protected int price;

    //конструктор
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public int getPrice() {
//        return price;
//    }
//
////    //setters
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

}
