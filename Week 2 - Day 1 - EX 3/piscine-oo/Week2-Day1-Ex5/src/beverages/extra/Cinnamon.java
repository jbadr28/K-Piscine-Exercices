package beverages.extra;

import beverages.Beverage;

public class Cinnamon extends DrinksExtra{

    private static final double CinnamonExtraPrice = 0.05;
    public Cinnamon(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double getPrice() {
        return beverage.getPrice()+CinnamonExtraPrice;
    }
}
