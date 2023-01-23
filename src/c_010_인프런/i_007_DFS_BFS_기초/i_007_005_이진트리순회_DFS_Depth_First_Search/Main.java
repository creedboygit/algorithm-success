package c_010_인프런.i_007_DFS_BFS_기초.i_007_005_이진트리순회_DFS_Depth_First_Search;

//https://www.inflearn.com/course/%EC%9E%90%EB%B0%94-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-%EC%BD%94%ED%85%8C%EB%8C%80%EB%B9%84/unit/72767?tab=curriculum

class Node {
    int data;
    Node lt, rt;
    public Node(int val) {
        data = val;
        lt = null;
        rt = null;
//        lt = rt = null;
    }
}

public class Main {

    Node root;

    public void DFS(Node root) {

        if (root == null) {
            return;
        } else {
//            System.out.print(root.data + " "); // 전위 순회
            DFS(root.lt);
//            System.out.print(root.data + " "); // 중위 순회
            DFS(root.rt);
            System.out.print(root.data + " "); // 후위 순회
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
//        tree.root.lt.lt.lt = new Node(8);
//        tree.root.lt.lt.rt = new Node(9);

        tree.DFS(tree.root);
    }
}
