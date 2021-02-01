package assignment1_BinaryTrees;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minD = Integer.MAX_VALUE;

        if (root.left != null) {
            minD = Math.min(minDepth(root.left), minD);
        }
        if (root.right != null) {
            minD = Math.min(minDepth(root.right), minD);
        }

        return minD + 1;
    }

    public static void main (String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        System.out.println("Should be 2: " + minimumDepthOfBinaryTree.minDepth(root1));

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.right.right = new TreeNode(5);
        root2.right.right.right.right =  new TreeNode(6);
        System.out.println("Should be 5: " + minimumDepthOfBinaryTree.minDepth(root2));

    }
}
