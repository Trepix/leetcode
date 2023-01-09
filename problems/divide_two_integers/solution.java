class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean negative = dividend < 0 ^ divisor < 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while (dividend - divisor >= 0) {
            int subQuot = quotient(dividend, divisor);
            quotient += 1 << subQuot;
            dividend -= divisor << subQuot;
        }
        return negative ? -quotient : quotient;
    }

    private int quotient(int dividend, int divisor) {
        int quotient = 0;
        while (dividend - (divisor << quotient << 1) >= 0) {
            quotient++;
        }
        return quotient;
    }
}