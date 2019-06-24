class Solution {
    public boolean isPalindrome(int x) {
        char[] chars = ("" + x).toCharArray();
        int highest = chars.length-1;
        int lowest = 0;
        while (highest > lowest) {
            if (chars[highest] != chars[lowest]) return false;
            --highest;
            ++lowest;
        }
        return true;
    }
}