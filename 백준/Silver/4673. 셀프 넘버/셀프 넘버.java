class Main {
    boolean[] self = new boolean[10000];
    public int d(int n){
        int sum = 0;
        sum += n;
        while(n > 0){
            sum+= n % 10;
            n /= 10;
        }

        if(sum >= 10000){
            return -1;
        }
        if(!self[sum-1]){
            self[sum-1] = true;
        }
        return d(sum);
    }
    public static void main(String[] args) {
        Main myClass = new Main();
        for (int i = 1; i < 10000; i++) {
            myClass.d(i);
        }
        
        for (int i = 0; i < 10000-1; i++) {
            if(!myClass.self[i])
                System.out.println(i+1);
        }
    }
}
