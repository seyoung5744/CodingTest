class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int gcbA = gcb(arrayA);
        int gcbB = gcb(arrayB);

        if (!canDivided(arrayA, gcbB) && !canDivided(arrayB, gcbA)) {
            return Math.max(gcbA, gcbB);   
        }
        
        if (!canDivided(arrayA, gcbB)) {
            return gcbB;
        }
        
        if(!canDivided(arrayB, gcbA)) {
            return gcbA;
        }
        
        return answer;
    }

    private boolean canDivided(int[] arr, int oppositeTarget) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % oppositeTarget == 0) return true;
        }
        return false;
    }

    private int gcb(int[] arr) {
        int gcb = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcb = gcb(gcb, arr[i]);
        }
        return gcb;
    }

    private int gcb(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}