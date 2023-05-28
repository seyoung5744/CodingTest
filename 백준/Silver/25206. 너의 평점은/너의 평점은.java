import java.io.*;
import java.util.*;

public class Main {

    public static Map<String, Double> gradeMap = new HashMap<String, Double>() {{
        put("A+", 4.5);
        put("A0", 4.0);
        put("B+", 3.5);
        put("B0", 3.0);
        put("C+", 2.5);
        put("C0", 2.0);
        put("D+", 1.5);
        put("D0", 1.0);
        put("F", 0.0);
    }};

    public static void main(String[] args) throws IOException{
        BufferedReader sb = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0;
        double creditSum = 0;

        StringTokenizer st = null;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(sb.readLine());
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String gradeStr = st.nextToken();
            double grade = 0;
            if(!gradeStr.equals("P")) {
                grade = gradeMap.get(gradeStr);
                creditSum += credit;
                sum += (credit * grade);
            }
        }
        System.out.printf("%.6f", sum / creditSum);
    }

}
