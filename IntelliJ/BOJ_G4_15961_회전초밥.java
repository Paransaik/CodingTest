import java.io.*;
import java.util.*;

public class BOJ_G4_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        for (int i = 0; i < k; i++) {
            if (count[arr[i]] == 0) cnt++;
            count[arr[i]]++;
        }
        for (int i = 0; i < 31; i++) {
            System.out.print(count[i] + " ");
        }
        int ans = cnt;
        for (int i = k; i < n + k - 1; i++) {
            if (count[c] == 0) {
                ans = Math.max(ans, cnt + 1);
            } else {
                ans = Math.max(ans, cnt);
            }
            count[arr[(i - k) % n]]--;
            if (count[arr[i - k]] == 0) cnt--;
            if (count[arr[i % n]] == 0) cnt++;
            count[arr[i % n]]++;
        }
        System.out.println(ans);
    }
}