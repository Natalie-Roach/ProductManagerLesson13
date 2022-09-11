import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product.Book;
import ru.netology.domain.Product.Product;
import ru.netology.domain.Product.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "book1", 200, "author1");
    Product product2 = new Book(2, "book2", 340, "author2");
    Product product3 = new Book(10, "book3", 789, "author3");
    Product product4 = new Book(44, "book4", 2_000, "author4");
    Product product5 = new Book(589, "book5", 999, "author5");
    Product product6 = new Smartphone(11, "phone1", 10_000, "maker1");
    Product product7 = new Smartphone(34, "phone2", 13_499, "maker2");
    Product product8 = new Smartphone(10, "phone3", 34_000, "maker3");
    Product product9 = new Smartphone(5, "phone4", 16_789, "maker4");
    Product product10 = new Smartphone(145, "phone5", 106_000, "maker5");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);

    }

    @Test

    public void shouldShowAllProducts() {
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = manager.repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByProductNameBook() {
        Product[] expected = {product5};
        Product[] actual = manager.searchBy("book5");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByWordBook() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = manager.searchBy("book");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchByProductNameSmartphone() {
        Product[] expected = {product9};
        Product[] actual = manager.searchBy("phone4");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldSearchByWordPhone() {
        Product[] expected = {product6, product7, product8, product9, product10};
        Product[] actual = manager.searchBy("phone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldNotSearchIfWrongText() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("laptop");

        Assertions.assertArrayEquals(expected, actual);
    }

}
