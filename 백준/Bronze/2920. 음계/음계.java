import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[8];
        int status = -1;
        for (int i = 0; i < 8; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 1; i < 8; i++) {
            if(nums[i-1] - 1 == nums[i]){
                status = 0;
            }else if(nums[i-1] + 1 == nums[i]){
                status = 1;
            }else{
                status = 2;
                break;
            }
        }

        if(status == 0){
            System.out.println("descending");
        }else if(status == 1){
            System.out.println("ascending");
        }else{
            System.out.println("mixed");
        }
    }
}
