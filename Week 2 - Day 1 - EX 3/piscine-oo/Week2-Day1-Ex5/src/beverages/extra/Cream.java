package beverages.extra;

import beverages.Beverage;

public class Cream extends DrinksExtra{

    private static final double ExtraCreamPrice = 0.15;

    public Cream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice()+ExtraCreamPrice;
    }
}
