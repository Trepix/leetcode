class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder("$#");
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i)).append("#");
        }
        String temp = sb.toString();
        int mx = 0;
        int id = 0;
        int len = temp.length();
        int [] p = new int[len];
        int resLen = 0;
        int resCenter = 0;
        for(int i = 1;i<len;i++){
            p[i] = mx > i ? Math.min(p[2*id-i],mx-i): 1;
            while(i-p[i]>=0 && i+p[i]<len && temp.charAt(i-p[i]) == temp.charAt(i+p[i])){
                p[i]++;
            }
            if(mx < p[i] + i){
                mx = p[i] + i;
                id = i;
            }
            if(resLen < p[i]){
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter-resLen)/2,(resCenter-resLen)/2 + resLen - 1);
    }

}