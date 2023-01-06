package c_010_inflearn.i_006_정렬이분검색과결정알고리즘.i_006_007_좌표정렬_compareTo;

import java.util.*;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72760?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/06-07

/*
7. 좌표 정렬
설명

N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.

정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.


입력
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.

두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.


출력
N개의 좌표를 정렬하여 출력하세요.
*/

/*
입력
5
2 7
1 3
1 2
2 5
3 6

출력
1 2
1 3
2 5
2 7
3 6
*/
    public static void main(String[] args) throws Exception {

//        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            arr.add(new Point(x, y));
        }

        Collections.sort(arr);
        for (Point o : arr) System.out.println(o.x + " " + o.y);
    }
}


// 좌표 정렬 외우자!
class Point implements Comparable<Point> {

    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 오름차순일 때
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) return this.y - o.y; // 음수로 만들어야 한다.
        else return this.x - o.x; // 음수로 만들어야 한다.
    }

    // 내림차순일 때
//    @Override
//    public int compareTo(Point o) {
//        if (this.x == o.x) return o.y - this.y; // o와 this를 바꿔서 음수로 만들어야 한다.
//        else return o.x - this.x; // o와 this를 바꿔서 음수로 만들어야 한다.
//    }
}