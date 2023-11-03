package TPO_Lab06.Fundamentals;

public class Task_04 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Необходимо передать целые числа в качестве аргументов командной строки.");
            return;
        }

        int sum = 0;
        int product = 1;

        for (String arg : args) {
            int number = Integer.parseInt(arg);
            sum += number;
            product *= number;
        }

        System.out.println("Сумма чисел: " + sum);
        System.out.println("Произведение чисел: " + product);
    }
}
