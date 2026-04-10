class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int duplicate = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int num : nums) {
                if (num == i) count++;
            }
            if (count == 2) duplicate = i;
            if (count == 0) missing = i;
        }

        return new int[]{duplicate, missing};
    }
}