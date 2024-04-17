class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String entry : skill_trees) {
            String remained = entry.replaceAll("[^" + skill + "]", "");

            boolean flag = true;
            for (int i = 0; i < remained.length() && flag; i++) {
                if(remained.charAt(i) != skill.charAt(i))
                    flag = false;
            }
            
            if (flag)
                ++answer;
        }
        return answer;
    }
}