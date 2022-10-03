class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(String word : s.split(" ")){
            if (word.equals("")){
                sb.append(" ");
                continue;
            }
            if(Character.isDigit(word.charAt(0)) ){
                sb.append(word.substring(0,1));
                sb.append(word.substring(1).toLowerCase());
            }else{
                String temp="";
                temp += word.substring(0,1).toUpperCase();
                temp += word.substring(1).toLowerCase();
                sb.append(temp);
            }
            sb.append(" ");
        }
        
        char[] ch = s.toCharArray();
        for (int i = ch.length-1; i > 0 ; i--) {
            if(ch[i] == ' '){
                // System.out.println("공백");
                sb.append(' ');
            }else{
                break;
            }
        }

        return sb.substring(0, sb.length()-1);
    }
}