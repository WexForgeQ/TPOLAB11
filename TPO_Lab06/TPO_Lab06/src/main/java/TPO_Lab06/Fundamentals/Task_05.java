package TPO_Lab06.Fundamentals;

import java.util.Scanner;

public class Task_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число от 1 до 12: ");
        if (scanner.hasNextInt()) {
            int monthNumber = scanner.nextInt();

            if (monthNumber >= 1 && monthNumber <= 12) {
                String monthName = getMonthName(monthNumber);
                System.out.println("Название месяца: " + monthName);
            } else {
                System.out.println("Введено некорректное число. Должно быть от 1 до 12.");
            }
        } else {
            System.out.println("Введено некорректное число.");
        }
    }

    private static String getMonthName(int monthNumber) {
        String[] monthNames = {
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };

        return monthNames[monthNumber - 1];
    }
}