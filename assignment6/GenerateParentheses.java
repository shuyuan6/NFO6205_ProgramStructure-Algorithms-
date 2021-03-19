package assignment6;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public void helper(StringBuilder curr, int remainingLeft, int remainingRight) {
        if (remainingLeft == 0 && remainingRight == 0) {
            res.add(curr.toString());
        }

        if (remainingLeft != 0) {
            helper(curr.append('('), remainingLeft - 1, remainingRight);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (remainingRight > remainingLeft) {
            helper(curr.append(')'), remainingLeft, remainingRight - 1);
            curr.deleteCharAt(curr.length() - 1);

        }
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder();
        helper(curr, n, n);
        return res;
    }
}
