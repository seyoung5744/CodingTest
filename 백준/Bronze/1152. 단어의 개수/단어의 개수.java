import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        if (str.length() == 0) {
            System.out.println(0);
        }else{
            String[] strArr = str.split(" ");
            System.out.println(strArr.length);
        }
    }
}
