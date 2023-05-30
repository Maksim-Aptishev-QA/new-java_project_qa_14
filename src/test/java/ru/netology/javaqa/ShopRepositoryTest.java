package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {


    ShopRepository shopRepository = new ShopRepository();
    Product productId = new Product(56, "колбаса", 500);
    Product productId1 = new Product(57, "сало", 400);
    Product productId2 = new Product(58, "хлеб", 90);

    @BeforeEach
    public void setApp() {
        shopRepository.add(productId);
        shopRepository.add(productId1);
        shopRepository.add(productId2);

    }

    @Test
    public void testDelited() {
        shopRepository.remove(56);
        Assertions.assertArrayEquals(new Product[]{productId1, productId2}, shopRepository.findAll());
    }

    @Test
    public void test2() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(54);
        });
    }
}






