import java.util.*;

class Solution {

    public double minAreaFreeRect(int[][] points) {

        int n = points.length;
        Map<String, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                double midX = (x1 + x2) / 2.0;
                double midY = (y1 + y2) / 2.0;

                double dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

                String key = midX + "," + midY + "," + dist;

                map.computeIfAbsent(key, k -> new ArrayList<>())
                   .add(new int[]{i, j});
            }
        }

        double ans = Double.MAX_VALUE;

        for (List<int[]> list : map.values()) {

            int size = list.size();

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {

                    int p1 = list.get(i)[0];
                    int p2 = list.get(i)[1];
                    int p3 = list.get(j)[0];

                    int[] A = points[p1];
                    int[] B = points[p2];
                    int[] C = points[p3];

                    double v1x = B[0] - A[0];
                    double v1y = B[1] - A[1];

                    double v2x = C[0] - A[0];
                    double v2y = C[1] - A[1];

                    double area = Math.abs(v1x * v2y - v1y * v2x);

                    ans = Math.min(ans, area);
                }
            }
        }

        return ans == Double.MAX_VALUE ? 0 : ans;
    }
}