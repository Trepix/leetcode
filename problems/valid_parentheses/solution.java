import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') characters.push(c);
            else if (characters.isEmpty()) return false;
            else {
                if (c == ')') {
                    if (characters.pop() != '(') return false;
                }
                if (c == ']') {
                    if (characters.pop() != '[') return false;
                }
                if (c == '}') {
                    if (characters.pop() != '{') return false;
                }
            }
        }
        return characters.isEmpty();
    }
}