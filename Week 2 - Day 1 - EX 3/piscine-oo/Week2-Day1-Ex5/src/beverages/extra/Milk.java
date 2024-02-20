package beverages.extra;

import beverages.Beverage;

public class Milk extends DrinksExtra{

    private static final double ExtraMilkPrice = 0.10;


    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return this.beverage.getPrice()+ExtraMilkPrice;
    }
}
