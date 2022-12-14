import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String buddhism_year = br.readLine();

        bw.write((Integer.parseInt(buddhism_year) - 543) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
