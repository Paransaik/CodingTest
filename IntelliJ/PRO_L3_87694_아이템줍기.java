import java.util.*;

public class PRO_L3_87694_아이템줍기 {
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8));
//        System.out.println(s.solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7, 6, 1));
        System.out.println(s.solution(new int[][]{{2,1,7,5}, {6,4,10,10}}, 3,1, 7, 10));
    }

    static class Solution {
        static final int mapSize = 24;
        static int[][] map;

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            map = new int[mapSize][mapSize];
            for (int i = 0, len = rectangle.length; i < len; i++) {
                int x1 = rectangle[i][0];
                int y1 = rectangle[i][1];
                int x2 = rectangle[i][2];
                int y2 = rectangle[i][3];

                for (int j = y1 * 2; j <= y2 * 2; j++) {
                    for (int k = x1 * 2; k <= x2 * 2; k++) {
                        map[j][k] = 1;
                    }
                }
            }

            checkBoundary(rectangle[0][0] * 2, rectangle[0][1] * 2);
            map[itemY * 2][itemX * 2] = 3;
            for (int[] ints : map) {
                System.out.println(Arrays.toString(ints));
            }
            return searchItem(characterY * 2, characterX * 2);
        }

        static int[] dy = {0, 0, 1, -1, 1, 1, -1, -1};
        static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};

        public void checkBoundary(int x, int y) {
            boolean[][] visited = new boolean[mapSize][mapSize];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{y, x});
            visited[y][x] = true;
            while (!q.isEmpty()) {
                int[] node = q.poll();
                for (int i = 0; i < 8; i++) {
                    int ny = node[0] + dy[i];
                    int nx = node[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny >= mapSize || nx >= mapSize || visited[ny][nx]) continue;
                    if (map[ny][nx] == 1) {
                        q.offer(new int[]{ny, nx});
                        visited[ny][nx] = true;
                    }
                    if (map[ny][nx] == 0) map[node[0]][node[1]] = 2;
                }
            }
        }

        public int searchItem(int y, int x) {
            boolean[][] visited = new boolean[mapSize][mapSize];
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{y, x, 0});
            visited[y][x] = true;
            while (!q.isEmpty()) {
                int[] node = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = node[0] + dy[i];
                    int nx = node[1] + dx[i];
                    if (ny < 0 || nx < 0 || ny >= mapSize || nx >= mapSize || visited[ny][nx]) continue;
                    if (map[ny][nx] == 2) {
                        q.offer(new int[]{ny, nx, node[2] + 1});
                        visited[ny][nx] = true;
                        map[ny][nx] = 9;
                    }
                    if (map[ny][nx] == 3) return node[2] / 2 + 1;
                }
            }
            return 0;
        }
    }
}
