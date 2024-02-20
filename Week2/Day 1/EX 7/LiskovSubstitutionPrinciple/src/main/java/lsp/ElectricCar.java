package lsp;

public class ElectricCar extends Vehicle implements ElectricStation{

    private static final int BATTERY_FULL = 100;
    private int batteryLevel;


    @Override
    public void chargeBattery() {
        this.batteryLevel = BATTERY_FULL;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
