package a_004_기존문제풀기.q_001_완주하지못한선수_002_Hash_keySet_이용;

import java.util.HashMap;

// HashMap 이용 - keySet 이용
public class Solution {

    public String solution(String[] participant, String[] completion) {

        String answer = "";

        // 1. HashMap을 만든다 (participant)
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1); // +1을 해준다.
        }

//        System.out.println(map);

        // 2. HashMap을 -1씩 뺀다 (completion)
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

//        System.out.println(map);

        // 3. map에서 모두 1씩 뺐을 때 value가 0이 아닌 마지막 주자를 찾는다.
//        System.out.println(map.keySet());

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break; // 굳이 더 돌 필요 없으므로 성능 향상을 위해 break;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        String[] part = {"leo", "kiki", "eden"};
        String[] comp = {"leo", "kiki"};
        Solution sol = new Solution();
        System.out.println(sol.solution(part, comp));
    }
}
