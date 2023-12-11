import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];

		// 점수 입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0; // 점수를 다 더한 값
		for (int i = 0; i < arr.length; i++) {
			//40점 미만은 40점
			if (arr[i] < 40) {
				arr[i] = 40;
			}

			sum += arr[i];
		}
		System.out.println(sum / 5); 
		sc.close();
	}
}