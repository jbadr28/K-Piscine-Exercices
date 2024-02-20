package beverages;

public class Tea implements Beverage{

    private static final double teaBasePrice = 1.5;
    @Override
    public double getPrice() {
        return teaBasePrice;
    }
}
