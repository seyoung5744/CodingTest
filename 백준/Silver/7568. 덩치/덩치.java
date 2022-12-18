import java.io.*;
import java.util.*;

class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] person = br.readLine().split(" ");
            people.add(new Person(Integer.parseInt(person[0]), Integer.parseInt(person[1])));
        }

        int[] result = new int[n];

        for (int i = 0; i < people.size(); i++) {
            int cnt = 1;
            for (int j = 0; j < people.size(); j++) {
                if (i != j && people.get(i).height < people.get(j).height
                        && people.get(i).weight < people.get(j).weight) {
                    cnt++;
                }
            }
            result[i] = cnt;
        }

        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
