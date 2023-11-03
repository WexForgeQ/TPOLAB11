package TPO_Lab06.Threads;

import org.junit.Test;
import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class PortTest {

    @Test
    public void testPortOperations() throws InterruptedException {
        int portCapacity = 100;
        int dockCount = 3;
        int containerCount = 200;

        Port port = new Port(portCapacity, dockCount, containerCount);

        ExecutorService executor = Executors.newFixedThreadPool(dockCount);

        // Создание кораблей
        executor.execute(new Ship("Ship 1", 50, port));
        executor.execute(new Ship("Ship 2", 70, port));
        executor.execute(new Ship("Ship 3", 30, port));

        executor.shutdown();
        Thread.sleep(2000);

        // Проверка состояния порта после выполнения операций
        assertEquals(150, containerCount - port.containers.availablePermits());
        assertEquals(3, dockCount - port.docks.availablePermits());
    }

}