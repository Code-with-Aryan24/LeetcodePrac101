import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}

public class GFG {
    public static ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> res = new ArrayList<>();

        // If the tree is empty
        if (root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        // Perform level order traversal
        while (!q.isEmpty()) {
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();

                // First node of current level is part of
                // left view
                if (i == 0)
                    res.add(curr.data);

                // Push left child
                if (curr.left != null)
                    q.add(curr.left);

                // Push right child
                if (curr.right != null)
                    q.add(curr.right);
            }
        }

        return res;
    }

    public static void main(String[] args)
    {

        // Tree:
        //          1
        //        /   \
        //       2     3
        //             /
        //           4
        //            \
        //             5

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.right.left = new Node(4);

        root.right.left.right = new Node(5);

        ArrayList<Integer> ans = leftView(root);

        System.out.print("[");

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i != ans.size() - 1)
                System.out.print(", ");
        }

        System.out.print("]");
    }
}