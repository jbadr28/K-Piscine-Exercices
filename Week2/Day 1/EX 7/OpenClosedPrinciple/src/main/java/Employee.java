public abstract class Employee {

    int salary;
    int bonus;

    public Employee(int salary, int bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public abstract int payAmount();


}
