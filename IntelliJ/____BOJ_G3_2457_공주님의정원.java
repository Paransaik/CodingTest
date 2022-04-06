import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ____BOJ_G3_2457_공주님의정원 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 4, 6, 9, 11 = 30
        // 1, 3, 5, 7, 8, 10, 12 = 31
        // 2 = 28
        // 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        // 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365
        // 60~334

        Map<Integer, Integer> m = new HashMap<Integer, Integer>() {{
            put(1, 0);
            put(2, 31);
            put(3, 59);
            put(4, 90);
            put(5, 120);
            put(6, 151);
            put(7, 181);
            put(8, 212);
            put(9, 243);
            put(10, 273);
            put(11, 304);
            put(12, 334);
        }};

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[i][0] = m.get(a) + b;
            arr[i][1] = m.get(c) + d;
        }
//        Arrays.sort(arr, (ar1, ar2) -> (ar1[0] == ar2[0]) ? ar2[1] - ar1[1] : ar1[0] - ar2[0]);
        Arrays.sort(arr, (ar1, ar2) -> (ar1[0] == ar2[0]) ? ar2[1] - ar1[1] : ar1[0] - ar2[0]);

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        // 처음부터 max값이면?
        int si = 0, cnt = 1;
        int s = arr[0][0], e = arr[0][1];
        for (int i = 1; i < N; i++) {
            if (s <= 60 && e >= 60) {
                if (e <= s) {
                    s = arr[i][0];
                    e = arr[i][1];
                }
            }
        }

        if(s > 60){
            System.out.println(0);
        } else {
            for (int i = si + 1; i < N; i++) {
                if (e >= arr[i][0] && e <= arr[i][1] && arr[i][0] <= 334) {
                    e = arr[i][1];
                    if (e > 334) break;
                    cnt++;
                    System.out.println(arr[i][0] + " " + arr[i][1]);
                }
            }
            if (e <= 334) cnt = 0;
            System.out.println(cnt);
        }

    }
}
