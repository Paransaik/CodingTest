import java.io.*;
import java.util.StringTokenizer;

public class BOJ_G4_16919_봄버맨2 {
    static int R, C, N;
    static char[][] map;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); // second

        map = new char[R][];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        if (N == 1) {
            first();
        } else if (N % 2 == 0) {
            second();
        } else if (N > 1 && N % 4 == 1) {
            three();
            four();
        } else if (N % 4 == 3) {
            three();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    bw.append(copyMap[i][j]);
                }
                bw.append("\n");
            }
        }
        bw.flush();
    }

    public static void first() throws Exception {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.append(map[i][j]);
            }
            bw.append("\n");
        }
    }

    public static void second() throws Exception {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.append("O");
            }
            bw.append("\n");
        }
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static char[][] copyMap;

    public static void three() throws Exception {
        copyMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                copyMap[i][j] = 'O';
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    copyMap[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'O') continue;
                        copyMap[ny][nx] = '.';
                    }
                }
            }
        }
    }

    static char[][] secondCopyMap;
    public static void four() throws Exception {
        secondCopyMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                secondCopyMap[i][j] = 'O';
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (copyMap[i][j] == 'O') {
                    secondCopyMap[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == 'O') continue;
                        secondCopyMap[ny][nx] = '.';
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.append(secondCopyMap[i][j]);
            }
            bw.append("\n");
        }
    }
}