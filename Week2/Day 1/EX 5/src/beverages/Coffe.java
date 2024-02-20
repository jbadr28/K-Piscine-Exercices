package beverages;

public class Coffe implements Beverage{

    private static final double coffeBasePrice = 1.2;
    @Override
    public double getPrice() {
        return coffeBasePrice;
    }
}
