package karameleva.threads.maintask;

import java.util.concurrent.*;

public class Main {
    public static void main (String [] args) {
        Port port = new Port(0);
        BlockingQueue<Ship> ships = new LinkedBlockingQueue<>(20);
        BlockingQueue<Ship> queueToEnterPort = new LinkedBlockingQueue<>(1);

        new Thread(() -> {
            while (true){
                try {
                    Ship ship = Ship.generateShip();
                    ships.put(ship);
                    System.out.println("Waiting: " + ship);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()-> {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    Ship ship = ships.take();
                    if (port.isSuitableShip(ship)) {
                        queueToEnterPort.put(ship);
                    } else {
                        ships.put(ship);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i = 1; i <= port.getAmountOfDocks(); i++) {
            int numberOfDock = i;
            new Thread(() -> {
                Thread.currentThread().setName("Dock " + numberOfDock);
               while (true) {
                   try {
                       Ship ship = queueToEnterPort.take();
                       int amountOfContainersInPort = port.getAmountOfContainersInPort()+ship.getAmountOfContainersForUnloading()- ship.amountOfContainersForLoading;
                       port.setAmountOfContainersInPort(amountOfContainersInPort);
                       System.out.println(Thread.currentThread().getName() + ": " + ship);
                       System.out.println("--------amount of containers in port: " + port.getAmountOfContainersInPort());
                       TimeUnit.SECONDS.sleep((ship.amountOfContainersForLoading+ship.getAmountOfContainersForUnloading())/10);
                       queueToEnterPort.remove(ship);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }).start();
        }
    }
}
