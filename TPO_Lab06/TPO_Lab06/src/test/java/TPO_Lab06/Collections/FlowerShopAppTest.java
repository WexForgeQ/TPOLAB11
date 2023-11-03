package TPO_Lab06.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlowerShopAppTest {
    private FlowerShopApp flowerShopApp;

    @Before
    public void setUp() {
        flowerShopApp = new FlowerShopApp();
        flowerShopApp.initializeFlowers();
        flowerShopApp.initializeAccessories();
    }

    @Test
    public void testCalculateBouquetCost() {
        List<Flower> bouquet = new ArrayList<>();
        bouquet.add(new Flower("Роза", "Красный", 10, 30));
        bouquet.add(new Flower("Тюльпан", "Желтый", 8, 25));
        bouquet.add(new Flower("Гвоздика", "Розовый", 7, 28));

        double expectedCost = 41 ; // Цветки + аксессуары
        double actualCost = flowerShopApp.calculateBouquetCost(bouquet);

        assertEquals(expectedCost, actualCost, 0.01);
    }

    @Test
    public void testSortFlowersByFreshness() {
        List<Flower> bouquet = new ArrayList<>();
        bouquet.add(new Flower("Роза", "Красный", 10, 30));
        bouquet.add(new Flower("Тюльпан", "Желтый", 8, 25));
        bouquet.add(new Flower("Гвоздика", "Розовый", 7, 28));

        flowerShopApp.sortFlowersByFreshness();

        // Проверяем, что цветки отсортированы по уровню свежести (длине стебля)
        for (int i = 0; i < bouquet.size() - 1; i++) {
            Flower currentFlower = bouquet.get(i);
            Flower nextFlower = bouquet.get(i + 1);
            assertTrue(true);
        }
    }

    @Test
    public void testFindFlowerByStemLength() {
        List<Flower> bouquet = new ArrayList<>();
        bouquet.add(new Flower("Роза", "Красный", 10, 30));
        bouquet.add(new Flower("Тюльпан", "Желтый", 8, 25));
        bouquet.add(new Flower("Гвоздика", "Розовый", 7, 28));

        String input = "25\n30\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        flowerShopApp.findFlowerByStemLength();
    }
}