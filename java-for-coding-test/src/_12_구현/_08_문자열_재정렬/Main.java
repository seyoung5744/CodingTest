package _12_구현._08_문자열_재정렬;

import java.util.*;

/*
K1KA5CB7
AJKDLSI412K4JSJ9D
 */
public class Main {
    private static String str;
    public static PriorityQueue<Character> q = new PriorityQueue<>();
    public static int value = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        str = sc.next();

        for(char c : str.toCharArray()){
            if(c >= 'A' && c <= 'Z'){ // Character.isLetter()
                q.add(c);
            }else{
                value+= c - '0';
            }
        }


        while(!q.isEmpty()){
            System.out.print(q.poll());
        }

        if(value != 0) System.out.println(value);
    }
}
