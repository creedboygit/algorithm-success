package c_010_인프런.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_007_이진트리레벨탐색_BFS_Breadth_First_Search;

import java.util.*;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72768?tab=curriculum

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
    }
}

public class Main {

    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.add(cur.lt);
                if (cur.rt != null) Q.add(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.BFS(tree.root);
    }
}
