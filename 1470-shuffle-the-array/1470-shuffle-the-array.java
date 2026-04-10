class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            ans[idx++] = nums[i];       // pick from first half
            ans[idx++] = nums[i + n];   // pick from second half
        }

        return ans;
    }
}