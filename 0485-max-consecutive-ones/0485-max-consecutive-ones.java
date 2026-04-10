class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;                        // increment current streak
                maxCount = Math.max(maxCount, count);  // update max
            } else {
                count = 0;                      // reset on 0
            }
        }

        return maxCount;
    }
}