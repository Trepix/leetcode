class Solution {
    public String convert(String s, int numRows) {
        int module = 2*(numRows-1);
        if (module == 0) return s;
        char[] result = new char[s.length()];
        int position = 0;
        for (int i=0; i < numRows; ++i) {
            for (int j=i, jumps=1; j < s.length(); j+=module, ++jumps) {
                int opposite = module*jumps - Math.floorMod(j, module);
                result[position++] = s.charAt(j);
                if (j != opposite && opposite-module != j && opposite < s.length()) {
                    result[position++] = s.charAt(opposite);
                }
            }
        }
        return new String(result);
    }
}