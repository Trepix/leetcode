
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
        execute("(()(())", 6);
        execute("((((()()()", 6);
        execute("))))))))()", 2);
    }

    static void execute(String p, int expected) {
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(p) + " e:" + expected + " " + p);
    }

    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') ++open;
            else {
                ++close;
                if (close > open) open = close = 0;
            }
            if (open == close) longest = Math.max(longest, open + close);
        }
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                ++open;
                if (open > close) open = close = 0;
            }
            else ++close;
            if (open == close) longest = Math.max(longest, open + close);
        }
        return longest;
    }
}
