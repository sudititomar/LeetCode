class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long ans = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            long multiple = 1;

            while (dvd >= (temp + temp)) {
                temp += temp;
                multiple += multiple;
            }

            dvd -= temp;
            ans += multiple;
        }

        return (int) (sign == 1 ? ans : -ans);
    }
}