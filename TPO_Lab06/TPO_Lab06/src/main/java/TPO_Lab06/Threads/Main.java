package TPO_Lab06.Threads;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int portCapacity = 100;
        int dockCount = 2;
        int containerCount = 200;

        Port port = new Port(portCapacity, dockCount, containerCount);

        ExecutorService executor = Executors.newFixedThreadPool(dockCount);

        // Создание кораблей
        executor.execute(new Ship("Ship 1", 50, port));
        executor.execute(new Ship("Ship 2", 70, port));
        executor.execute(new Ship("Ship 3", 30, port));

        executor.shutdown();
    }
}