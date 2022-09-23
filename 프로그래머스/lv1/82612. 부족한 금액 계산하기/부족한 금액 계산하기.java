class Solution {
    public long solution(int price, int money, int count) {
        long fee = count * (price + (long) price * count) /2;

        if(money - fee >=0){
            return 0;
        }else{
            return fee - money;
        }
    }
}