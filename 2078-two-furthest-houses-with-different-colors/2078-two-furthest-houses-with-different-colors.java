class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;

        // Scan from right: fix left anchor at index 0
        for (int j = n - 1; j > 0; j--) {
            if (colors[j] != colors[0]) {
                res = Math.max(res, j);
                break;
            }
        }

        // Scan from left: fix right anchor at index n-1
        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[n - 1]) {
                res = Math.max(res, n - 1 - i);
                break;
            }
        }

        return res;
    }
}