class Solution {
    private final static String[] words = {
        "zero","one","two","three","four","five","six","seven","eight","nine"
    };
    
    public int solution(String s) {
        int answer = 0;
        
        for(int num = 0; num < words.length; num++){
            s = s.replace(words[num], Integer.toString(num));
        }
        
        return Integer.parseInt(s);
    }
}