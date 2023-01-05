package lecture.i_009_GreedyAlgorithm.i_009_006_친구인가_Union_Find;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73416?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/09-06

/*
6. 친구인가? (Disjoint-Set : Union&Find)
설명

오늘은 새 학기 새로운 반에서 처음 시작하는 날이다. 현수네 반 학생은 N명이다. 현수는 각 학생들의 친구관계를 알고 싶다.

모든 학생은 1부터 N까지 번호가 부여되어 있고, 현수에게는 각각 두 명의 학생은 친구 관계가 번호로 표현된 숫자쌍이 주어진다.

만약 (1, 2), (2, 3), (3, 4)의 숫자쌍이 주어지면 1번 학생과 2번 학생이 친구이고, 2번 학생과 3번 학생이 친구, 3번 학생과 4번 학생이 친구이다.

그리고 1번 학생과 4번 학생은 2번과 3번을 통해서 친구관계가 된다.

학생의 친구관계를 나타내는 숫자쌍이 주어지면 특정 두 명이 친구인지를 판별하는 프로그램을 작성하세요.

두 학생이 친구이면 “YES"이고, 아니면 ”NO"를 출력한다.


입력
첫 번째 줄에 반 학생수인 자연수 N(1<=N<=1,000)과 숫자쌍의 개수인 M(1<=M<=3,000)이 주어지고,

다음 M개의 줄에 걸쳐 숫자쌍이 주어진다.

마지막 줄에는 두 학생이 친구인지 확인하는 숫자쌍이 주어진다.


출력
첫 번째 줄에 “YES"또는 "NO"를 출력한다.



*/

/*
입력
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8

9명과 7개의 쌍 조합
9 7

1 2
2 3
3 4
1 5
6 7
7 8
8 9

3 8
3과 8이 친구인가

출력
NO
*/
    static int[] unf;

    // 집합 찾기
    public static int Find(int v) { // Find, Union은 외우자
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    // 같은 집합으로 만들기
    public static void Union(int a, int b) { // Find, Union은 외우자
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public String solution(String str) {

        String answer = "";

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            Union(a, b);
        }

//        System.out.println(Arrays.toString(unf));

        int x = sc.nextInt();
        int y = sc.nextInt();

        int fx = Find(x);
        int fy = Find(y);

        if (fx == fy) System.out.println("YES");
        else System.out.println("NO");
    }
}
