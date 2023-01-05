package a_004_기존문제풀기.q_002_전화번호접두어_002_Hash이용;

import java.util.Arrays;
import java.util.HashMap;

// HashMap 이용
public class Solution {

    public boolean solution(String[] phone_book) {

        // 1. 모든 전화번호의 HashMap을 만든다.
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 1);
        }

//        System.out.println(map);

        // 2. 모든 전화번호의 접두어가 HashMap에 존재하는지 확인한다.
        for (int i = 0; i < phone_book.length; i++)
            for (int j = 1; j < phone_book[i].length(); j++)
                if (map.containsKey(phone_book[i].substring(0, j)))
                    return false;

        // 3. 여기까지 왔다면 접두어가 없다는 뜻이다.
        return true;
    }

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        Solution sol = new Solution();
        System.out.println(sol.solution(phone_book));
    }
}
