package c_010_인프런.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_004_피보나치재귀_메모이제이션;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72770?tab=curriculum

//

/*

*/

/*
입력


출력
*/

//    public int DFS(int n) {
//        if (n == 1) return 1;
//        else if (n == 2) return 2;
//        else return DFS(n - 2) + DFS(n - 1);
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        Main9 T = new Main9();
//        int n = 45;
//        for (int i = 1; i <= n; i++) {
//            System.out.print(T.DFS(i) + " ");
//        }
//    }

    static long[] fibo;

    public long DFS(int n) {
        System.out.println(n);
        if (fibo[n] > 0) return fibo[n];
        if (n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 2) + DFS(n - 1);
    }

    public static void main(String[] args) throws Exception {
        Main T = new Main();
        int n = 45;
        fibo = new long[n + 1];
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}
