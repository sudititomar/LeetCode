public class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        // group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);

            // no other occurrence exists
            if (list.size() == 1) {
                result.add(-1);
                continue;
            }

            // find position of q in the list
            int pos = Collections.binarySearch(list, q);
            int sz = list.size();
            int best = Integer.MAX_VALUE;

            // check left neighbor (wraps around)
            int left = list.get((pos - 1 + sz) % sz);
            int d1 = Math.abs(q - left);
            best = Math.min(best, Math.min(d1, n - d1));

            // check right neighbor (wraps around)
            int right = list.get((pos + 1) % sz);
            int d2 = Math.abs(q - right);
            best = Math.min(best, Math.min(d2, n - d2));

            result.add(best);
        }

        return result;
    }
}