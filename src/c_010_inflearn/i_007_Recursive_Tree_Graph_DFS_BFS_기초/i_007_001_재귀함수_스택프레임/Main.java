package c_010_inflearn.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_001_재귀함수_스택프레임;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72765?tab=curriculum

//

/*

*/

/*
입력


출력
*/

    public void DFS(int n) {
        if (n == 0) return;
        else {
//            System.out.print(n + " ");
            DFS(n - 1);
//            System.out.println();
            System.out.print(n + " ");
        }
    }

    public void solution(int n){
        DFS(n);
    }


    public static void main(String[] args) throws Exception {
        Main T = new Main();

        T.solution(3);
    }
}
