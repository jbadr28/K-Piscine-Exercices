package beverages;

public class HotChocolate implements Beverage {

    private static final double hotChocolateBasePrice = 1.45;
    @Override
    public double getPrice() {
        return hotChocolateBasePrice;
    }
}
