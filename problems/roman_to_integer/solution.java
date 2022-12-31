

class Solution {

    int valueOf(char c) {
        return switch (c)
        {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

    public int romanToInt(String n) {
        int previous = 0;
        int result = 0;
        for (int i=n.length() - 1; i >=0; --i) {
            int current = valueOf(n.charAt(i));
            if (current < previous) {
                result -= current;
            }
            else result += current;
            previous = current;
        }
        return result;
    }
}