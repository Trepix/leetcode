class Solution {
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] TRANSLATION = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
    public String intToRoman(int num) {
        StringBuilder builder  =new StringBuilder("");  
        for (int i=0; i < VALUES.length && num != 0; ++i) {
            while (num >= VALUES[i]) {
                builder.append(TRANSLATION[i]);
                num-= VALUES[i];
            }
        }
        return builder.toString();
    }
}