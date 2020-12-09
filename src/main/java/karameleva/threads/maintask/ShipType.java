package karameleva.threads.maintask;

public enum ShipType {
    LOADING("Loading"), UNLOADING("Unloading"), LOADING_UNLOADING ("Loading&Unloading");
    String type;

    ShipType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Ship for " + type;
    }
}
