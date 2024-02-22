package week2.day3.ex1.injectionviaAnnotation;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World !!";
    }
}
