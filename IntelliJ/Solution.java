import java.util.HashMap;
import java.util.Map;

public class Solution {



    public static void main(String[] args) {
//        2번
//        public static int solution(int[] a, int[] b, int duration, int distance) {
//            int answer = 0;
//            int start = Math.min(a[0], b[0]);
//            int startMax = Math.max(a[0], b[0]);
//            int end = Math.max(a[1], b[1]);
//            int aTime = 0, bTime = 0;
//
//            boolean flag = false;
//            for (int i = start; i <= end; i++) { // 1시부터 6시까지
//                if (a[0] < i && aTime + bTime < distance) aTime++;
//                if (b[0] < i && aTime + bTime < distance) bTime++;
//
//                int sum = aTime + bTime;
//                if (sum == distance && i >= startMax) {
//                    answer = i;
//                    i += duration;
//                    flag = true;
//                } else if (sum - 1 == distance && i >= startMax) {
//                    if (a[1] < b[1]) aTime -= 1; // 더 집에 빨리 들어가야 하는 사람
//                    else bTime -= 1;
//                    answer = i;
//                    i += duration;
//                    flag = true;
//                }
//
//                if (flag && sum <= a[1] - i + b[1] - i) {// 만난 뒤 집으로 가는 시간
//                    return answer;
//                } else if (flag) {
//                    return -1;
//                }
//            }
//            return 0;
//        System.out.println(
//                solution(new int[]{3, 5},
//                        new int[]{1, 5},
//                        1, 2));
//        System.out.println(
//                solution(new int[]{1, 6},
//                        new int[]{3, 5},
//                        1, 2));
//        System.out.println(
//                solution(new int[]{1, 6},
//                        new int[]{2, 5},
//                        1, 3));
//        System.out.println(
//                solution(new int[]{1, 4},
//                        new int[]{1, 4},
//                        1, 2));
//        System.out.println(
//                solution(new int[]{1, 50},
//                        new int[]{51, 100},
//                        100, 100));
//        1번
//        public static int solution(int k, int m, String[] names, int[] amounts) {
//            int answer = 0;
//            int cnt = 1;
//            String name = (names[0]).toUpperCase();
//            if(cnt >= k || amounts[0] >= m) answer++;
//            for (int i = 1; i < names.length; i++) {
//                String name2 = (names[i]).toUpperCase();
//                if(name2.equals(name)) cnt++;
//                else cnt = 1;
//                if(cnt >= k || amounts[i] >= m) answer++;
//                name = name2;
//                System.out.println(name);
//            }
//            return answer;
//        }
//        System.out.println(solution(3, 50000,
//                new String[]{"msLEE", "jsKim", "jsKIM", "jskiM", "jskim", "John", "john", "John", "msLEE", "msLEE", "jsKIM", "roy"},
//                new int[]{950, 52524, 1400, 6055, 10000, 4512, 512, 52000, 9000, 49000, 1400, 50000}));
//        System.out.println(solution(1, 3451,
//                new String[]{"abcd", "aBCd", "jsKIM", "rrr", "rrr"},
//                new int[]{950, 1000, 1400, 4000, 10000}));
    }
}

/*
import java.util.*;

public class TESTT {

    static char[][] map;

    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Set<Integer> xSet;
    static Set<Integer> ySet;

    public static boolean[] solution() { // String[][] grids
        String[][] grids = {{"XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"}};
        int H = grids.length;
        boolean[] answer = new boolean[H];

        for (int i = 0; i < H; i++) { // 1개
            int R = grids[i].length;
            map = new char[R][];
            for (int j = 0; j < R; j++) { // 1개의 행 안에 있는 열 개수
//                System.out.println(Arrays.toString());
                map[j] = grids[i][j].toCharArray();
            }

            xSet = new HashSet<>();
            ySet = new HashSet<>();
            boolean stats = false;
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < map[R].length; k++) {
                    if(map[j][k] == 'X') stats = bfs(j, k);
                }
            }

        }
        return answer;
    }

    public static boolean bfs(int y, int x) {
        int r = map.length;
        int c = map[y].length;
        boolean[][] visited = new boolean[r][c];
        visited[y][x] = true;
        q.offer(new int[]{y, x});
        ySet.add(y);
        xSet.add(x);

        while (!q.isEmpty()) {
            int[] position = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = position[0] + dy[i];
                int nx = position[1] + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visited[ny][nx]) continue;

                if (map[ny][nx] == 'X') {
                    visited[ny][nx] = true;
                    map[ny][nx] = '.';
                } else q.offer(new int[]{ny, nx});
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution()));
    }
}












 */