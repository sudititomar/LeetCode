
class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on starting time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        int[] t = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            int[] c = intervals[i];

            if (c[0] <= t[1]) {
                // Merge overlapping intervals
                t[1] = Math.max(t[1], c[1]);
            } 
            else {
                result.add(t);
                t = c;
            }
        }

        result.add(t);

        return result.toArray(new int[result.size()][]);
    }
}
