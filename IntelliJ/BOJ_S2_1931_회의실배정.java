import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S2_1931_회의실배정 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (ar1, ar2) -> (ar1[1] == ar2[1])? ar1[0] - ar2[0]: ar1[1] - ar2[1]);

        int s, e = arr[0][1];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            s = arr[i][0];
            if (s >= e) {
                cnt++;
                e = arr[i][1];
            }
        }
        System.out.println(cnt);
    }
}
