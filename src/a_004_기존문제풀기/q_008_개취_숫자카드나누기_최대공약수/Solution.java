package a_004_기존문제풀기.q_008_개취_숫자카드나누기_최대공약수;

public class Solution {

    public boolean notDivisible(int[] arr, int num) {
        for (int n : arr)
            if (n % num == 0)
                return false;

        return true;
    }

    // 최대공약수 구하는 공식
    public int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public int solution(int[] arrayA, int[] arrayB) {

        // 0. 입력 및 초기화
        int answer = 0;
        int gcdA = arrayA[0]; // 일단 배열의 처음 수로 초기화
        int gcdB = arrayB[0]; // 일단 배열의 처음 수로 초기화

        // 1. 각 배열의 최대공약수 구하기
        for (int i = 1; i < arrayA.length; i++) { // 이미 위에서 0으로 초기화 했으므로 1부터 돈다.
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        // 2. 서로의 배열을 나눌 수 없는지 확인
        if (notDivisible(arrayB, gcdA))
            if (answer < gcdA)
                answer = gcdA;

        if (notDivisible(arrayA, gcdB))
            if (answer < gcdB)
                answer = gcdB;

        // 3. 최대값 반환
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arrA = {14, 35, 119};
        int[] arrB = {18, 30, 102};
        System.out.println(sol.solution(arrA, arrB));
    }
}
