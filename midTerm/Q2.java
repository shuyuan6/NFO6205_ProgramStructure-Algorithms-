package midTerm;

public class Q2 {
    //Assume that the tree contains n nodes
    //Time complexity: o(n)
    //Space complexity: o(1), without considering the size of the tree itself
    public void printPerimeter(TreeNode root){
        if (root == null) {
            return;
        }
        printRightSide(root);
        printLeaves(root);
        printLeftSide(root.left);
    }
    private void printRightSide(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            System.out.print(node.val + " ");
            printRightSide(node.right);
        } else if (node.left != null) {
            System.out.print(node.val + " ");
            printRightSide(node.left);
        }
    }

    private void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }

        printLeaves(node.right);
        if (node.left == null && node.right == null) {
            System.out.print(node.val + " ");
        }
        printLeaves(node.left);
    }

    private void printLeftSide(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            printLeftSide(node.left);
            System.out.print(node.val + " ");
        } else if (node.right != null) {
            printLeftSide(node.right);
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args) {
        Q2 test = new Q2();

        /*
                          1
                       /    \
                      2      3
                    /  \    /  \
                   4   5   6    7
                  /\  / \  \   /
                 8 9 10 11 13 14
         */

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(14);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        node6.right = node13;
        node7.left = node14;

        test.printPerimeter(node1);

    }
}
