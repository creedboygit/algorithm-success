package a_004_기존문제풀기.q_009_개취_체육복_001_Set이용;

import java.util.HashSet;

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {

        // 1. Set을 만든다.
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for (int i : reserve)
            resSet.add(i);

        for (int i : lost) {
            if (resSet.contains(i))
                resSet.remove(i);
            else
                lostSet.add(i);
        }

        // 2. 여분을 기준으로 앞뒤로 확인하여 체육복을 빌려준다. (도난당한 학생에 빌려줄 학생도 포함되어 있으면 resSet에서 제거해준다.
        for (int i : resSet) {
            if (lostSet.contains(i - 1)) // 앞 학생
                lostSet.remove(i - 1);
            else if (lostSet.contains(i + 1)) // 뒤 학생
                lostSet.remove(i + 1);
        }

        // 3. 전체 학생 수에서 lostSet에 남은 학생수만큼 빼준다.
        return n - lostSet.size();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(5, lost, reserve));
    }
}
