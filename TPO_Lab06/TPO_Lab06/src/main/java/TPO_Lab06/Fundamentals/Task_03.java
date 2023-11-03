package TPO_Lab06.Fundamentals;

import java.util.Random;

public class Task_03 {
    public static void main(String[] args) {
        int count = 10;

        System.out.println("Случайные числа с переходом на новую строку:");
        for (int i = 0; i < count; i++) {
            int randomNumber = generateRandomNumber();
            System.out.println(randomNumber);
        }

        System.out.println("Случайные числа без перехода на новую строку:");
        for (int i = 0; i < count; i++) {
            int randomNumber = generateRandomNumber();
            System.out.print(randomNumber + " ");
        }
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
