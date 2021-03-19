package assignment6;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null && t != null) {
            return false;
        }
        if (s != null && t == null) {
            return false;
        }

        return s.val == t.val && isSame(s.left,t.left) && isSame(s.right, t.right);

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (isSame(curr, t)) {
                return true;
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return false;
    }
}
