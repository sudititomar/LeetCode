class Solution {
    public int minimumDistance(String word) {
        int[] table = new int[27];
        int LARGE = Integer.MAX_VALUE / 2;
        java.util.Arrays.fill(table, LARGE);
        table[26] = 0;

        int last = 26;

        for (char ch : word.toCharArray()) {
            int target = ch - 'A';
            int[] next = new int[27];
            java.util.Arrays.fill(next, LARGE);

            for (int other = 0; other < 27; other++) {
                if (table[other] == LARGE) continue;

                int step = (last != 26) ? gap(last, target) : 0;
                next[other] = Math.min(next[other], table[other] + step);

                int alt = (other != 26) ? gap(other, target) : 0;
                int hold = (last != 26) ? last : 26;
                next[hold] = Math.min(next[hold], table[other] + alt);
            }

            table = next;
            last = target;
        }

        int result = LARGE;
        for (int val : table) result = Math.min(result, val);
        return result;
    }

    private int gap(int a, int b) {
        int r1 = a / 6, c1 = a % 6;
        int r2 = b / 6, c2 = b % 6;
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}