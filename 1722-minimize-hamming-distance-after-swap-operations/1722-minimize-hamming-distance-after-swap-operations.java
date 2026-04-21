import java.util.*;

class Solution {
    private int[] parent;

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px != py) parent[px] = py;
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] swap : allowedSwaps) union(swap[0], swap[1]);

        // Group indices by root
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++)
            groups.computeIfAbsent(find(i), k -> new ArrayList<>()).add(i);

        int hamming = 0;

        for (List<Integer> indices : groups.values()) {
            // Count source elements in this group
            Map<Integer, Integer> srcCount = new HashMap<>();
            for (int i : indices)
                srcCount.merge(source[i], 1, Integer::sum);

            // Match target elements greedily
            for (int i : indices) {
                int t = target[i];
                if (srcCount.getOrDefault(t, 0) > 0) {
                    srcCount.merge(t, -1, Integer::sum);
                } else {
                    hamming++;
                }
            }
        }

        return hamming;
    }
}