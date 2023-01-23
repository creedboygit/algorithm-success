package c_010_인프런.i_007_Recursive_Tree_Graph_DFS_BFS_기초.i_007_009_Tree_말단노드까지의가장짧은경로_DFS;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72771?tab=curriculum


    Node root;

    public int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) return level;
        else return Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
    }

    public static void main(String[] args) throws Exception {

        Main tree = new Main();

        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);

        System.out.print(tree.DFS(0, tree.root));
    }
}
