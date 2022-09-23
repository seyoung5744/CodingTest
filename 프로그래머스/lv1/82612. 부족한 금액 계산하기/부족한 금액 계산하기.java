class Solution {
    public long solution(int price, int money, int count) {
        long fee = count * (price + (long) price * count) /2;
        return money-fee >= 0? 0 : fee-money;
    }
}