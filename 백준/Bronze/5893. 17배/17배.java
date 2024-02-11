import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Long으로 담을 수 없는 수이기에 BigInteger을 사용
		BigInteger N = new BigInteger(br.readLine(), 2);
		//최종으로 나온 10진수를 2진수로 저장할 stack
		Stack<BigInteger> stack = new Stack<>();
		
		//N에 17을 곱하고 N에 다시 저장한다.
		N = N.multiply(BigInteger.valueOf(17));
		
		//2진수로 바꾸는 방법인 수에 2를 계속 나눠서 나머지와 최종 몫 1을 뽑아내는 방법이다.
		//뽑아낸 나머지와 몫은 순서대로 stack에 집어넣는다.
		while(true) {
			stack.push(N.remainder(BigInteger.valueOf(2)));
			N = N.divide(BigInteger.valueOf(2));
			if(N.equals(BigInteger.ONE)) {
				stack.push(N);
				break;
			}
		}
		//! .isEmpty로 stack에 저장된 자료가 없을때까지 반복한다.
		while(!stack.isEmpty()) {
			BigInteger S = stack.pop();
			System.out.print(S);
		}
	}

}