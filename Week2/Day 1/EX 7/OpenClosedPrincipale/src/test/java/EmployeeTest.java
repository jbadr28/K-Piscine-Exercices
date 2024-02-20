import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    public static final double PRECISION  = 0.0001;

    @Test
    public void validEngineerPayAmount(){
        Employee eng = new Engineer(500,100);
        assertTrue("Engineer pay_amount is equal to the salary",eng.payAmount()==eng.salary);
        assertEquals(500,eng.payAmount(),PRECISION);
    }

    @Test
    public void invalidEngineerPayAmount(){
        Employee eng = new Engineer(500,100);
        assertFalse("Engineer pay_amount is not equal to the sum of salary + bonus",eng.payAmount()==(eng.salary+eng.bonus));
    }

    @Test
    public void validManagerPayAmount(){
        Employee man = new Manager(500,100);
        assertFalse("Manger pay_amount is not equal to the salary",man.payAmount()==man.salary);
        assertEquals(600, man.payAmount(),PRECISION);
    }

    @Test
    public void invalidManagerPayAmount(){
        Employee man = new Manager(500,100);
        assertTrue("Engineer pay_amount is equal  to the sum of salary + bonus",man.payAmount()==(man.salary+man.bonus));

    }


}
