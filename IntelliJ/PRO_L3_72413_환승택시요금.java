public class PRO_L3_72413_환승택시요금 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
        s.solution(7, 3, 4, 1, new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}});
        s.solution(6, 4, 5, 6, new int[][]{{2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11}, {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}});

    }

    static class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            final int INF = 9999999;
            int[][] adjMatrix = new int[n][n];

            for (int i = 0, len = fares.length; i < len; i++) {
                int start = fares[i][0] - 1;
                int end = fares[i][1] - 1;
                int weight = fares[i][2];
                adjMatrix[start][end] = weight;
                adjMatrix[end][start] = weight;
            }

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i != j && adjMatrix[i][j] == 0) {
                        adjMatrix[i][j] = INF;
                    }
                }
            }

            for (int k = 0; k < n; ++k) {
                for (int i = 0; i < n; ++i) {
                    if (i == k) continue;
                    for (int j = 0; j < n; ++j) {
                        if (i == j || k == j) continue;
                        if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
                            adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                        }
                    }
                }
            }

            s -= 1;
            a -= 1;
            b -= 1;
            int min = adjMatrix[s][a] + adjMatrix[s][b];
            for (int i = 0; i < n; i++) {
                if (i == s || i == a || i == b) continue;
                int cost = adjMatrix[s][i] + adjMatrix[i][a] + adjMatrix[i][b];
                min = Math.min(min, cost);
            }

            System.out.println(min);
            return min;
        }
    }
}
