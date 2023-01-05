package lecture.i_004_HashMap_TreeSet_해쉬_정렬지원_Set.i_004_004_모든아나그램찾기_Hash_슬라이딩윈도우_시간복잡도;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72742?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/04-04

/*
4. 모든 아나그램 찾기
설명

S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.

아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.


입력
첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.

S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.


출력
S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
*/

/*
입력
bacaAacba
abc

출력
3
*/

    public int solution(String a, String b) {

        int answer = 0;

        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (char x : b.toCharArray()) {
            bm.put(x, bm.getOrDefault(x, 0) + 1);
//            System.out.println(x + " : " + bm.get(x));
        }

        int L = b.length() - 1;

        for (int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
//            System.out.println(a.charAt(i) + " : " + am.get(a.charAt(i)));
        }

        int lt = 0;

//        System.out.println("a.length() = " + a.length());
//        System.out.println("b.length() - 1 = " + (b.length() - 1));
//        System.out.println("a.length() = " + a.length());

        for (int rt = L; rt < a.length(); rt++) {
//            System.out.println("rt = " + rt);
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);

//            System.out.println(a.charAt(rt) + " : " + am.get(a.charAt(rt)));

//            System.out.println(am.toString());
//            System.out.println(bm.toString());

            if (am.equals(bm)) answer++;

            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);

            if (am.get(a.charAt(lt)) == 0) {
                am.remove(a.charAt(lt));
            }

            lt++;
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        System.out.println(t.solution(a, b));
    }
}
