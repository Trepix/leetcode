class Solution {
    public int myAtoi(String str) {
        int number = 0;
        int sign = 1;

        if( !str.isEmpty()){
            int i = 0;
            while(i<str.length()-1 && str.charAt(i) == ' ') i++;

            char msb = str.charAt(i);
            if(msb == '-' || msb == '+'){
                i++;
                if(i<str.length() && Character.isDigit(str.charAt(i))){
                    sign = ( 45 == msb )? -1 : 1;
                    number = sign*(str.charAt(i)-48);
                    i++;
                }

            }
            while(i<str.length() && Character.isDigit(str.charAt(i))){
                int add = (str.charAt(i)-48);
                if(number > Integer.MAX_VALUE/10 || (number ==Integer.MAX_VALUE/10 && add>7))
                    return Integer.MAX_VALUE;
                if(number < Integer.MIN_VALUE/10 || (number ==Integer.MIN_VALUE/10 && add>8))
                    return Integer.MIN_VALUE;
                number = number*10 + (sign*add);
                i++;
            }
        }


        return number;
    }

}