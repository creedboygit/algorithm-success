package c_010_inflearn.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_006_부분집합구하기_DFS;

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72773?tab=curriculum

    static int n; // 전역으로 선언 (main이 static이므로 접근하기 위해)
    static int[] ch;

    public void DFS(int L) {

        if (L == (n + 1)) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) tmp += (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp); // 공집합이 아닐 때
//            System.out.println(tmp);

        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) throws Exception {

        Main t = new Main();

        n = 3;

        ch = new int[n + 1];

        t.DFS(1);
    }
}
