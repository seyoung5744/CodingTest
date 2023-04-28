import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int start = 2;
        int count = 0;
        int flag = 1;
        for (int i = 1; i <= n; i++) {
            count += 1;
            if(count == start){
                start += 1;
                count = 1;
                flag+=1;
            }
        }

        if(flag%2 == 0){
            System.out.println( count + "/" + (start-count));
        }else{
            System.out.println( (start-count) + "/" + count);
        }
    }

}
