package Recursion;

import java.util.Arrays;
import java.util.LinkedList;

public class BinaryTreeTraversal {

    private static class TreeNode {
        int data;

        TreeNode leftChild;
        TreeNode rightChild;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    public static void inOrederTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrederTraversal(node.leftChild);
        System.out.println(node.data);
        inOrederTraversal(node.rightChild);
    }

    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3,2,9,null,null,10,null,null,8,null,4));
        TreeNode node = createBinaryTree(inputList);
        System.out.println("preOrderTraversal:");
        preOrderTraversal(node);
        System.out.println("inOrderTraversal:");
        inOrederTraversal(node);
        System.out.println("postOrderTraversal:");
        postOrderTraversal(node);
    }
}
