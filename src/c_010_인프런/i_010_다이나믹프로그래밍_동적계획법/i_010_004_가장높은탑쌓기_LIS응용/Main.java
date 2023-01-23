package c_010_인프런.i_010_다이나믹프로그래밍_동적계획법.i_010_004_가장높은탑쌓기_LIS응용;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/73424?tab=curriculum

//https://cote.inflearn.com/contest/10/problem/10-04

/*
4. 가장 높은 탑 쌓기
설명

밑면이 정사각형인 직육면체 벽돌들을 사용하여 탑을 쌓고자 한다. 탑은 벽돌을 한 개씩 아래에서 위로 쌓으면서 만들어 간다.

아래의 조건을 만족하면서 가장 높은 탑을 쌓을 수 있는 프로그램을 작성하시오.

(조건1) 벽돌은 회전시킬 수 없다. 즉, 옆면을 밑면으로 사용할 수 없다.

(조건2) 밑면의 넓이가 같은 벽돌은 없으며, 또한 무게가 같은 벽돌도 없다.

(조건3) 벽돌들의 높이는 같을 수도 있다.

(조건4) 탑을 쌓을 때 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌은 놓을 수 없다.

(조건5) 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없다.


입력
입력 파일의 첫째 줄에는 입력될 벽돌의 수가 주어진다. 입력으로 주어지는 벽돌의 수는 최대 100개이다.

둘째 줄부터는 각 줄에 한 개의 벽돌에 관한 정보인 벽돌 밑면의 넓이, 벽돌의 높이 그리고 무게가 차례대로 양의 정수로 주어진다.

각 벽돌은 입력되는 순서대로 1부터 연속적인 번호를 가진다. 벽돌의 넓이, 높이 무게는 10,000보다 작거나 같은 자연수이다.


출력
첫 번째 줄에 가장 높이 쌓을 수 있는 탑의 높이를 출력한다.



*/

/*
입력
5
25 3 4
4 4 6
9 2 3
16 2 5
1 5 2

출력
10
*/

class Brick implements Comparable<Brick> {

    public int area;
    public int height;
    public int weight;

    Brick(int area, int height, int weight) {
        this.area = area;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick ob) {
        return ob.area - this.area; // 역순 정렬
    }
}

public class Main {

    public int solution(ArrayList<Brick> arr) {

        int answer = 0;

        Collections.sort(arr);

        int[] dy = new int[arr.size()]; // ArrayList이므로 size()

        dy[0] = arr.get(0).height; // 맨 처음거 높이로 초기화
        answer = dy[0];

        for (int i = 1; i < arr.size(); i++) { // 위에 초기화 했으므로 다음거부터이므로 1부터

            int max_h = 0; // 최대 높이

            for (int j = i - 1; j >= 0; j--) { // 다 j로 되어야 한다. i와 헷갈리지 말기
                // 높이로 내림차순 정렬되어 있으므로 무게로만 비교
                if (arr.get(j).weight > arr.get(i).weight && dy[j] > max_h) {
                    max_h = dy[j];
                }
            }

            dy[i] = max_h + arr.get(i).height; // 높이를 더해줘야 한다
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Brick> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int area = sc.nextInt();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            arr.add(new Brick(area, height, weight));
        }

//        for (Brick o : arr) {
//            System.out.println(o.area + " - " + o.height + " - " + o.weight);
//        }

        System.out.println(t.solution(arr));
    }
}
