package e_030_프로그래머스_레벨.p_100_level1.두_정수_사이의_합;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int cntP = 0;
        int cntY = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='p' || s.charAt(i)=='P')
                cntP++;
            if(s.charAt(i)=='y' || s.charAt(i)=='Y')
                cntY++;
        }

        if(cntP!=cntY)
            answer = false;

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("하하"));
    }
}