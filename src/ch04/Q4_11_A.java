package ch04;

import java.util.LinkedList;
import java.util.Queue;

public class Q4_11_A {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // 레벨 4
        TreeNode node8 = tree.makeSubtree(null, 7, null);
        TreeNode node9 = tree.makeSubtree(null, 8, null);

        // 레벨 3
        TreeNode node4 = tree.makeSubtree(null, 0, null);
        TreeNode node5 = tree.makeSubtree(node8, 2, node9);
        TreeNode node6 = tree.makeSubtree(null, 4, null);
        TreeNode node7 = tree.makeSubtree(null, 6, null);

        // 레벨 2
        TreeNode node2 = tree.makeSubtree(node4, 1, node5);
        TreeNode node3 = tree.makeSubtree(node6, 5, node7);

        // 레벨 1
        TreeNode node1 = tree.makeSubtree(node2, 3, node3);


        System.out.printf("%-15s", "In-order: ");
        tree.inOrderTraversal(node1);

        System.out.printf("\n%-15s", "Pre-order: ");
        tree.preOrderTraversal(node1);

        System.out.printf("\n%-15s", "Post-order: ");
        tree.postOrderTraversal(node1);

        System.out.printf("\n%-15s", "Level-order: ");
        tree.levelOrderTraversal(node1);

        System.out.println();
        tree.deleteNode(node4);
        tree.levelOrderTraversal(node1);

        TreeNode searched = tree.searchNode(7);
        System.out.println("\n\n(at " + searched + ") " + searched.getData());

        TreeNode randomNode = tree.getRandomNode();
        System.out.println(randomNode.getData());
    }
}

class TreeNode {
    private TreeNode leftChild;
    private Object data;
    private TreeNode rightChild;

    TreeNode(TreeNode leftChild, Object data, TreeNode rightChild) {
        this.leftChild = leftChild;
        this.data = data;
        this.rightChild = rightChild;
    }

    TreeNode getLeftChild() {
        return leftChild;
    }

    Object getData() {
        return data;
    }

    TreeNode getRightChild() {
        return rightChild;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}

class BinaryTree {
    private TreeNode root;
    private int size;

    TreeNode makeSubtree(TreeNode left, Object data, TreeNode right) {
        TreeNode root = new TreeNode(left, data, right);

        this.root = root;
        size++;

        return root;
    }

    void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.getLeftChild());
            System.out.print(root.getData() + " ");
            inOrderTraversal(root.getRightChild());
        }
    }

    private TreeNode inOrderTraversal(TreeNode root, Object find) {
        if (root != null) {
            if (root.getData() == find) {
                return root;
            } else {
                TreeNode left = inOrderTraversal(root.getLeftChild(), find);
                if (left != null) return left;

                TreeNode right = inOrderTraversal(root.getRightChild(), find);
                if (right != null) return right;
            }
        }
        return null;
    }

    void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrderTraversal(root.getLeftChild());
            preOrderTraversal(root.getRightChild());
        }
    }

    void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.getLeftChild());
            postOrderTraversal(root.getRightChild());
            System.out.print(root.getData() + " ");
        }
    }

    void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.getData() + " ");

            if (node.getLeftChild() != null) queue.add(node.getLeftChild());
            if (node.getRightChild() != null) queue.add(node.getRightChild());
        }
    }

    private TreeNode levelOrderTraversal(TreeNode root, int limit) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 0; i < limit - 1; i++) {
            TreeNode node = queue.poll();

            if (node.getLeftChild() != null) queue.add(node.getLeftChild());
            if (node.getRightChild() != null) queue.add(node.getRightChild());
        }

        return queue.poll();
    }

    TreeNode searchNode(Object data) {
        return inOrderTraversal(root, data);
    }

    void deleteNode(TreeNode node) {
        TreeNode parent = root;

        while (true) {
            if (parent.getRightChild().getRightChild() == null) {
                node.setData(parent.getRightChild().getData());
                parent.setRightChild(null);
                break;
            }
            parent = parent.getRightChild();
        }
    }

    TreeNode getRandomNode() {
        int index = (int) (Math.random() * size) + 1;
        System.out.print("(at index " + index + ") ");

        return levelOrderTraversal(root, index);
    }
}
