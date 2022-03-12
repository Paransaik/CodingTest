import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G5_17070_파이프옮기기1 {
    static int N, cnt = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp(1, 0, 1);
        bw.append(String.valueOf(cnt));
        bw.flush();
    }

    public static void dp(int status, int y, int x) {
        if (y == N - 1 && x == N - 1) {
            cnt++;
            return;
        }
        switch (status) {
            case 1: // 가로 일 때
                if (x + 1 < N && map[y][x + 1] != 1) dp(1, y, x + 1); // 가로
                break;
            case 2: // 세로 일 때
                if (y + 1 < N && map[y + 1][x] != 1) dp(2, y + 1, x); // 세로
                break;
            case 3: // 대각선 일 때
                if (x + 1 < N && map[y][x + 1] != 1) dp(1, y, x + 1); // 가로
                if (y + 1 < N && map[y + 1][x] != 1) dp(2, y + 1, x); // 세로
                break;
        }
        if (x + 1 < N && y + 1 < N && map[y][x + 1] != 1 && map[y + 1][x] != 1 && map[y + 1][x + 1] != 1)
            dp(3, y + 1, x + 1); // 대각선
    }
}
