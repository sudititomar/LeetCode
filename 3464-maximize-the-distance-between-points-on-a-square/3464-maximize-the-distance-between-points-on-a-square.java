import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        long perimeter = 4L * side;

        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (y == 0) {
                pos[i] = x;
            } else if (x == side) {
                pos[i] = (long) side + y;
            } else if (y == side) {
                pos[i] = 2L * side + (side - x);
            } else {
                pos[i] = 3L * side + (side - y);
            }
        }

        Arrays.sort(pos);

        int low = 1, high = side; 
        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(pos, k, mid, perimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canPlace(long[] pos, int k, int dist, long perimeter) {
        int n = pos.length;
        
        for (int i = 0; i < n; i++) {
            if (i > 0 && pos[i] > pos[0] + dist) break;

            int count = 1;
            long lastPos = pos[i];
            long firstPos = pos[i];
            int currIdx = i;

            for (int j = 1; j < k; j++) {
                int nextIdx = lowerBound(pos, lastPos + dist);
                
                if (nextIdx >= n) {
                    count = -1; 
                    break;
                }
                
                lastPos = pos[nextIdx];
                currIdx = nextIdx;
                count++;
            }

            
            if (count == k && (firstPos + perimeter - lastPos) >= dist) {
                return true;
            }
        }
        return false;
    }

    private int lowerBound(long[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}