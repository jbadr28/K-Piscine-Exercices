
package test;

import beverages.Beverage;
import beverages.Coffe;
import beverages.HotChocolate;
import beverages.Tea;
import beverages.*;
import beverages.extra.Cinnamon;
import beverages.extra.Cream;
import beverages.extra.DrinksExtra;
import beverages.extra.Milk;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


;
public class BeveragePriceTest {
    private static final double PRECISION = 0.001;

    @Test
    public void computes_coffee_price() {
        Beverage coffee = new Coffe();
        assertEquals( 1.20 , coffee.getPrice(), PRECISION);
    }

    @Test
    public void computes_tea_price() {
        Beverage tea = new Tea();
        assertEquals( 1.50, tea.getPrice(), PRECISION);
    }

    @Test
    public void computes_hot_chocolate_price() {
        Beverage hotChocolate = new HotChocolate();
        assertEquals(1.45, hotChocolate.getPrice(),PRECISION);
    }

    @Test
    public void computes_tea_with_milk_price() {
        //Create a Cup of Tea with add Milk --Using Decoative Pattern
        Beverage tea = new Tea();
        DrinksExtra addedMilk = new Milk(tea);
        assertEquals(1.60,addedMilk.getPrice(), PRECISION);
    }

    @Test
    public void computes_coffee_with_milk_price() {
        Beverage coffee = new Coffe();
        DrinksExtra addedMilk = new Milk(coffee);
        assertEquals(1.30,addedMilk.getPrice(), PRECISION);
    }

    @Test
    public void computes_coffee_with_milk_and_cream_price() {
        Beverage coffee = new Coffe();
        DrinksExtra addMilk_And_Cream = new Cream(new Milk(coffee));
        assertEquals(1.45,addMilk_And_Cream.getPrice(), PRECISION);

    }

    @Test
    public void computes_hot_chocolate_with_cream_price() {
        Beverage hotChocolate = new HotChocolate();
        DrinksExtra addedCream = new Cream(hotChocolate);
        assertEquals(1.60,addedCream.getPrice(), PRECISION);
    }

    @Test
    public void computes_coffee_with_milk_and_cream_and_cinnamon(){
        Beverage coffee = new Coffe();
        DrinksExtra addMilk_And_Cream = new Cream(new Milk(coffee));
        DrinksExtra addMilk_And_Cream_and_cinnamon = new Cinnamon(addMilk_And_Cream);
        assertEquals(1.5,addMilk_And_Cream_and_cinnamon.getPrice(), PRECISION);
    }
}
