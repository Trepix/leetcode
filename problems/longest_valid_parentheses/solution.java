
class Solution {

    public static void main(String[] args) {
        execute("()(", 2);
        execute(")()())", 4);
        execute("()(()", 2);
        execute("()((())", 4);
        execute("(((())))", 8);
        execute(")()())()()(", 4);
        execute("()(()(((", 2);
        execute("()(())", 6);
        execute("(()(())", 4);
        execute("((((()()()", 6);
        execute("))))))))()", 2);
    }

    static void execute(String p, int expected) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(p) + " e:" + expected + " " + p);
    }

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else longest = Math.max(longest, i - stack.peek());
            }
        }
        return longest;
    }
}
