import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] ABC = br.readLine().split(" ");
        int A = Integer.parseInt(ABC[0]);
        int B = Integer.parseInt(ABC[1]);
        int C = Integer.parseInt(ABC[2]);

        bw.write(((A + B) % C) + "\n");
        bw.write((((A % C) + (B % C)) % C) + "\n");
        bw.write(((A * B) % C) + "\n");
        bw.write((((A % C) * (B % C)) % C) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
