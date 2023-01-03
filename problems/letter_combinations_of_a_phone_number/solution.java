import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    static final Map<Character, List<String>> KEYBOARD = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        if (digits.length() == 1) return KEYBOARD.get(digits.charAt(0));
        
        List<String> letters = KEYBOARD.get(digits.charAt(0));
        List<String> nextLetters = letterCombinations(digits.substring(1));
        List<String> result = new LinkedList<>();
        for (String s: letters) {
            for (String t: nextLetters) {
                result.add(s.concat(t));
            }
        }
        return result;
    }
}