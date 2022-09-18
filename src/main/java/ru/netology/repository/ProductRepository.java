package ru.netology.repository;

import ru.netology.domain.Product.Product;
import ru.netology.exception.NotFoundException;

public class ProductRepository {

    private Product[] products = new Product[0];

    //сохранять Product's
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    //удалять Product's по id
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id:" + id + "not found");
        }

        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    //получать Product's
    public Product[] getProducts() {
        return products;
    }

    public Product[] findAll() {
        Product[] all = getProducts();
        Product[] list = new Product[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }

    public Product findById(int id) {
        Product result = null;
        for (Product product : products) {
            if (product.getId() == id) {
                result = product;
                break;
            }

        }
        return result;
    }

}

