package assignment1_BinaryTrees;

public class BalancedBinaryTree {
    private int findDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int leftD = findDepth(treeNode.left);
        int rightD = findDepth(treeNode.right);
        return Math.max(leftD, rightD) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(findDepth(root.left) - findDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main (String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        System.out.println("Should be true: " + balancedBinaryTree.isBalanced(root1));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);
        System.out.println("Should be false: " + balancedBinaryTree.isBalanced(root2));
    }
}
