import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ____BOJ_G2_17143_낚시왕 {
    static int R, C, M, ans = 0;
    static int r, c, s, d, z;
    static int[][] map, copyMap, shark;

    static int[] direc = {0, 1, 2, 3, 4};
    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        shark = new int[M][5];

        for (int i = 0; i < 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                shark[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) map[shark[i][0]][shark[i][1]] = i + 1;

        for (int i = 1; i <= C; i++) {
            System.out.println("Before moving");
            for (int[] ints : map) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
            catchShark(i);
            copyMap = new int[R + 1][C + 1];
            moveShark();
            System.out.println("After moving");
            for (int[] ints : map) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
        }
        System.out.println(ans);
    }

    public static void catchShark(int i) {
        int row = 1;
        while (copyMap[row][i] <= 0) {
            row++;
            if (row == R + 1) return;
        }
        ans += shark[copyMap[row][i] - 1][4];
        copyMap[row][i] = 0;
    }

    public static void moveShark() {
        for (int i = 0; i <= R; i++) {
            for (int j = 0; j <= C; j++) {
                if (map[i][j] > 0) {
                    int num = map[i][j] - 1;
                    r = i;
                    c = j;
                    s = shark[num][2];
                    d = shark[num][3];
                    z = shark[num][4];

                    if (d == 1 || d == 2) {
                        if (r == 1) d = 2;
                        else if (r == R) d = 1;
                    } else if (d == 3 || d == 4) {
                        if (c == 1) d = 3;
                        else if (c == C) d = 4;
                    }

                    int t = 0;
                    for (int k = 0; k < s; k++) {
                        int ny = r + dy[direc[d]];
                        int nx = c + dx[direc[d]];
                        r = ny;
                        c = nx;

                        System.out.println("r: " + r + " c: " + c);
                        if (d == 1 || d == 2) {
                            if (ny == 1) {
                                d = 2;
                                shark[num][3] = 2;
                            }
                            else if (ny == R) {
                                d = 1;
                                shark[num][3] = 1;
                            }
                        } else {
                            if (nx == 1) {
                                d = 3;
                                shark[num][3] = 3;
                            }
                            else if (nx == C) {
                                d = 4;
                                shark[num][3] = 4;
                            }
                        }
                    }
                    if (copyMap[r][c] > 0) {
                        if (shark[copyMap[r][c] - 1][4] < z) copyMap[r][c] = num + 1;
                    } else copyMap[r][c] = num + 1;
                }
            }
        }
        for (int i = 0; i <= R; i++) {
            for (int j = 0; j <= C; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }
}
