import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        long[] arr = new long[nums.length];

        for (List<Integer> indices : groups.values()) {
            int n = indices.size();
            if (n == 1) continue;

            // Build prefix sum
            long[] prefix = new long[n + 1];
            for (int k = 0; k < n; k++) {
                prefix[k + 1] = prefix[k] + indices.get(k);
            }

            long total = prefix[n];

            for (int p = 0; p < n; p++) {
                long i = indices.get(p);
                long leftSum  = prefix[p];
                long rightSum = total - prefix[p + 1];
                long leftCount  = p;
                long rightCount = n - p - 1;

                arr[(int) i] = (i * leftCount - leftSum) + (rightSum - i * rightCount);
            }
        }

        return arr;
    }
}