class Solution {
    public long minimumTotalDistance(List<Integer> robotList, int[][] factoryGrid) {
        Collections.sort(robotList);
        Arrays.sort(factoryGrid, (alpha, beta) -> alpha[0] - beta[0]);

        List<Integer> expandedSlots = new ArrayList<>();
        for (int[] factoryEntry : factoryGrid) {
            for (int capacity = 0; capacity < factoryEntry[1]; capacity++) {
                expandedSlots.add(factoryEntry[0]);
            }
        }

        int totalRobots = robotList.size();
        int totalSlots = expandedSlots.size();
        long upperBound = Long.MAX_VALUE / 2;

        long[][] minCost = new long[totalRobots + 1][totalSlots + 1];
        for (long[] row : minCost) Arrays.fill(row, upperBound);
        for (int slotIdx = 0; slotIdx <= totalSlots; slotIdx++) minCost[0][slotIdx] = 0;

        for (int robotIdx = 1; robotIdx <= totalRobots; robotIdx++) {
            for (int slotIdx = robotIdx; slotIdx <= totalSlots; slotIdx++) {
                minCost[robotIdx][slotIdx] = minCost[robotIdx][slotIdx - 1];

                long accumulatedDistance = 0;
                for (int groupLen = 1; groupLen <= robotIdx; groupLen++) {
                    if (slotIdx - groupLen < 0) break;
                    accumulatedDistance += Math.abs(robotList.get(robotIdx - groupLen) - expandedSlots.get(slotIdx - groupLen));
                    if (minCost[robotIdx - groupLen][slotIdx - groupLen] < upperBound) {
                        minCost[robotIdx][slotIdx] = Math.min(minCost[robotIdx][slotIdx], minCost[robotIdx - groupLen][slotIdx - groupLen] + accumulatedDistance);
                    }
                }
            }
        }

        return minCost[totalRobots][totalSlots];
    }
}