package karameleva.threads.maintask;


import static karameleva.threads.maintask.ShipType.*;

public class Port {
    private final int capacityOfContainersInPort = 1000;
    private final int amountOfDocks = 4;
    private volatile int amountOfContainersInPort;


    public Port(int amountOfContainersInPort) {
        this.amountOfContainersInPort = amountOfContainersInPort;
    }

    public boolean isSuitableShip(Ship ship) {
        boolean isSuitableShip = false;
        if (ship.typeOfShip.equals(LOADING))  {
            if (amountOfContainersInPort >= ship.amountOfContainersForLoading) {
                isSuitableShip = true;
            }
        }else if (ship.typeOfShip.equals((UNLOADING))) {
            if (ship.amountOfContainersForUnloading < ( capacityOfContainersInPort - amountOfContainersInPort)){
                isSuitableShip = true;
            }
        } else {
            if (ship.amountOfContainersForUnloading < ( capacityOfContainersInPort - amountOfContainersInPort)) {
                if (amountOfContainersInPort >= ship.amountOfContainersForLoading) {
                    isSuitableShip = true;
                }
            }
        }
        return isSuitableShip;
    }

    public int getAmountOfContainersInPort() {
        return amountOfContainersInPort;
    }

    public void setAmountOfContainersInPort(int amountOfContainersInPort) {
        this.amountOfContainersInPort = amountOfContainersInPort;
    }

    public int getCapacityOfContainersInPort() {
        return capacityOfContainersInPort;
    }

    public int getAmountOfDocks() {
        return amountOfDocks;
    }

    @Override
    public String toString() {
        return "Port{" +
                "capacityOfContainersInPort=" + capacityOfContainersInPort +
                ", amountOfBerths=" + amountOfDocks +
                ", amountOfContainersInPort=" + amountOfContainersInPort +
                '}';
    }
}
