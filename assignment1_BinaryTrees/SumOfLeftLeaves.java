package assignment1_BinaryTrees;

public class SumOfLeftLeaves {
    int sum = 0;

    private void findSum(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }

        if (isLeft && node.left == null && node.right == null) {
            sum += node.val;
        }

        findSum(node.left, true);
        findSum(node.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        findSum(root, false);
        return sum;
    }

    public static void main (String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();

        System.out.println("Should be 24: " + sumOfLeftLeaves.sumOfLeftLeaves(root1));
    }
}
