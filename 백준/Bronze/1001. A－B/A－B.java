import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int a = System.in.read();
        System.in.read();
        int b = System.in.read();

        System.out.println((a-48) - (b-48));
    }
}
