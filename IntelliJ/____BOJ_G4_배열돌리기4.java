import java.io.*;
import java.util.StringTokenizer;

public class ____BOJ_G4_배열돌리기4 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int[][] arr, oper;
    static int R, C, K, r, c, s;
    static int x, y, nx, ny, temp, direction;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // Row 개수
        C = Integer.parseInt(st.nextToken()); // Column 개수
        K = Integer.parseInt(st.nextToken()); // 회전 연산 개수

        System.out.println(R + " " + C + " " + K);
        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        oper = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            oper[i][0] = Integer.parseInt(st.nextToken()) - 1; // 좌측 상단 r-s
            oper[i][1] = Integer.parseInt(st.nextToken()) - 1; // 우측 하단 r+s
            oper[i][2] = Integer.parseInt(st.nextToken()); // 회전 연산 개수
        }


        r = oper[0][0]; // 2
        c = oper[0][1]; // 3
        s = oper[0][2]; // 2
        int cir = Math.min(r, c) / 2;

        // 배열 돌리기
        for (int i = 0; i < cir; i++) {
            System.out.println("--------------------");
            x = c - s; // 0
            y = r - s; // 1

            direction = 0;
            temp = arr[i][i];
            while (direction < 4) {
                nx = x + dx[direction];
                ny = y + dy[direction];

//                    for (int[] is : arr) {
//                        for (int iss : is) bw.append(iss + " ");
//                        bw.append("\n");
//                    }
                System.out.println((c + s - i) + " " + (c - s + i));
                System.out.println((r + s - i) + " " + (r - s + i));
                if (nx > c + s - i || nx < c - s + i || ny > r + s - i || ny < r - s + i) {
                    direction++;
                    continue;
                }
                arr[ny][nx] = arr[y][x];
                x = nx;
                y = ny;
            }
            arr[i + 1][i] = temp;

        }

        for (int[] is : arr) {
            for (int i : is) bw.append(i + " ");
            bw.append("\n");
        }

        bw.flush();
    }

    static int sum, min = Integer.MAX_VALUE;
    public static int minimunArr() {
        for (int i = 0; i < R; i++) {
            sum = 0;
            for (int j = 0; j < C; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}