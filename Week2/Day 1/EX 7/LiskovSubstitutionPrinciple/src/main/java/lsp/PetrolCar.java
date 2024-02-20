package lsp;

public class PetrolCar extends Vehicle implements ElectricStation{

    private static final int FUEL_TANK_FULL = 100;
    private int fuelTankLevel = 0;

    @Override
    public void chargeBattery() {
        this.fuelTankLevel = FUEL_TANK_FULL;
    }

    public int getFuelTankLevel(){
        return this.fuelTankLevel;
    }
}
