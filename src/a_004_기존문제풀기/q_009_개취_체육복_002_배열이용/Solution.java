package a_004_기존문제풀기.q_009_개취_체육복_002_배열이용;

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {

        // 1. student 배열 생성
        int[] student = new int[n + 2]; // 앞뒤를 빌려줘야 하므로 여분으로 앞 0, 뒤 6을 위해 2개를 추가해서 배열 생성
        int answer = 0;

        // 2. reserve / lost 정보 반영
        for (int l : lost)
            student[l]--;

        for (int r : reserve)
            student[r]++;

        // 3. 여분을 기준으로 앞뒤를 확인하여 체육복을 빌려준다.
        for (int i = 1; i <= n; i++) {
            if (student[i] == 1) { // i번째 학생이 체육복을 가지고 있다면
                if (student[i - 1] == -1) {
                    student[i]--;
                    student[i - 1]++;
                } else if (student[i + 1] == -1) {
                    student[i]--;
                    student[i + 1]++;
                }
            }
        }

        // 4. 체육복을 가지고 있는 학생 수를 구한다.
        for (int i = 1; i <= n; i++) {
            if (student[i] >= 0)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        a_004_기존문제풀기.q_009_개취_체육복_001_Set이용.Solution sol = new a_004_기존문제풀기.q_009_개취_체육복_001_Set이용.Solution();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solution(5, lost, reserve));
    }
}
