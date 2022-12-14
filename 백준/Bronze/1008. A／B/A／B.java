import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        double a = System.in.read();
        System.in.read();
        double b = System.in.read();
        System.out.println((a-48) / (b-48));
    }
}
