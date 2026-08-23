import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                // Store index of '('
                stack.push(i);
            } 
            else {
                // Remove matching '('
                stack.pop();

                // No valid starting point
                if (stack.isEmpty()) {
                    stack.push(i);
                } 
                else {
                    // Length of current valid substring
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}