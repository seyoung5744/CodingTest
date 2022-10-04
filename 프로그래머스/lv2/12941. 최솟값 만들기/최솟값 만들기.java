import java.util.Arrays;
class Solution
{
    public static int[] reverseSort(int[] arr){
        Arrays.sort(arr);
        for (int i = 0; i < arr.length/2; i++) {
            int tmp = arr[i];
            arr[i] = arr[ arr.length- i -1];
            arr[arr.length - i - 1] = tmp;
        }
        return arr;
    }
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        int[] b = reverseSort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * b[i];
        }


        return answer;
    }
}