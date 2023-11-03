package TPO_Lab06.Fundamentals;

public class Task_02 {
    public static void main(String[] args) {
        System.out.println("Аргументы командной строки в обратном порядке:");

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println(args[i]);
        }
    }
}
