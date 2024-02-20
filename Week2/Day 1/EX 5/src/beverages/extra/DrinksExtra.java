package beverages.extra;

import beverages.Beverage;

public abstract class DrinksExtra implements Beverage {

    protected Beverage beverage;

    public DrinksExtra(Beverage beverage) {
        this.beverage = beverage;
    }
}
