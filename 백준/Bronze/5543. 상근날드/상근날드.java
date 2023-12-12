import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int buger = 2001;   //범위가 100 ~ 2000 로 최소값을 구하기 위해 초기화
        int beverage = 2001;

        //햄버거
        for (int i = 0; i<3; i++){
            int input = Integer.parseInt(br.readLine());    //입력하는 햄버거값
            if (input < buger) {    //버거의 최소값을 구하는중. 버거 종류가 3개라 i 3개 이하로 for문
                buger = input;
            }
        }

        //음료수
        for(int i = 0; i<2; i++){   //입력하는 음료수값
            int input = Integer.parseInt(br.readLine());    //음료수의 최소값
            if (input < beverage) {
                beverage = input;
            }
        }
        System.out.println(buger + beverage - 50);
    }
}