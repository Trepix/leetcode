import java.util.LinkedList;
import java.util.List;
class Solution {
    public List<String> generateParenthesis(int n) {
        return _generateParenthesis(new StringBuilder(), 0, n * 2);
    }

    public List<String> _generateParenthesis(StringBuilder builder, int openParenthesis, int n) {
        if (n == 0) return List.of(builder.toString());
        List<String> generatedParenthesis = new LinkedList<>();
        if (openParenthesis < n) {
            builder.append("(");
            generatedParenthesis.addAll(_generateParenthesis(builder, openParenthesis + 1, n - 1));
            builder.deleteCharAt(builder.length() - 1);
        }
        if (openParenthesis > 0) {
            builder.append(")");
            generatedParenthesis.addAll(_generateParenthesis(builder, openParenthesis - 1 , n - 1));
            builder.deleteCharAt(builder.length() - 1);
        }
        return generatedParenthesis;
    }
}
