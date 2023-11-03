package TPO_Lab06.Threads;

import java.util.concurrent.*;

public class Port {
    private final int capacity; // Вместимость порта
    final Semaphore docks; // Семафор для ограничения числа кораблей
    final Semaphore containers; // Семафор для ограничения числа контейнеров

    public Port(int capacity, int dockCount, int containerCount) {
        this.capacity = capacity;
        this.docks = new Semaphore(dockCount);
        this.containers = new Semaphore(containerCount);
    }

    public int unloadContainers(int containerCount) throws InterruptedException {
        containers.acquire(containerCount);
        return containerCount;
    }

    public int loadContainers(int containerCount) {
        containers.release(containerCount);
        return containerCount;
    }

    public void dockShip() throws InterruptedException {
        docks.acquire();
    }

    public void undockShip() {
        docks.release();
    }
}
