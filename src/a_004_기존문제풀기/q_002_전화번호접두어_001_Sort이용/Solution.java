package a_004_기존문제풀기.q_002_전화번호접두어_001_Sort이용;

import java.util.*;

// Sort 이용 - Sort만 잘해도 풀리는 문제들이 많다. (효율성도 통과)
public class Solution {

    public boolean solution(String[] phone_book) {
        // 1. phone_book을 정렬한다.
        Arrays.sort(phone_book);

        // 2. 1중 loop를 돌면서 앞번호가 뒷번호의 접두어인지 확인한다.
        for (int i = 0; i < phone_book.length - 1; i++) { // -1까지 돌아야 한다. 그 전이랑 그 뒤랑 비교할 것이므로
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        // 3. 여기까지 오는동안 발견 못했다면 접두어가 없다는 것이다.
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        Solution sol = new Solution();
        System.out.println(sol.solution(phone_book));
    }
}
