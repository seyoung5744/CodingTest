import java.util.*;

public class Main {
    public static int[] arr = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true) {
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0){
                break;
            }

            Arrays.sort(arr);

            if(arr[2] < arr[0] + arr[1]){
                if(arr[0] == arr[1] && arr[1] == arr[2]){
                    System.out.println("Equilateral");
                }else if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                    System.out.println("Isosceles");
                } else {
                    System.out.println("Scalene");
                }
            }else{
                System.out.println("Invalid");
            }
        }
    }
}
