package c_010_인프런.i_009_GreedyAlgorithm.i_009_008_원더랜드_프림_PriorityQueue;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73417?tab=curriculum

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73418?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/09-07

/*
7. 원더랜드(최소스패닝트리)
설명

원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.

원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.

아래의 그림은 그 한 예를 설명하는 그림이다.

Image1.jpg

위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.


입력
첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.

다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.

이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.


출력
모든 도시를 연결하면서 드는 최소비용을 출려한다.



*/

/*
입력
9 12
1 2 12
1 9 25
2 3 10
2 8 17
2 9 8
3 4 18
3 7 55
4 5 44
5 6 60
5 7 38
7 8 35
8 9 15

출력
196
*/

class Edge implements Comparable<Edge> {

    public int vex;
    public int cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(); // 인접리스트 만들기

        // 인접 리스트 만들기
        for (int i = 0; i <= n; i++) { // 번호로 만들어야 하므로 n 포함까지

            graph.add(new ArrayList<Edge>());
        }

        int[] ch = new int[n + 1]; // 체크 변수 만들기

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(a).add(new Edge(b, cost)); // 뻗어나가야 하는 정점 추가
            graph.get(b).add(new Edge(a, cost)); // 반대로 뻗어나가야 하는 정점 추가 (양방향)
        }

        int answer = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(1, 0)); // 1번째 정점 초기화

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();

            int ev = tmp.vex;

            if (ch[ev] == 0) { // 체크가 안되어 있을 때만
                ch[ev] = 1; // 체크해놓기

                answer += tmp.cost; // 확정된 정점 최소 비용 더하기

                for (Edge ob : graph.get(ev)) { // 인접된 정점으로 뻗어 나가기
                    if (ch[ob.vex] == 0) pq.offer(new Edge(ob.vex, ob.cost)); // 인접된 정점들 중에서 체크가 안되어 있는 것들만 큐에 넣어주기
                }
            }
        }

        System.out.println(answer);
    }
}
