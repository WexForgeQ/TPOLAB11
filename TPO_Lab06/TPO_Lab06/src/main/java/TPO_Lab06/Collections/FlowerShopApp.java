package TPO_Lab06.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FlowerShopApp {
    public static List<Flower> flowers = new ArrayList<>();
    public static List<Accessory> accessories = new ArrayList<>();

    public static void main(String[] args) {
        initializeFlowers();
        initializeAccessories();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createBouquet();
                    break;
                case 2:
                    sortFlowersByFreshness();
                    break;
                case 3:
                    findFlowerByStemLength();
                    break;
                case 4:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Создать букет");
        System.out.println("2. Отсортировать цветы в букете по свежести");
        System.out.println("3. Найти цветок в букете по диапазону длин стеблей");
        System.out.println("4. Выход");
        System.out.print("Выберите пункт: ");
    }

    public static void initializeFlowers() {
        flowers.add(new Flower("Роза", "Красный", 10, 30));
        flowers.add(new Flower("Тюльпан", "Желтый", 8, 25));
        flowers.add(new Flower("Гвоздика", "Розовый", 7, 28));
    }

    public static void initializeAccessories() {
        accessories.add(new Accessory("Лента", 5));
        accessories.add(new Accessory("Упаковка", 3));
    }

    public static void createBouquet() {
        List<Flower> bouquet = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int flowerChoice = 0;

        while (flowerChoice != flowers.size() + 1) {
            displayFlowers();
            System.out.println((flowers.size() + 1) + ". Завершить выбор цветов");
            System.out.print("Выберите цветок для добавления в букет: ");
            flowerChoice = scanner.nextInt();

            if (flowerChoice >= 1 && flowerChoice <= flowers.size()) {
                bouquet.add(flowers.get(flowerChoice - 1));
                System.out.println("Цветок добавлен в букет.");
            } else if (flowerChoice != flowers.size() + 1) {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        double totalCost = calculateBouquetCost(bouquet);
        System.out.println("Стоимость букета: " + totalCost);
    }

    public static void displayFlowers() {
        System.out.println("Доступные цветы:");
        for (int i = 0; i < flowers.size(); i++) {
            Flower flower = flowers.get(i);
            System.out.println((i + 1) + ". " + flower.getName() + " (" + flower.getColor() + ")");
        }
    }

    public static double calculateBouquetCost(List<Flower> bouquet) {
        double totalCost = 0;

        for (Flower flower : bouquet) {
            totalCost += flower.getPrice();
        }

        for (Accessory accessory : accessories) {
            totalCost += accessory.getPrice();
        }

        return totalCost;
    }

    public static void sortFlowersByFreshness() {
        List<Flower> bouquet = new ArrayList<>();
        bouquet.add(flowers.get(0));
        bouquet.add(flowers.get(1));
        bouquet.add(flowers.get(2));

        System.out.println("Букет до сортировки:");
        for (Flower flower : bouquet) {
            System.out.println(flower);
        }

        Collections.sort(bouquet);

        System.out.println("Букет после сортировки:");
        for (Flower flower : bouquet) {
            System.out.println(flower);
        }
    }

    public static void findFlowerByStemLength() {
        List<Flower> bouquet = new ArrayList<>();
        bouquet.add(flowers.get(0));
        bouquet.add(flowers.get(1));
        bouquet.add(flowers.get(2));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите минимальную длину стебля: ");
        int minLength = scanner.nextInt();
        System.out.print("Введите максимальную длину стебля: ");
        int maxLength = scanner.nextInt();

        System.out.println("Цветки в букете с длиной стебля от " + minLength + " до " + maxLength + ":");
        for (Flower flower : bouquet) {
            if (flower.getStemLength() >= minLength && flower.getStemLength() <= maxLength) {
                System.out.println(flower);
            }
        }
    }
}