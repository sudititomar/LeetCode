
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int minDistance = Integer.MAX_VALUE;
        HashMap<Integer, Integer> lastSeenTarget = new HashMap<>();

        for (int j = 0; j < nums.length; j++) {
            if (lastSeenTarget.containsKey(nums[j])) {
                minDistance = Math.min(minDistance, j - lastSeenTarget.get(nums[j]));
            }
            
            int target = reverse(nums[j]);
            lastSeenTarget.put(target, j);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
}