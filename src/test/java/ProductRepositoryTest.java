import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product.Book;
import ru.netology.domain.Product.Product;
import ru.netology.domain.Product.Smartphone;
import ru.netology.exception.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

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
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.save(product7);
        repo.save(product8);
        repo.save(product9);
        repo.save(product10);
    }

    @Test

    public void shouldSave() {
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindAll() {
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldRemoveByIdExists() {
        repo.removeById(product5.getId());
        Product[] expected = {product1, product2, product3, product4, product6, product7, product8, product9, product10};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldThrowException() {

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(22)
        );
    }

}
