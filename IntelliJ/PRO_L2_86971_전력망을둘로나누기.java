import java.util.LinkedList;
import java.util.Queue;

public class PRO_L2_86971_전력망을둘로나누기 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}});
    }

    static class Solution {
        public int solution(int n, int[][] wires) {
            int[][] matrix = new int[n + 1][n + 1];
            int len = wires.length;
            for (int i = 0; i < len; i++) {
                int s = wires[i][0];
                int e = wires[i][1];
                matrix[s][e] = matrix[e][s] = 1;
            }

            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                int s = wires[i][0];
                int e = wires[i][1];
                matrix[s][e] = matrix[e][s] = 0;
                ans = Math.min(ans, bfs(n, matrix, s));
                matrix[s][e] = matrix[e][s] = 1;
            }
            return ans;
        }

        public int bfs(int n, int[][] arr, int s) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] isSelected = new boolean[n + 1];

            isSelected[s] = true;
            for (int i = 1; i <= n; i++) {
                if (arr[s][i] == 1) {
                    q.offer(i);
                    isSelected[i] = true;
                }
            }

            while (!q.isEmpty()) {
                int node = q.poll();
                for (int i = 1; i <= n; i++) {
                    if (arr[node][i] == 1 && !isSelected[i]) {
                        q.offer(i);
                        isSelected[i] = true;
                    }
                }
            }

            int tureSum = 0, falseSum = 0;
            for (int i = 1; i <= n; i++) {
                if (isSelected[i]) tureSum++;
                else falseSum++;
            }
            return Math.abs(tureSum - falseSum);
        }
    }
}
