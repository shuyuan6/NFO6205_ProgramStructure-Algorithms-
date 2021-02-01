package assignment1_BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    private int getHeight(TreeNode root, ArrayList<List<Integer>> leaves) {
        if (root == null) {
            return -1;
        }

        int leftHeight = getHeight(root.left, leaves);
        int rightHeight = getHeight(root.right, leaves);

        int level = Math.max(leftHeight, rightHeight) + 1;
        if (level == leaves.size()){
            leaves.add(new ArrayList<Integer>());
        }

        leaves.get(level).add(root.val);
        return level;
    }


    public List<List<Integer>> findLeaves(TreeNode root) {
        ArrayList<List<Integer>> leaves = new ArrayList<>();
        getHeight(root, leaves);
        return leaves;
    }

    public static void main (String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        FindLeavesOfBinaryTree findLeavesOfBinaryTree = new FindLeavesOfBinaryTree();
        List<List<Integer>> leaves = findLeavesOfBinaryTree.findLeaves(root1);
        // Print the leaves layer by layer
        for (List<Integer> list : leaves) {
            for (Integer leave : list) {
                System.out.print(leave + " ");
            }
            System.out.println();
        }
    }
}
