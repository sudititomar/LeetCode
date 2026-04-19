class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int ans = 0;

        int[] stack = new int[m];
        int size = 0;

        for (int j = m - 1; j >= 0; j--) {
            if (size == 0 || nums2[j] > nums2[stack[size - 1]]) {
                stack[size++] = j;
            }
        }

        for (int l = 0, r = size - 1; l < r; l++, r--) {
            int tmp = stack[l]; stack[l] = stack[r]; stack[r] = tmp;
        }

        for (int i = 0; i < n; i++) {
            int lo = 0, hi = size - 1, pos = -1;

            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (nums2[stack[mid]] >= nums1[i]) {
                    pos = mid;
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (pos != -1 && stack[pos] >= i) {
                ans = Math.max(ans, stack[pos] - i);
            }
        }

        return ans;
    }
}