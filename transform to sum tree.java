//TRANSFORM TO TREE INTO SUM TREEE...

import java.util.*;

class SumTree {
    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;  // if left child is null, assign 0
        int newRight = root.right == null ? 0 : root.right.data;  // if right child is null, assign 0
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        SumTree sumTree = new SumTree();
        Node root = sumTree.new Node(1);
        root.left = sumTree.new Node(2);
        root.right = sumTree.new Node(3);
        root.left.left = sumTree.new Node(4);
        root.left.right = sumTree.new Node(5);
        root.right.left = sumTree.new Node(6);
        root.right.right = sumTree.new Node(7);
        System.out.println("Original Tree: ");
        preorder(root);
        System.out.println();
        transform(root);
        System.out.println("Transformed Tree: ");
        preorder(root);
    }
}

