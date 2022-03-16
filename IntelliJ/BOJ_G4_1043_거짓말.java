import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_G4_1043_거짓말 {
    static int N, M, T;
    static int[] tPerson;
    static int[] parents;
    static int[][] party;

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        if (parents[aRoot] > parents[bRoot]) parents[aRoot] = bRoot;
        else parents[bRoot] = aRoot;
        return true;
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 파티 수
        parents = new int[N + 1]; // 부모의 노드 확인할 수 있는 배열

        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        tPerson = new int[T]; // 진실을 아는 사람 배열
        for (int i = 0; i < T; i++) {
            tPerson[i] = Integer.parseInt(st.nextToken());
        }

        party = new int[M][51];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            party[i][0] = num;
            party[i][1] = a;

            for (int j = 0; j < num - 1; j++) {
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
                party[i][j + 2] = b;
                a = b;
            }
        }

        int flag, ans = 0;
        for (int i = 0; i < M; i++) {
            flag = 0;
            int num = party[i][0];
            gl:
            for (int j = 1; j <= num; j++) {
                for (int k = 0; k < T; k++) {
                    if (findSet(party[i][j]) == findSet(tPerson[k])) {
                        flag = 1;
                        break gl;
                    }
                }
            }
            if (flag == 0) ans++;
        }
        System.out.println(ans);
    }
}
