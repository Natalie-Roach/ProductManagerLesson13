package ru.netology.domain.Product;

public class Book extends Product {

    //поля
    private String author;

    //конструктор
    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    //getter
    public String getAuthor() {
        return author;
    }

    //setter
    public void setAuthor(String author) {
        this.author = author;
    }

}
