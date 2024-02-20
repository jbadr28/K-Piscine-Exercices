package isp;

public class Dog implements BarkingAnimal,RunningAnimal{
    @Override
    public void bark() {
        System.out.println("Dog is barking");
    }

    @Override
    public void run() {
        System.out.println("Dog is running");
    }
}
