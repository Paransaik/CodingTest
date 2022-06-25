import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_G4_14499_주사위굴리기 {
    static int N, M, X, Y, K, temp;
    static int[][] map;
    static int[] moves, dice;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        moves = new int[K];
        dice = new int[7];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    if (checkRange(Y, X + 1)) right();
                    break;
                case 2:
                    if (checkRange(Y, X - 1)) left();
                    break;
                case 3:
                    if (checkRange(Y - 1, X)) up();
                    break;
                case 4:
                    if (checkRange(Y + 1, X)) down();
                    break;
            }
        }
    }

    public static boolean checkRange(int y, int x) {
        if (y < 0 || y >= N || x < 0 || x >= M) return false;
        return true;
    }

    public static void right() {
        X++;
        temp = dice[6];
        dice[6] = dice[3];
        dice[3] = dice[1];
        dice[1] = dice[5];
        dice[5] = temp;
        checkUnder();
    }

    public static void left() {
        X--;
        temp = dice[6];
        dice[6] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[3];
        dice[3] = temp;
        checkUnder();
    }

    public static void up() {
        Y--;
        temp = dice[6];
        dice[6] = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[2];
        dice[2] = temp;
        checkUnder();
    }

    public static void down() {
        Y++;
        temp = dice[6];
        dice[6] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[4];
        dice[4] = temp;
        checkUnder();
    }

    public static void checkUnder() {
        if (map[Y][X] == 0) {
            map[Y][X] = dice[6];
        } else {
            dice[6] = map[Y][X];
            map[Y][X] = 0;
        }
        System.out.println(dice[1]);
    }
}
