import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        bw.write((a + b) + "\n");
        bw.write((a - b) + "\n");
        bw.write((a * b) + "\n");
        bw.write((a / b) + "\n");
        bw.write((a % b) + "\n");


        bw.flush();
        bw.close();
    }
}
