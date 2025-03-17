import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int numPoints = points.length;
        int totalCost = 0;
        boolean[] visited = new boolean[numPoints];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> minDistanceCache = new HashMap<>();
        priorityQueue.offer(new int[]{0, 0});

        while (!priorityQueue.isEmpty()) {
            int[] edge = priorityQueue.poll();
            int edgeCost = edge[0];
            int currentPoint = edge[1];

            if (visited[currentPoint]) {
                continue;
            }

            visited[currentPoint] = true;
            totalCost += edgeCost;

            for (int nextPoint = 0; nextPoint < numPoints; nextPoint++) {
                if (!visited[nextPoint]) {
                    int distance = Math.abs(points[currentPoint][0] - points[nextPoint][0]) + 
                                   Math.abs(points[currentPoint][1] - points[nextPoint][1]);
                    
                    if (distance < minDistanceCache.getOrDefault(nextPoint, Integer.MAX_VALUE)) {
                        minDistanceCache.put(nextPoint, distance);
                        priorityQueue.offer(new int[]{distance, nextPoint});
                    }
                }
            }
        }

        return totalCost;
    }
}
