import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G2_17143_낚시왕 {
    static int R, C, M, ans = 0;
    static int r, c, s, d, z;
    static int[][] map, copyMap, shark;

    // 1 상, 2 하, 3 우, 4 좌
    static int[][] direc = {{0, 0}, {2, 1}, {1, 2}, {3, 4}, {4, 3}};
    static int[] dy = {0, 1, -1, 0, 0};
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
        // r, c, s, d, z
        // r, c, 속력, 이동방향, 크기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                shark[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // map에 상어 맵핑
        for (int i = 0; i < M; i++) map[shark[i][0]][shark[i][1]] = i + 1;

        // 사람이 맵 끝에 도착할 때까지 반복
        for (int i = 1; i <= 2; i++) {
            // 1. 낚시왕이 오른쪽으로 한 칸 이동한다.
            // 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡는다. 상어를 잡으면 격자판에서 잡은 상어가 사라진다.
            catchShark(i);
            // 3. 상어가 이동한다.
            copyMap = new int[R + 1][C + 1];
            moveShark();
            System.out.println("After catchShark");
            for (int[] ints : copyMap) {
                System.out.println(Arrays.toString(ints));
            }
        }

        System.out.println(ans);
    }

    public static void catchShark(int i) {
        int row = 1;
        while (true) {
            if (map[row][i] > 0) break;
            row++;
            if (row == R + 1) return;
        }
        ans += shark[map[row][i] - 1][4];
        map[row][i] = 0;
    }

    public static void moveShark() {
        for (int i = 0; i <= R; i++) {
            for (int j = 0; j <= C; j++) {
                if (map[i][j] > 0) {
                    // 상어가 있음 해당 상어에 해당하는 shack table의 r, c값으로
                    int num = map[i][j] - 1;
                    // r, c, s, d, z
                    // r, c, 속력, 이동방향, 크기
                    r = i;
                    c = j;
                    s = shark[num][2];
                    d = shark[num][3];
                    z = shark[num][4];

                    int t;
                    if (((d == 1 || d == 2) && (r == 1 || r == R)) ||
                            ((d == 3 || d == 4) && (c == 1 || c == C))) t = 1;
                    else t = 0;

                    for (int k = 0; k < s; k++) {
                        if ((d == 1 || d == 2) && (r == 1 || r == R)){
                            t ^= 1;
                            if (d == 1) shark[num][3] += 1;
                            else shark[num][3] -= 1;
                        }else if ((d == 3 || d == 4) && (c == 1 || c == C)){
                            t ^= 1;
                            if (d == 3) shark[num][3] += 1;
                            else shark[num][3] -= 1;
                        }

                        int ny = r + dy[direc[d][t]];
                        int nx = c + dx[direc[d][t]];
                        r = ny;
                        c = nx;
                        System.out.println("rc: " + r + " " + c);
                        System.out.println(shark[6][3]);
                    }

                    // 옮겼는데 copyMap에 상어가 있다면, 크기비교 후 큰 걸 삽입
                    // y, x 축 좌표 copyMap에 매핑
                    // 1 상, 2 하, 3 우, 4 좌
                    // 3 2 4 1 2 4 1 3
                    System.out.println(r + " " + c);
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
