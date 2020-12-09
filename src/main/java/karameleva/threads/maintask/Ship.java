package karameleva.threads.maintask;

import java.util.Random;

public class Ship {
    ShipType typeOfShip;
    int amountOfContainersForLoading;
    int  amountOfContainersForUnloading;

    public Ship(ShipType typOfShip, int amountOfContainersForLoading, int amountOfContainersForUnloading) {
        this.typeOfShip = typOfShip;
        this.amountOfContainersForLoading = amountOfContainersForLoading;
        this.amountOfContainersForUnloading = amountOfContainersForUnloading;
    }

    public static Ship generateShip() {
        Random random = new Random();
        int amountLoading;
        int amountUnloading;
        ShipType shipType = ShipType.values()[new Random().nextInt(ShipType.values().length)];
        if (shipType.type.equals("Loading")){
            amountLoading = 1 + random.nextInt(100);
            amountUnloading = 0;
        }else if (shipType.type.equals("Unloading")){
            amountLoading = 0;
            amountUnloading = 1 + random.nextInt(100);
        } else {
            amountLoading = 1 + random.nextInt(100);
            amountUnloading = 1 + random.nextInt(100);
        }
        Ship ship = new Ship(shipType, amountLoading, amountUnloading);
        return ship;
    }

    public ShipType getTypeOfShip() {
        return typeOfShip;
    }

    public void setTypeOfShip(ShipType typeOfShip) {
        this.typeOfShip = typeOfShip;
    }

    public int getAmountOfContainersForLoading() {
        return amountOfContainersForLoading;
    }

    public void setAmountOfContainersForLoading(int amountOfContainersForLoading) {
        this.amountOfContainersForLoading = amountOfContainersForLoading;
    }

    public int getAmountOfContainersForUnloading() {
        return amountOfContainersForUnloading;
    }

    public void setAmountOfContainersForUnloading(int amountOfContainersForUnloading) {
        this.amountOfContainersForUnloading = amountOfContainersForUnloading;
    }

    @Override
    public String toString() {
        if (typeOfShip.equals(ShipType.LOADING)) {
            return "Ship for loading " + amountOfContainersForLoading + " containers";
        } else if (typeOfShip.equals(ShipType.UNLOADING)) {
            return "Ship for unloading " + amountOfContainersForUnloading + " containers";
        } else {
            return "Ship for loading " + amountOfContainersForLoading + " & unloading " + amountOfContainersForUnloading + " containers";
        }
    }
}
