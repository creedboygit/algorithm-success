package a_004_기존문제풀기.q_006_개취_소수찾기;

// 개취 유튜브 : https://www.youtube.com/watch?v=pF368QqdQb4&list=PLlV7zJmoG4XJTfHH3BNhqBBmeME6xwcDf
// 프로그래머스 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
// 블로그 설명 : https://coding-grandpa.tistory.com/81

/**
 * 매번 recursive 함수가 호출될 때 comb와 others 인자가 어떻게 변경되는 지를 쫓아가시면서 봐야 조금 더 정확하게 볼 수 있을 것 같아요. 제가 "17"을 예시로 문제를 푼다면 이렇게 정리하고 코딩을 시작할 것 같아요.
 *
 * 1. comb="", others="17"
 *   - comb==""이기 때문에 numberSet에 add하지 않고 바로 for문으로 넘어감
 *   - others.length() == 2이기 때문에 i=0; i<2; i++ 로 2회 수행
 *     1-1 (i==0). comb="1", others="7"
 *       - numberSet.add("1") 수행
 *       - others.length() == 1이기 때문에 for문 1회 수행
 *         1-1-1. (i==0) comb="17", others=""
 *           - numberSet.add("17") 수행
 *           - others.length() == 0이기 때문에 for문 수행하지 않고 바로 나감
 *     1-2 (i==1). comb="7", others="1"
 *       - numberSet.add("7") 수행
 *       - others.length() == 1이기 때문에 for문 1회 수행
 *         1-2-1. (i==0) comb="71", others=""
 *           - numberSet.add("71") 수행
 *           - others.length() == 0이기 때문에 for문 수행하지 않고 바로 나감
 *
 * 1-1-1이 끝나면 다시 1-1로 돌아오고, 1-1이 끝나면 1-2로 들어가야 하는데, 1-2로 가지 않고 그냥 함수가 끝난다고 생각하셔서 헷갈리시는 것 같아요.
 *
 * 1-2만 놓고 생각해보면, 1. 단계에서 comb="", others="17"로 들어왔기 때문에 for문을 두 번째 돌 때에도 comb=""이고, others.charAt(i==1)은 "7"이 될 겁니다.
 * 새로 만들어진 comb 는 "" + "7" 의 결과물인 "7"이 전달 될 거고요.
 *
 * 그래서 재귀함수를 처음 짤 때는 손코딩이 참 중요한 것 같아요. 해답을 보면서 공부를 해도 좋은데, 이 해답이 어떤 동작을 할지를 손으로 하나 하나 그려보면 생각의 힘을 기르는 데 큰 도움이 되고요, 특히나 재귀처럼 여러 번 호출됐다가 나왔다를 반복하는 경우에는 제대로 정리하지 않으면 매번 헷갈릴 거예요.
 *
 * 우선은 제가 정리해 놓은 걸 따라가면서 한번 이해하고, 직접 다시 그려보면서 같은 그림이 나오는지도 보면 좋을 것 같고요,
 * 그게 잘 됐다면 "011" 예시에 대해서도 수행해보기 전에 제가 정리한 것처럼 쭉 정리를 해보고, 프로그램 실행할 때 print문 추가해서 예상하셨던 것처럼 잘 나오는 지 비교해보는 걸 추천드려요.
 *
 * 당장 이 문제 하나를 이해하고 말고를 떠나서 재귀를 정확하게 이해하려면 직접 그려보시는 게 가장 효과적일 것 같습니다:)
 */

import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while (set.iterator().hasNext()) {
            int a = set.iterator().next();
            set.remove(a);
            if (a == 2) count++;
            if (a % 2 != 0 && isPrime(a)) {
                count++;
            }
        }
        return count;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if (!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17"));
    }
}