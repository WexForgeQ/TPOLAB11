package TPO_Lab06.Threads;

import java.util.concurrent.*;
public class Ship implements Runnable {
    private final String name;
    private final int capacity;
    private final Port port;

    public Ship(String name, int capacity, Port port) {
        this.name = name;
        this.capacity = capacity;
        this.port = port;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is approaching the port.");
            port.dockShip();
            System.out.println(name + " has docked.");
            Thread.sleep(1000);

            // Разгрузка контейнеров
            int unloadedContainers = Math.min(capacity, port.unloadContainers(capacity));
            System.out.println(name + " has unloaded " + unloadedContainers + " containers.");
            Thread.sleep(1000);
            // Загрузка контейнеров
            int loadedContainers = Math.min(capacity - unloadedContainers, port.loadContainers(capacity - unloadedContainers));
            System.out.println(name + " has loaded " + loadedContainers + " containers.");
            Thread.sleep(1000);
            System.out.println(name + " is leaving the port.");
            port.undockShip();
        } catch (InterruptedException e) {
            System.out.println(name + " was interrupted.");
        }
    }
}
