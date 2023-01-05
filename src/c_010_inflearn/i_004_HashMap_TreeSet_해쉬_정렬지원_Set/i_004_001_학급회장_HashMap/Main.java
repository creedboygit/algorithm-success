package c_010_inflearn.i_004_HashMap_TreeSet_해쉬_정렬지원_Set.i_004_001_학급회장_HashMap;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72739?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/04-01

/*
1. 학급 회장(해쉬)
설명

학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했습니다.

투표용지에는 반 학생들이 자기가 선택한 후보의 기호(알파벳)가 쓰여져 있으며 선생님은 그 기호를 발표하고 있습니다.

선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하세요.

반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정합니다.


입력
첫 줄에는 반 학생수 N(5<=N<=50)이 주어집니다.

두 번째 줄에 N개의 투표용지에 쓰여져 있던 각 후보의 기호가 선생님이 발표한 순서대로 문자열로 입력됩니다.


출력
학급 회장으로 선택된 기호를 출력합니다.
*/

/*
입력
15
BACBACCACCBDEDE

출력
C
*/

    public char solution(int n, String str) {

        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // 너무 중요하다! 꼭 외워라!
        }

//        System.out.println(map.containsKey('A')); // 키가 존재하냐 - true or false 리턴
//        System.out.println(map.containsKey('F')); // 키가 존재하냐 - true or false 리턴
//        System.out.println(map.size()); // 키의 개수를 알려줌
//        System.out.println(map.remove('A')); // 특정 키를 삭제 (삭제된 키의 Value값을 리턴)
//        System.out.println(map.size()); // 키의 개수를 알려줌

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
//            System.out.println(key + " " + map.get(key));
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        System.out.println(t.solution(n, str));
    }
}
