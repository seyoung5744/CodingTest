import java.util.*;

public class Main{
    public static int[] students = new int[31];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i <= 28; i++){
            int num = sc.nextInt();
            students[num]+=1;
        }
        
        for(int i = 1; i <= 30; i++){
            if(students[i] == 0){
                System.out.println(i);
            }
        }
    }
}